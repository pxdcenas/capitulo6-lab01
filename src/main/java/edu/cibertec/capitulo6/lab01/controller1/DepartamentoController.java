package edu.cibertec.capitulo6.lab01.controller1;

import edu.cibertec.capitulo6.lab01.dto.ErrorDTO;
import edu.cibertec.capitulo6.lab01.model.Departamento;
import edu.cibertec.capitulo6.lab01.service.DepartamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/departamentos1")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @ExceptionHandler(Exception.class)
    private ResponseEntity manejarExcepciones(){
        ErrorDTO error = new ErrorDTO(HttpStatus.CONFLICT.toString(),"Problema interno","Verique su request");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
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
        try {
            return departamentoService.buscarDepartamento(id);
        } catch (NoSuchElementException err){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento no encontrado", err);
        }
    }

    @GetMapping
    public List<Departamento> listarDepartamentos() {
        return departamentoService.listarDepartamentos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento registrarDepartamento(@RequestBody Departamento departamento) {
        try {
            return departamentoService.registrarDepartamento(departamento);
        } catch (DataIntegrityViolationException err){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Departamento no puso ser creado", null);
        }
    }

    @PutMapping("/{id}")
    public Departamento actualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        departamento.setId(id);
        return departamentoService.actualizarDepartamento(departamento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarDepartamento(@PathVariable Long id) {
        departamentoService.eliminarDepartamento(id);
    }
}
