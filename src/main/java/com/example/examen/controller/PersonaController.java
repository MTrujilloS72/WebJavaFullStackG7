package com.example.examen.controller;

import com.example.examen.entity.PersonaEntity;
import com.example.examen.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona/v1")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/crear")
    public ResponseEntity<PersonaEntity> crearPersona(@RequestBody PersonaEntity persona){
        PersonaEntity nuevaPersona = personaService.crearPersona(persona);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
    }

    @GetMapping("/buscartodos")
    public List<PersonaEntity> buscarTodos(){
        return personaService.buscarTodos();
    }

    @GetMapping("/buscarpodocumento/{numdoc}")
    public ResponseEntity<PersonaEntity> buscaPersonaPorDocumento(@PathVariable String numdoc){
        PersonaEntity persona = personaService.buscarPersonaXNumdoc(numdoc);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PersonaEntity> actualizaPersona(@PathVariable Long id, @RequestBody PersonaEntity persona){
        PersonaEntity personaActualizada = personaService.actualizarPersona(id, persona);
        return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{documento}")
    public ResponseEntity<PersonaEntity> eliminarPersona(@PathVariable String documento){
        personaService.eliminarPersona(documento);
        return null;
    }
}
