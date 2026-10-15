
package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conexion {

    private static final Logger log = LogManager.getLogger(Conexion.class);

    public static Connection getConnection() {

        Connection con = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/apijdbc",
                    "postgres",
                    "Luffyzoro96.."
            );

            log.info("Conexion realizada");

        } catch (SQLException e) {
            log.error("Error de conexion: " + e.getMessage());
        }

        return con;
    }
}
