package com.autentica.service;

import com.autentica.domain.Personas;
import com.autentica.repository.PersonasRepository;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class PersonasServices {

    private PersonasRepository personasRespository;

    public PersonasServices(PersonasRepository personasRespository){
        this.personasRespository=personasRespository;
    }

    public List<Personas> findAllPerosnas(){
        return personasRespository.findAll();
    }


    public @NonNull Optional<Personas> getPersonaById(Long id) {
        return personasRespository.findById(id);
    }

    public Personas createPersona(Personas personas) {
        personasRespository.save(personas);
        return personas;
    }

    public Personas updatePersona(Long id, Personas personas) {
        Optional<Personas> existingPersonaOptional = personasRespository.findById(id);

        if (existingPersonaOptional.isPresent()) {
            Personas existingPersona = existingPersonaOptional.get();
            existingPersona.setNombre(personas.getNombre());
            return personasRespository.update(existingPersona);
        }
        return null;
    }

    public void deletePersona(Long id) {
        personasRespository.deleteById(id);
    }
}
