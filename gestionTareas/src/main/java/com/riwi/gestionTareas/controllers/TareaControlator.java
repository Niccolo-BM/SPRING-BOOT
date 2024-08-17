package com.riwi.gestionTareas.controllers;


import com.riwi.gestionTareas.models.Tarea;
import com.riwi.gestionTareas.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tareas")
public class TareaControlator {

    @Autowired
    private TareaService tareaService;

    @PostMapping("/create")
    public String createTarea(@ModelAttribute Tarea tarea){
        tareaService.create(tarea);
        return "redirect:/tareas";
    }

    @GetMapping("/{id}")
    public String getTarea(@PathVariable Integer id, Model modelo) {
        Optional<Tarea> tarea = tareaService.readTareaById(id);
        if (tarea.isEmpty()) {
            return "empty";
        }
        List<Tarea> arrayEmpty = new ArrayList<>();
        arrayEmpty.add(tarea.get());
        modelo.addAttribute("tareas", arrayEmpty);
        return "tareas";
    }

    @GetMapping
    public String listarTareas(Model modelo) {
        List<Tarea> tareas = tareaService.readAlltareas();
        modelo.addAttribute("tareas", tareas);
        return "tareas";
    }

    @PostMapping("/edit")
    public String updateTarea(@ModelAttribute Tarea tarea) {
        tareaService.update(tarea.getId(), tarea);
        return "redirect:/tareas";
    }

    @GetMapping("/create")
    public String showFormTarea(Model modelo) {
        modelo.addAttribute("tarea", new Tarea());
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Tarea> tarea = tareaService.readTareaById(id);
        if (tarea.isPresent()) {
            model.addAttribute("tarea", tarea.get());
            return "edit";
        }
        return "redirect:/tareas";
    }

    @PostMapping("/delete/{id}")
    public String deleteTarea(@PathVariable Integer id) {
        if (!tareaService.existById(id)) {
            return "redirect:/tareas";
        }
        tareaService.delete(id);
        return "redirect:/tareas";
    }
}
