package edu.cibertec.capitulo6.lab01.repository;

import edu.cibertec.capitulo6.lab01.model.Auditoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "auditoria")
public interface AuditoriaRepository extends CrudRepository<Auditoria, Long> {

    List<Auditoria> findByOperacionContains(@Param("operacion") String operacion);
}
