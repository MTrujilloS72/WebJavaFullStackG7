package com.example.examen.service;

import com.example.examen.entity.PersonaEntity;
import java.util.List;

public interface PersonaService {
    PersonaEntity crearPersona(PersonaEntity persona);
    List<PersonaEntity> buscarTodos();
    PersonaEntity buscarPersonaXNumdoc(String numdoc);
    PersonaEntity buscarPersonaPorId(Long id);
    PersonaEntity actualizarPersona(Long id, PersonaEntity persona);
    PersonaEntity eliminarPersona(String numdocumento);
}
