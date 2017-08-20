use agenda;

drop table if exists personas;
drop table if exists tiposDeContacto; 
drop table if exists domicilios;
drop table if exists localidades;




CREATE TABLE  tiposDeContacto
(
	idTipo int not null auto_increment,
	nombreTipo varchar(30) not null,
    primary key (idTipo)
);


CREATE TABLE localidades
(
	idLocalidad int not null auto_increment,
    nombreLocalidad varchar(45) not null,
    primary key (idLocalidad)
);

CREATE TABLE  domicilios
(
	idDomicilio int not null auto_increment,
	calle varchar (45) not null,
	altura int not null,
	piso int not null,
	departamento varchar(15) not null,
	idLocalidad int not null,
    primary key (idDomicilio),
    foreign key (idLocalidad) references localidades (idLocalidad)
);

CREATE TABLE  personas 
(
  idPersona int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(45) NOT NULL,
  Telefono varchar(20) NOT NULL,
  Mail varchar(45) NOT NULL,
  Cumpleanios date NOT NULL,
  idTipo int NOT NULL,
  idDomicilio int not null,
  PRIMARY KEY (idPersona),
  FOREIGN KEY (idTipo) references tiposDeContacto (idTipo),
  FOREIGN KEY (idDomicilio) references domicilios (idDomicilio)
);



# comandos de insercion de datos, correrlos antes de correr el test!!

insert into tiposDeContacto (nombreTipo) values ('Familia');
insert into tiposDeContacto (nombreTipo) values ('Amigos');
insert into tiposDeContacto (nombreTipo) values ('Trabajo');

insert into localidades (nombreLocalidad) values ('San miguel');

insert into domicilios (calle, altura, piso, departamento, idLocalidad)
 values ('sarasa', 12312, 3, '4b', 1);
 
 insert into personas (Nombre, telefono, mail, cumpleanios, idTipo, idDomicilio)
 values ('Mix 2.0', '123123123', 'ProfeDanielLover@gmail.com', '1995-02-04', 2, 1);
 
 update tiposDeContacto
 set nombreTipo = "familias"
 where idTipo=1;
 
 select * from tiposDeContacto;
 
 
 #Query de verificacion
 
 select * from personas p 
 inner join domicilios d
 on p.idDomicilio = d.idDomicilio
 inner join localidades l
 on d.idLocalidad = l.idLocalidad;
