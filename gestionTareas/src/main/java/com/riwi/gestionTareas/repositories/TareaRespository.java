package com.riwi.gestionTareas.repositories;

import com.riwi.gestionTareas.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRespository extends JpaRepository<Tarea, Integer> {

}
