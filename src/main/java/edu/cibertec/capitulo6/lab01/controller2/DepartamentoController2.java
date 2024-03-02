package edu.cibertec.capitulo6.lab01.controller2;

import edu.cibertec.capitulo6.lab01.model.Departamento;
import edu.cibertec.capitulo6.lab01.model.Empleado;
import edu.cibertec.capitulo6.lab01.service.DepartamentoService;
import edu.cibertec.capitulo6.lab01.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController2 {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> listarDepartamentos() {
        return ResponseEntity.ok(departamentoService.listarDepartamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarDepartamento(@PathVariable Long id) {
        Departamento departamento = departamentoService.buscarDepartamento(id);
        departamento.add(linkTo(methodOn(DepartamentoController2.class).buscarDepartamento(id)).withSelfRel());
        return ResponseEntity.ok(departamento);
    }

    @GetMapping("/{id}/empleados")
    public ResponseEntity<List<Empleado>> buscarEmpleadosPorDepartamento(@PathVariable Long id) {
        Departamento departamento = departamentoService.buscarDepartamento(id);
        List<Empleado> empleados = empleadoService.buscarEmpleadosPorDepartamento(departamento);
        for (Empleado empleado : empleados){
            empleado.add(linkTo(methodOn(EmpleadoController2.class).buscarEmpleado(empleado.getId())).withSelfRel());
        }
        return ResponseEntity.ok(empleados);
    }


    @PostMapping
    public ResponseEntity<Departamento>  registrarDepartamento(@RequestBody Departamento departamento){
        return ResponseEntity.ok(departamentoService.registrarDepartamento(departamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento>  actualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento){
        departamento.setId(id);
        return ResponseEntity.ok(departamentoService.actualizarDepartamento(departamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDepartamento(@PathVariable Long id){
        departamentoService.eliminarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}
