CREATE DATABASE IF NOT EXISTS capitulo6;

USE capitulo6;

DROP TABLE IF EXISTS departamentos;
DROP TABLE IF EXISTS empleados;

CREATE TABLE departamentos (
   id bigint NOT NULL AUTO_INCREMENT,
   descripcion varchar(100) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE empleados (
   id bigint NOT NULL AUTO_INCREMENT,
   fecha_ingreso date DEFAULT NULL,
   nombre varchar(200) NOT NULL,
   salario decimal(10,2) DEFAULT NULL,
   departamento_id bigint DEFAULT NULL,
   PRIMARY KEY (id)
);

ALTER TABLE empleados ADD CONSTRAINT FK_empleados_departamentos FOREIGN KEY (departamento_id) REFERENCES departamentos (id);