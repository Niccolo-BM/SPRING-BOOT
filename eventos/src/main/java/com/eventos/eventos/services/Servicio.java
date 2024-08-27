package com.eventos.eventos.services;

import com.eventos.eventos.entity.Evento;
import com.eventos.eventos.repository.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class Servicio {

    @Autowired
    private EventoRepositorio elEvento;

    public Evento crearEvento(Evento evento) {
        if (evento.getFecha().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("no puede existir un evento en una fehca ya pasada");
        }
        if (evento.getCapacidad() < 0) {
            throw new IllegalArgumentException("el evento no puede tener capacidad 0");
        }
        return elEvento.save(evento);
    }

    public List<Evento> leerEventos() {
        return elEvento.findAll();
    }

    public Evento leerEventoPorId(String id) {
        return elEvento.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encuetra ese evento"));
    }

    public Evento actualizarEvento(String id, Evento eventoActualizado) {
        Evento evento = leerEventoPorId(id);
        evento.setNombre(eventoActualizado.getNombre());
        evento.setFecha(eventoActualizado.getFecha());
        evento.setUbicacion(eventoActualizado.getUbicacion());
        evento.setCapacidad(eventoActualizado.getCapacidad());
        return elEvento.save(evento);
    }

    public void eliminarEvento(String id) {
        elEvento.deleteById(id);
    }


}
