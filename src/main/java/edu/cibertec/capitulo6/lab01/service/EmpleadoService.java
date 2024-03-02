package edu.cibertec.capitulo6.lab01.service;

import edu.cibertec.capitulo6.lab01.model.Departamento;
import edu.cibertec.capitulo6.lab01.model.Empleado;

import java.util.List;

public interface EmpleadoService {

	List<Empleado> listarEmpleados();

	Empleado registrarEmpleado(Empleado empleado);

	Empleado actualizarEmpleado(Empleado empleado);

	Empleado buscarEmpleado(Long id);

	List<Empleado> buscarEmpleadosPorDepartamento(Departamento departamento);

	void eliminarEmpleado(Long id);
}
