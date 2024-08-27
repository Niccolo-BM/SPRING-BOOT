package com.eventos.eventos.controlator;

import com.eventos.eventos.entity.Evento;
import com.eventos.eventos.services.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
    @RequestMapping("/eventos")
    public class Controlator {

        @Autowired
        private Servicio servicioEvento;

        @PostMapping
        public Evento crearEvento(@RequestBody Evento evento) {
            evento.setFecha(LocalDateTime.now());
            return servicioEvento.crearEvento(evento);
        }

        @GetMapping
        public List<Evento> leerEventos() {
            return servicioEvento.leerEventos();
        }


        @GetMapping("/{id}")
        public Evento leerEventosPorId(@PathVariable String id) {
            return servicioEvento.leerEventoPorId(id);
        }

        @PutMapping("/{id}")
        public Evento actualizarEvento(@PathVariable String id, @RequestBody Evento evento) {
            evento.setFecha(LocalDateTime.now());
            return servicioEvento.actualizarEvento(id, evento);
        }

        @DeleteMapping("/{id}")
        public void eliminarEvento(@PathVariable String id) {
            servicioEvento.eliminarEvento(id);
        }
    }

