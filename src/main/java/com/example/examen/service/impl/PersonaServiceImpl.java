package com.example.examen.service.impl;

import com.example.examen.Constantes;

import com.example.examen.entity.PersonaEntity;
import com.example.examen.repository.PedidoRepository;
import com.example.examen.repository.PersonaRepository;
import com.example.examen.service.PedidoService;
import com.example.examen.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final PedidoRepository pedidoRepository;
    private final PedidoService pedidoService;

    public PersonaServiceImpl(PersonaRepository personaRepository, PedidoRepository pedidoRepository, PedidoService pedidoService) {
        this.personaRepository = personaRepository;
        this.pedidoRepository = pedidoRepository;
        this.pedidoService = pedidoService;
    }

    @Override
    public PersonaEntity crearPersona(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<PersonaEntity> buscarTodos() {
        return personaRepository.findAll();
    }

    @Override
    public PersonaEntity buscarPersonaXNumdoc(String numdoc) {
        return personaRepository.findPersonaByNumdoc(numdoc);
    }

    @Override
    public PersonaEntity buscarPersonaPorId(Long id) {
        return personaRepository.findById(id).orElseThrow(()->
                new NoSuchElementException("Persona no encontrada"));
    }

    @Override
    public PersonaEntity actualizarPersona(Long id, PersonaEntity persona) {
        PersonaEntity personaEncontrada = buscarPersonaPorId(id);
        personaEncontrada.setNombres(persona.getNombres());
        personaEncontrada.setApellidos(persona.getApellidos());
        personaEncontrada.setNumdoc(persona.getNumdoc());
        personaEncontrada.setEstado(persona.getEstado());

        return personaRepository.save(personaEncontrada);
    }

    @Override
    public PersonaEntity eliminarPersona(String numdoc) {
        PersonaEntity personaEncontrada = buscarPersonaXNumdoc(numdoc);
        personaEncontrada.setEstado(Constantes.INACTIVO);

        return personaRepository.save(personaEncontrada);
    }
}
