package edu.cibertec.capitulo6.lab01.controller2;

import edu.cibertec.capitulo6.lab01.model.Departamento;
import edu.cibertec.capitulo6.lab01.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos2")
public class DepartamentoController2 {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> listarDepartamentos() {
        return ResponseEntity.ok(departamentoService.listarDepartamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarDepartamento(@PathVariable Long id) {
        return ResponseEntity.ok(departamentoService.buscarDepartamento(id));
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
