package edu.cibertec.capitulo6.lab01.repository;


import edu.cibertec.capitulo6.lab01.model.Departamento;
import edu.cibertec.capitulo6.lab01.model.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

    List<Empleado> findByDepartamento(Departamento departamento);
}
