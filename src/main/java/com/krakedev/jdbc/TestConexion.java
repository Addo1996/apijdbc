
package com.krakedev.jdbc;

import java.sql.Connection;

public class TestConexion {

    public static void main(String[] args) {

        Connection con = null;

        try {
            con = Conexion.getConnection();

            if (con != null) {
                System.out.println("Conexion a PostgreSQL exitosa");
            } else {
                System.out.println("No se pudo conectar a PostgreSQL");
            }

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }
}
