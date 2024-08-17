package com.riwi.gestionTareas.services;

import com.riwi.gestionTareas.models.Tarea;
import com.riwi.gestionTareas.repositories.TareaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

   @Autowired
   private TareaRespository tareaRepository;


   public Tarea create(Tarea tarea){
        tareaRepository.save(tarea);
       return tarea;
   }

   public List<Tarea> readAlltareas(){
        return tareaRepository.findAll();
   }

   public Optional<Tarea> readTareaById(int id){
        return tareaRepository.findById(id);
   }

   public boolean existById(Integer id){
        return tareaRepository.existsById(id);
   }

   public void update(Integer id, Tarea updatedTarea){
        updatedTarea.setId(id);
       tareaRepository.save(updatedTarea);
   }

   public void delete(Integer id){
       tareaRepository.deleteById(id);
   }
}
