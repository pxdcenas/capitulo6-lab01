package edu.cibertec.capitulo6.lab01.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "departamentos")
@Getter
@Setter
public class Departamento extends RepresentationModel<Departamento> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;



}
