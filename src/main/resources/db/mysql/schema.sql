CREATE DATABASE IF NOT EXISTS capitulo6;

USE capitulo6;

DROP TABLE IF EXISTS departamentos;
DROP TABLE IF EXISTS empleados;
DROP TABLE IF EXISTS auditorias;

CREATE TABLE departamentos (
   id bigint NOT NULL AUTO_INCREMENT,
   descripcion varchar(100) NOT NULL,
   PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE empleados (
   id bigint NOT NULL AUTO_INCREMENT,
   fecha_ingreso date DEFAULT NULL,
   nombre varchar(200) NOT NULL,
   salario decimal(10,2) DEFAULT NULL,
   departamento_id bigint DEFAULT NULL,
   PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE auditorias (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  fecha datetime(6) DEFAULT NULL,
  operacion varchar(255) DEFAULT NULL,
  departamento_id bigint(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE empleados ADD CONSTRAINT FK_empleados_departamentos FOREIGN KEY (departamento_id) REFERENCES departamentos (id);
ALTER TABLE auditorias ADD CONSTRAINT FK_auditorias_departamentos FOREIGN KEY (departamento_id) REFERENCES departamentos (id)
