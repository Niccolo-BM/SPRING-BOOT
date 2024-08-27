package com.eventos.eventos.repository;

import com.eventos.eventos.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepositorio extends JpaRepository<Evento, String> {
}
