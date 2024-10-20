package com.example.examen.repository;

import com.example.examen.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository  extends JpaRepository<PersonaEntity, Long> {

    PersonaEntity findPersonaByNumdoc(String numdoc);
}
