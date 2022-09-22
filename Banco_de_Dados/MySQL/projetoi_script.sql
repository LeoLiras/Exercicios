-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema projeto-farmacia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projeto-farmacia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projeto-farmacia` ;
USE `projeto-farmacia` ;

-- -----------------------------------------------------
-- Table `projeto-farmacia`.`tipos_produtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto-farmacia`.`tipos_produtos` ;

CREATE TABLE IF NOT EXISTS `projeto-farmacia`.`tipos_produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto-farmacia`.`fabricantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto-farmacia`.`fabricantes` ;

CREATE TABLE IF NOT EXISTS `projeto-farmacia`.`fabricantes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto-farmacia`.`produtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto-farmacia`.`produtos` ;

CREATE TABLE IF NOT EXISTS `projeto-farmacia`.`produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `designacao` VARCHAR(45) NOT NULL,
  `composicao` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `preco_venda` DECIMAL(8,2) NOT NULL,
  `id_tipo_produto` INT NOT NULL,
  `id_fabricante` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produtos_1_idx` (`id_tipo_produto` ASC),
  INDEX `fk_produtos_2_idx` (`id_fabricante` ASC),
  CONSTRAINT `fk_produtos_1`
    FOREIGN KEY (`id_tipo_produto`)
    REFERENCES `projeto-farmacia`.`tipos_produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtos_2`
    FOREIGN KEY (`id_fabricante`)
    REFERENCES `projeto-farmacia`.`fabricantes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto-farmacia`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto-farmacia`.`clientes` ;

CREATE TABLE IF NOT EXISTS `projeto-farmacia`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `endereco` VARCHAR(200) NOT NULL,
  `cep` VARCHAR(10) NOT NULL,
  `localidade` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto-farmacia`.`compras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto-farmacia`.`compras` ;

CREATE TABLE IF NOT EXISTS `projeto-farmacia`.`compras` (
  `id` INT NOT NULL,
  `id_cliente` INT NOT NULL,
  `data_compra` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_compras_1_idx` (`id_cliente` ASC),
  CONSTRAINT `fk_compras_1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `projeto-farmacia`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto-farmacia`.`produtos_compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto-farmacia`.`produtos_compra` ;

CREATE TABLE IF NOT EXISTS `projeto-farmacia`.`produtos_compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_compra` INT NOT NULL,
  `id_produto` INT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produtos_compra_1_idx` (`id_compra` ASC),
  INDEX `fk_produtos_compra_2_idx` (`id_produto` ASC),
  CONSTRAINT `fk_produtos_compra_1`
    FOREIGN KEY (`id_compra`)
    REFERENCES `projeto-farmacia`.`compras` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtos_compra_2`
    FOREIGN KEY (`id_produto`)
    REFERENCES `projeto-farmacia`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto-farmacia`.`medicos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto-farmacia`.`medicos` ;

CREATE TABLE IF NOT EXISTS `projeto-farmacia`.`medicos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto-farmacia`.`receitas_medica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto-farmacia`.`receitas_medica` ;

CREATE TABLE IF NOT EXISTS `projeto-farmacia`.`receitas_medica` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_produto_compra` INT NOT NULL,
  `id_medico` INT NOT NULL,
  `receita` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_receitas_medica_1_idx` (`id_produto_compra` ASC),
  INDEX `fk_receitas_medica_2_idx` (`id_medico` ASC),
  CONSTRAINT `fk_receitas_medica_1`
    FOREIGN KEY (`id_produto_compra`)
    REFERENCES `projeto-farmacia`.`produtos_compra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_receitas_medica_2`
    FOREIGN KEY (`id_medico`)
    REFERENCES `projeto-farmacia`.`medicos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
