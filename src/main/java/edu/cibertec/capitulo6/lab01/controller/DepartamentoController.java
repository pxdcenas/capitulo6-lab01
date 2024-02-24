package edu.cibertec.capitulo6.lab01.controller;

import edu.cibertec.capitulo6.lab01.model.Departamento;
import edu.cibertec.capitulo6.lab01.service.DepartamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/ip")
//    @ResponseBody
    public String json() {
        String ip = "{\"origin\": \"20.225.105.10\"}";
        return ip;
    }

    @Operation(summary = "Obtener un departamento por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departamento encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Departamento.class))}),
            @ApiResponse(responseCode = "400", description = "Departamento inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Departamento no encontrado",
                    content = @Content)})
    @GetMapping("/{id}")
    public Departamento buscarDepartamento(@PathVariable Long id) {
        return departamentoService.buscarDepartamento(id);
    }

    @GetMapping
    public List<Departamento> listarDepartamentos() {
        return departamentoService.listarDepartamentos();
    }

    @PostMapping
    public Departamento registrarDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.registrarDepartamento(departamento);
    }

    @PutMapping("/{id}")
    public Departamento actualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        departamento.setId(id);
        return departamentoService.actualizarDepartamento(departamento);
    }

    @DeleteMapping("/{id}")
    public void eliminarDepartamento(@PathVariable Long id) {
        departamentoService.eliminarDepartamento(id);
    }
}
