
package com.krakedev.jdbc.videojuegos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.videojuegos.entidades.Videojuego;
import com.krakedev.jdbc.videojuegos.services.ServicioVideojuegoJdbc;

@RestController
@RequestMapping("/jdbc/videojuegos")
public class VideojuegoJdbcController {

    private final ServicioVideojuegoJdbc servicio;

    public VideojuegoJdbcController(ServicioVideojuegoJdbc servicio) {
        this.servicio = servicio;
    }

    // Registra un videojuego.
    @PostMapping
    public Videojuego crear(@RequestBody Videojuego videojuego) {
        return servicio.crear(videojuego);
    }

    // Consulta todos los videojuegos.
    @GetMapping
    public List<Videojuego> listar() {
        return servicio.listar();
    }

    // Busca un videojuego por su código.
    @GetMapping("/{codigo}")
    public Videojuego buscar(@PathVariable String codigo) {
        return servicio.buscar(codigo);
    }

    // Actualiza un videojuego por su código.
    @PutMapping("/{codigo}")
    public Videojuego actualizar(
            @PathVariable String codigo,
            @RequestBody Videojuego videojuego) {
        return servicio.actualizar(codigo, videojuego);
    }

    // Elimina un videojuego por su código.
    @DeleteMapping("/{codigo}")
    public boolean eliminar(@PathVariable String codigo) {
        return servicio.eliminar(codigo);
    }
}
