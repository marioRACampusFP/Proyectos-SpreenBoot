package com.nba.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {

    private Connection conexion;

    //Constructor: establece conexión con la base de datos MySQL "nba"
    public JugadorDAO() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/nba";
        String user = "root";
        String password = "curso";
        conexion = DriverManager.getConnection(url, user, password);
    }

    //Busca jugadores por nombre
    public List<String> buscarPorNombre(String nombre) throws SQLException {
        return buscar("nombre", nombre);
    }

    //Busca jugadores por equipo
    public List<String> buscarPorEquipo(String equipo) throws SQLException {
        return buscar("equipo", equipo);
    }

    //Busca jugadores por posición
    public List<String> buscarPorPosicion(String posicion) throws SQLException {
        return buscar("posicion", posicion);
    }

    //Métodoque realiza la consulta SQL usando LIKE y devuelve resultados formateados

    private List<String> buscar(String columna, String valor) throws SQLException {
        String sql = "SELECT * FROM jugadores WHERE " + columna + " LIKE ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, "%" + valor + "%");
        ResultSet rs = ps.executeQuery();
        List<String> resultados = new ArrayList<>();
        while (rs.next()) {

            // Construye una cadena con nombre, equipo, posición y puntos por partido
            resultados.add(rs.getString("nombre") + " - " +
                    rs.getString("equipo") + " - " +
                    rs.getString("posicion") + " - PPG: " +
                    rs.getFloat("puntos_por_partido"));
        }
        return resultados;
    }
}
