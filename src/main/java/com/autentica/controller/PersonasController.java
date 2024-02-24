package com.autentica.controller;

import com.autentica.domain.Personas;
import com.autentica.service.PersonasServices;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller("api/personas")
public class PersonasController {

    private PersonasServices personasServices;

    public PersonasController(PersonasServices personasServices){
        this.personasServices=personasServices;
    }

    @Get("/")
    public List<Personas> getAllPersons() {
        return personasServices.findAllPerosnas();
    }

    @Post("/")
    public Personas createPersona(@Body Personas personas) {
        return personasServices.createPersona(personas);
    }

    @Put("/")
    public Personas updatePersona(@Body Personas personas) {
        return personasServices.updatePersona(personas);
    }

    @Delete("/{id}")
    public HttpResponse<?> deletePersona(Long id) {
        personasServices.deletePersona(id);
        return HttpResponse.noContent();
    }

}
