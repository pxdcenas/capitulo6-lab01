package edu.cibertec.capitulo6.lab01;

import edu.cibertec.capitulo6.lab01.model.Departamento;
import edu.cibertec.capitulo6.lab01.model.Empleado;
import edu.cibertec.capitulo6.lab01.service.DepartamentoService;
import edu.cibertec.capitulo6.lab01.service.EmpleadoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Capitulo6Lab01ApplicationTests {

	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private EmpleadoService empleadoService;

	@Test
	void contextLoads() {
	}

	@Test
	void testBuscarEmpleadosPorDepartamento(){
		Departamento departamento = departamentoService.buscarDepartamento(2L);
		List<Empleado> empleadosPorDepartamento = empleadoService.buscarEmpleadosPorDepartamento(departamento);

		assertEquals(3, empleadosPorDepartamento.size());
	}

}
