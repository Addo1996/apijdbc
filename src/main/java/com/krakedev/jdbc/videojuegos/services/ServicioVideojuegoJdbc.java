
package com.krakedev.jdbc.videojuegos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.jdbc.videojuegos.VideojuegoJdbc;
import com.krakedev.videojuegos.entidades.Videojuego;

@Service
public class ServicioVideojuegoJdbc {

    // Registra un videojuego en PostgreSQL.
    public Videojuego crear(Videojuego videojuego) {
        return VideojuegoJdbc.insertar(videojuego);
    }

    // Obtiene todos los videojuegos registrados.
    public List<Videojuego> listar() {
        return VideojuegoJdbc.listar();
    }

    // Busca un videojuego por su código.
    public Videojuego buscar(String codigo) {
        return VideojuegoJdbc.buscar(codigo);
    }

    // Actualiza los datos de un videojuego existente.
    public Videojuego actualizar(String codigo, Videojuego videojuegoActualizado) {
        videojuegoActualizado.setCodigo(codigo);
        return VideojuegoJdbc.actualizar(videojuegoActualizado);
    }

    // Elimina un videojuego por su código.
    public boolean eliminar(String codigo) {
        return VideojuegoJdbc.eliminar(codigo);
    }
}
