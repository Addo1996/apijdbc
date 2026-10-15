
package com.krakedev.jdbc.videojuegos;

import com.krakedev.videojuegos.entidades.Videojuego;

public class TestVideojuegoJdbc {

    public static void main(String[] args) {

        Videojuego videojuego = new Videojuego(
                "VG001",
                "Minecraft",
                "PC",
                39.99,
                true,
                "Sandbox"
        );

        Videojuego guardado = VideojuegoJdbc.insertar(videojuego);

        if (guardado != null) {
            System.out.println("Videojuego insertado correctamente");
            System.out.println(guardado);
        } else {
            System.out.println("No se pudo insertar el videojuego");
        }
    }
}
