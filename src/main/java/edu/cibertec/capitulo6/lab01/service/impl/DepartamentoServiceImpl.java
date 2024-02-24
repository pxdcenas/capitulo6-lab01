package edu.cibertec.capitulo6.lab01.service.impl;

import edu.cibertec.capitulo6.lab01.model.Departamento;
import edu.cibertec.capitulo6.lab01.repository.DepartamentoRepository;
import edu.cibertec.capitulo6.lab01.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> listarDepartamentos() {
        return (List<Departamento>) departamentoRepository.findAll();
    }

    @Override
    public Departamento registrarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento actualizarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento buscarDepartamento(Long id) {
        return departamentoRepository.findById(id).get();
    }

    @Override
    public void eliminarDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }

}
