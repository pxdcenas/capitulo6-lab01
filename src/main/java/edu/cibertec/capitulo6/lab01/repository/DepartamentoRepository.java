package edu.cibertec.capitulo6.lab01.repository;

import edu.cibertec.capitulo6.lab01.model.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(collectionResourceRel = "departamentos", path = "departamentos-dr")
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {

}
