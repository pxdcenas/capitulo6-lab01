package edu.cibertec.capitulo6.lab01.controller1;

import edu.cibertec.capitulo6.lab01.model.Empleado;
import edu.cibertec.capitulo6.lab01.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados1")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> listarEmpleados() {
        return empleadoService.listarEmpleados();
    }

    @PostMapping
    public Empleado registrarEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.registrarEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        empleado.setId(id);
        return empleadoService.actualizarEmpleado(empleado);
    }

    @GetMapping("/{id}")
    public Empleado buscarEmpleado(@PathVariable Long id) {
        return empleadoService.buscarEmpleado(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
    }
}
