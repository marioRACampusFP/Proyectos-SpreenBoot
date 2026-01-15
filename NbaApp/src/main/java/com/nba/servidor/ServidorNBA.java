package com.nba.servidor;

import com.nba.dao.JugadorDAO;
import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.List;

public class ServidorNBA {

    private ServerSocket serverSocket;

    //Constructor: crea el ServerSocket y muestra que el servidor está escuchando
    public ServidorNBA(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
        System.out.println("Servidor NBA escuchando en el puerto " + puerto);
    }

    //Método principal
    public void iniciar() throws IOException {
        while (true) {
            Socket cliente = serverSocket.accept();
            new HiloCliente(cliente).start();
        }
    }

    //Método main: inicia el servidor en el puerto 5000
    public static void main(String[] args) throws IOException {
        ServidorNBA servidor = new ServidorNBA(5000);
        servidor.iniciar();
    }

    //Clase interna que maneja la comunicación con cada cliente en un hilo independiente
    private static class HiloCliente extends Thread {
        private Socket socket;
        private JugadorDAO dao;

        //Constructor: asigna el socket y crea un DAO para acceder a la base de datos
        public HiloCliente(Socket socket) {
            this.socket = socket;
            try {
                dao = new JugadorDAO();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                //Mensaje inicial al cliente
                out.println("Conectado al servidor NBA. Envía tu consulta:");

                String input;
                while ((input = in.readLine()) != null) {

                    //Divide el input en tipo y valor (nombre, equipo, posición)
                    String[] partes = input.split(":", 2);
                    if (partes.length != 2) {
                        out.println("Formato incorrecto. Usa tipo:valor (nombre, equipo, posicion)");
                        continue;
                    }
                    String tipo = partes[0].toLowerCase();
                    String valor = partes[1];

                    List<String> resultados;

                    //Selecciona el método DAO correspondiente según el tipo de búsqueda
                    switch (tipo) {
                        case "nombre":
                            resultados = dao.buscarPorNombre(valor);
                            break;
                        case "equipo":
                            resultados = dao.buscarPorEquipo(valor);
                            break;
                        case "posicion":
                            resultados = dao.buscarPorPosicion(valor);
                            break;
                        default:
                            resultados = List.of("Tipo de búsqueda no válido");
                    }

                    //Envía resultados al cliente o mensaje de "no encontrado"

                    if (resultados.isEmpty()) {
                        out.println("No se encontraron resultados.");
                    } else {
                        resultados.forEach(out::println);
                    }
                    out.println("");
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
