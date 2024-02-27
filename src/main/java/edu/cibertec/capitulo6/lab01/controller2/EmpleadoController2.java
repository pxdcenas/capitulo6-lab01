package edu.cibertec.capitulo6.lab01.controller2;

import edu.cibertec.capitulo6.lab01.controller1.DepartamentoController;
import edu.cibertec.capitulo6.lab01.model.Empleado;
import edu.cibertec.capitulo6.lab01.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController2 {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleado(@PathVariable Long id) {
        Empleado empleado = empleadoService.buscarEmpleado(id);
        empleado.add(linkTo(methodOn(EmpleadoController2.class).buscarEmpleado(empleado.getId())).withSelfRel());
        empleado.add(WebMvcLinkBuilder.linkTo(methodOn(DepartamentoController.class).buscarDepartamento(empleado.getDepartamento().getId())).withRel("departamento"));
        return ResponseEntity.ok(empleado);
    }


    @PostMapping
    public ResponseEntity<Empleado>  registrarEmpleado(@RequestBody Empleado empleado){
        return ResponseEntity.ok(empleadoService.registrarEmpleado(empleado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado>  actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado){
        empleado.setId(id);
        return ResponseEntity.ok(empleadoService.actualizarEmpleado(empleado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id){
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}
