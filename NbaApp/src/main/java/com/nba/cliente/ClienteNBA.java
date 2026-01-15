package com.nba.cliente;

import java.io.*;
import java.net.*;

public class ClienteNBA {

    public static void main(String[] args) {

        //Crea un socket para conectarse al servidor en localhost puerto 5000
        //Crea streams para leer del servidor, escribir al servidor y leer del teclado

        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            //Muestra el mensaje inicial enviado por el servidor
            System.out.println(in.readLine());

            String mensaje;
            while (true) {
                //Solicita al usuario que ingrese una consulta o 'salir'

                System.out.println("Ingrese su consulta (tipo:valor) o 'salir' para terminar:");
                mensaje = teclado.readLine();

                if (mensaje.equalsIgnoreCase("salir")) break; //Termina la conexión si el usuario escribe 'salir'

                //Envía la consulta al servidor
                out.println(mensaje);

                //Lee y muestra la respuesta del servidor línea por línea hasta que encuentre una línea vacía
                String respuesta;
                while ((respuesta = in.readLine()) != null) {
                    if (respuesta.isEmpty()) break;
                    System.out.println(respuesta);
                }
            }

        } catch (IOException e) {

            //Muestra errores de conexión o de entrada/salida
            e.printStackTrace();
        }
    }
}
