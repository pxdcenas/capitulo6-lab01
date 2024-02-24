package edu.cibertec.capitulo6.lab01.service;

import edu.cibertec.capitulo6.lab01.model.Departamento;
import edu.cibertec.capitulo6.lab01.model.Departamento;

import java.util.List;

public interface DepartamentoService {

	List<Departamento> listarDepartamentos();

	Departamento registrarDepartamento(Departamento departamento);

	Departamento actualizarDepartamento(Departamento departamento);

	Departamento buscarDepartamento(Long id);

	void eliminarDepartamento(Long id);
}
