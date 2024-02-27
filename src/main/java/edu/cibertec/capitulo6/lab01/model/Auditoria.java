package edu.cibertec.capitulo6.lab01.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Entity
@Table(name = "auditorias")
@Getter
@Setter
@ToString
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private String operacion;

    @OneToOne
    @JoinColumn(updatable = false, nullable = false)
    private Departamento departamento;
}
