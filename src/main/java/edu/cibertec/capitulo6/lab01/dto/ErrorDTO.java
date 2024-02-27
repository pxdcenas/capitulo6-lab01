package edu.cibertec.capitulo6.lab01.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO {

    private  String status;
    private String error;
    private String message;
}
