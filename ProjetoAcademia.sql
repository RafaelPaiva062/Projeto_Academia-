drop database if exists kinggymbrox ;
create database kinggymbrox;
use kinggymbrox;
 create table funcionario(
 idfuncionario int primary key auto_increment,
 nome varchar(50) not null,
 dataNascimento date not null,
 endereco varchar(50) not null,
 numeroDeRegistro int not null,
 cargo varchar(50) not null,
 senha varchar (50) not null
 );

create table cliente(
idcliente  int primary key auto_increment
);
SHOW TABLES;

CREATE TABLE usuarios (
    idusuario INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL
);
