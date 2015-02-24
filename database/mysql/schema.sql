SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `opensigad` DEFAULT CHARACTER SET latin1 ;
USE `opensigad` ;

-- -----------------------------------------------------
-- Table `opensigad`.`territorio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`territorio` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`territorio` (
  `codigo` VARCHAR(5) NOT NULL,
  `descripcion` VARCHAR(145) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`alumno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`alumno` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`alumno` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `num_expediente` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido1` VARCHAR(45) NOT NULL,
  `apellido2` VARCHAR(45) NOT NULL,
  `sexo` ENUM('h','m') NULL DEFAULT NULL,
  `imagen` VARCHAR(245) NULL DEFAULT NULL,
  `tipo_documento` ENUM('dni','nif','pasaporte') NULL DEFAULT NULL,
  `documento` VARCHAR(9) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `localidad_nacimiento` VARCHAR(45) NULL DEFAULT NULL,
  `provincia_nacimiento` VARCHAR(5) NULL DEFAULT NULL,
  `pais_nacimiento` VARCHAR(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `num_expediente_UNIQUE` (`num_expediente` ASC),
  INDEX `fk_alumno_codigo_provincia_idx` (`provincia_nacimiento` ASC),
  INDEX `fk_alumno_codigo_pais_idx` (`pais_nacimiento` ASC),
  CONSTRAINT `fk_alumno_codigo_provincia`
    FOREIGN KEY (`provincia_nacimiento`)
    REFERENCES `opensigad`.`territorio` (`codigo`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_codigo_pais`
    FOREIGN KEY (`pais_nacimiento`)
    REFERENCES `opensigad`.`territorio` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`alumno_contacto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`alumno_contacto` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`alumno_contacto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_alumno` INT(11) NOT NULL,
  `tipo` ENUM('telefono','email') NOT NULL,
  `contacto` VARCHAR(75) NOT NULL,
  `principal` INT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  INDEX `fk_alumno_contacto_id_alumno_idx` (`id_alumno` ASC),
  CONSTRAINT `fk_alumno_contacto_id_alumno`
    FOREIGN KEY (`id_alumno`)
    REFERENCES `opensigad`.`alumno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`alumno_direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`alumno_direccion` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`alumno_direccion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_alumno` INT(11) NOT NULL,
  `domicilio` VARCHAR(45) NULL DEFAULT NULL,
  `codigo_postal` INT(11) NULL DEFAULT NULL,
  `localidad` VARCHAR(45) NULL DEFAULT NULL,
  `provincia` VARCHAR(5) NULL DEFAULT NULL,
  `pais` VARCHAR(5) NULL DEFAULT NULL,
  `principal` INT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idalumno_contacto_UNIQUE` (`id` ASC),
  INDEX `fk_alumno_direccion_id_direccion_idx` (`id_alumno` ASC),
  INDEX `fk_alumno_direccion_codigo_provincia_idx` (`provincia` ASC),
  INDEX `fk_alumno_direccion_codigo_pais_idx` (`pais` ASC),
  CONSTRAINT `fk_alumno_direccion_id_direccion`
    FOREIGN KEY (`id_alumno`)
    REFERENCES `opensigad`.`alumno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_direccion_codigo_provincia`
    FOREIGN KEY (`provincia`)
    REFERENCES `opensigad`.`territorio` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_direccion_codigo_pais`
    FOREIGN KEY (`pais`)
    REFERENCES `opensigad`.`territorio` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`centro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`centro` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`centro` (
  `id` INT(11) NOT NULL,
  `titulo` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion` VARCHAR(245) NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  `cod_postal` VARCHAR(45) NULL DEFAULT NULL,
  `localidad` VARCHAR(45) NULL DEFAULT NULL,
  `provincia` VARCHAR(5) NULL DEFAULT NULL,
  `pais` VARCHAR(5) NULL DEFAULT NULL,
  `website` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`ensenanza_tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`ensenanza_tipo` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`ensenanza_tipo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `curso_escolar` VARCHAR(5) NULL,
  `nombre` VARCHAR(145) NULL,
  `codigo_registro` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `opensigad`.`ensenanza`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`ensenanza` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`ensenanza` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_ensenanza_tipo` INT(11) NULL DEFAULT NULL,
  `codigo_registro` VARCHAR(45) NULL DEFAULT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `horas` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ensenanza_id_tipo_ensenanza_idx` (`id_ensenanza_tipo` ASC),
  CONSTRAINT `fk_ensenanza_id_tipo_ensenanza`
    FOREIGN KEY (`id_ensenanza_tipo`)
    REFERENCES `opensigad`.`ensenanza_tipo` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`alumno_matricula`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`alumno_matricula` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`alumno_matricula` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_alumno` INT(11) NULL DEFAULT NULL,
  `curso_escolar` INT(4) NULL DEFAULT NULL,
  `id_centro` INT(1) NULL DEFAULT NULL,
  `id_ensenanza` INT(1) NULL DEFAULT NULL,
  `modulo` VARCHAR(255) NULL DEFAULT NULL,
  `curso` INT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alumno_matricula_1_idx` (`id_alumno` ASC),
  INDEX `fk_alumno_matricula_id_centro_idx` (`id_centro` ASC),
  INDEX `fk_alumno_matricula_id_ensenanza_idx` (`id_ensenanza` ASC),
  CONSTRAINT `fk_alumno_matricula_id_alumno`
    FOREIGN KEY (`id_alumno`)
    REFERENCES `opensigad`.`alumno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_matricula_id_centro`
    FOREIGN KEY (`id_centro`)
    REFERENCES `opensigad`.`centro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_matricula_id_ensenanza`
    FOREIGN KEY (`id_ensenanza`)
    REFERENCES `opensigad`.`ensenanza` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`ensenanza_ciclo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`ensenanza_ciclo` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`ensenanza_ciclo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_ensenanza` INT(11) NOT NULL,
  `ciclo` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ensenanza_ciclo_id_ensenanza_idx` (`id_ensenanza` ASC),
  CONSTRAINT `fk_ensenanza_ciclo_id_ensenanza`
    FOREIGN KEY (`id_ensenanza`)
    REFERENCES `opensigad`.`ensenanza_ciclo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`ensenanza_curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`ensenanza_curso` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`ensenanza_curso` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_ensenanza_ciclo` INT(11) NULL DEFAULT NULL,
  `curso` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ensenanza_curso_id_ensenanza_ciclo_idx` (`id_ensenanza_ciclo` ASC),
  CONSTRAINT `fk_ensenanza_curso_id_ensenanza_ciclo`
    FOREIGN KEY (`id_ensenanza_ciclo`)
    REFERENCES `opensigad`.`ensenanza_ciclo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`ensenanza_materia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`ensenanza_materia` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`ensenanza_materia` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_ensenanza_curso` INT(11) NOT NULL,
  `materia` VARCHAR(145) NOT NULL,
  `horas_total` INT(11) NULL DEFAULT NULL,
  `horas_semanal` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ensenanza_materia_id_ensenanza_curso_idx` (`id_ensenanza_curso` ASC),
  CONSTRAINT `fk_ensenanza_materia_id_ensenanza_curso`
    FOREIGN KEY (`id_ensenanza_curso`)
    REFERENCES `opensigad`.`ensenanza_curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`alumno_nota`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`alumno_nota` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`alumno_nota` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_alumno_matricula` INT(11) NULL DEFAULT NULL,
  `evaluacion` ENUM('1','2','3','F','E') NULL DEFAULT NULL,
  `id_materia` INT(11) NULL DEFAULT NULL,
  `nota` VARCHAR(45) NULL DEFAULT NULL,
  `observacion` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alumno_nota_id_Matricula_idx` (`id_alumno_matricula` ASC),
  INDEX `fk_alumno_nota_id_materia_idx` (`id_materia` ASC),
  CONSTRAINT `fk_alumno_nota_id_matricula`
    FOREIGN KEY (`id_alumno_matricula`)
    REFERENCES `opensigad`.`alumno_matricula` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_nota_id_materia`
    FOREIGN KEY (`id_materia`)
    REFERENCES `opensigad`.`ensenanza_materia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`alumno_seguimiento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`alumno_seguimiento` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`alumno_seguimiento` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_matricula` INT(11) NOT NULL,
  `fecha` DATE NOT NULL,
  `sesion` VARCHAR(45) NULL DEFAULT NULL,
  `id_materia` INT(1) NULL DEFAULT NULL,
  `tipo` ENUM('falta','incidencia') NOT NULL,
  `justificante` INT(1) NULL DEFAULT '0',
  `observaciones` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alumno_seguimiento_id_matricula_idx` (`id_matricula` ASC),
  INDEX `fk_alumno_seguimiento_id_materia_idx` (`id_materia` ASC),
  CONSTRAINT `fk_alumno_seguimiento_id_matricula`
    FOREIGN KEY (`id_matricula`)
    REFERENCES `opensigad`.`alumno_matricula` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_seguimiento_id_materia`
    FOREIGN KEY (`id_materia`)
    REFERENCES `opensigad`.`ensenanza_materia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`tutor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`tutor` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`tutor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `apellido1` VARCHAR(45) NULL DEFAULT NULL,
  `apellido2` VARCHAR(45) NULL DEFAULT NULL,
  `tipo_documento` ENUM('dni','nif','pasaporte') NULL DEFAULT NULL,
  `documento` VARCHAR(9) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `sexo` ENUM('h','m') NULL DEFAULT NULL,
  `telefono` VARCHAR(15) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`alumno_tutor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`alumno_tutor` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`alumno_tutor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_alumno` INT(11) NOT NULL,
  `id_tutor` INT(11) NOT NULL,
  `parentesco` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alumno_tutor_id_alumno_idx` (`id_alumno` ASC),
  INDEX `fk_alumno_tutor_id_tutor_idx` (`id_tutor` ASC),
  CONSTRAINT `fk_alumno_tutor_id_alumno`
    FOREIGN KEY (`id_alumno`)
    REFERENCES `opensigad`.`alumno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_tutor_id_tutor`
    FOREIGN KEY (`id_tutor`)
    REFERENCES `opensigad`.`tutor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opensigad`.`profesor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opensigad`.`profesor` ;

CREATE TABLE IF NOT EXISTS `opensigad`.`profesor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido1` VARCHAR(45) NOT NULL,
  `apellido2` VARCHAR(45) NOT NULL,
  `tipo_documento` ENUM('dni','nif','pasaporte') NULL DEFAULT NULL,
  `documento` VARCHAR(9) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `sexo` ENUM('h','m') NULL DEFAULT NULL,
  `imagen` VARCHAR(145) NULL DEFAULT NULL,
  `num_registro` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `num_registro_UNIQUE` (`num_registro` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
