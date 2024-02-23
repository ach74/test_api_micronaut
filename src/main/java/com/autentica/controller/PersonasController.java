package com.autentica.controller;

import com.autentica.domain.Personas;
import com.autentica.service.PersonasServices;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller("/personas")
public class PersonasController {

    private PersonasServices personasServices;

    public PersonasController(PersonasServices personasServices){
        this.personasServices=personasServices;
    }

    @Get("/")
    public List<Personas> getAllPersons() {
        return personasServices.findAllPerosnas();
    }

    @Get("/{id}")
    public @NonNull Optional<Personas> getPersonaById(@PathVariable Long id) {
        return personasServices.getPersonaById(id);
    }

    @Post("/")
    public Personas createPersona(@Body Personas personas) {
        return personasServices.createPersona(personas);
    }

    @Put("/{id}")
    public Personas updatePersona(Long id, @Body Personas personas) {
        return personasServices.updatePersona(id, personas);
    }

    @Delete("/{id}")
    public HttpResponse<?> deletePersona(Long id) {
        personasServices.deletePersona(id);
        return HttpResponse.noContent();
    }

    @Post("/agregarPersona/{grupoId}")
    public HttpResponse<String> agregarPersona(@PathVariable Long grupoId, @Body Personas nuevaPersona) {
        return null;
    }

}
