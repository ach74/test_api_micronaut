package com.autentica.repository;

import com.autentica.domain.Personas;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface PersonasRepository extends CrudRepository<Personas, Long> {
    List<Personas> findByGrupoId(Long grupoId);
}
