use agenda;


drop table if exists tiposDeContacto;
drop table if exists domicilios;
drop table if exists personas;

CREATE TABLE  tiposDeContacto
(
	Tipo varchar(30) not null,
    primary key (Tipo)
);

CREATE TABLE  domicilios
(
	idDomicilio int not null auto_increment,
	calle varchar (45) not null,
	altura int not null,
	piso int not null,
	departamento varchar(15) not null,
	localidad varchar(45) not null,
    primary key (idDomicilio)
);

CREATE TABLE  personas 
(
  idPersona int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(45) NOT NULL,
  Telefono varchar(20) NOT NULL,
  Mail varchar(45) NOT NULL,
  Cumpleanios date NOT NULL,
  Tipo varchar(30) NOT NULL,
  Domicilio int not null,
  PRIMARY KEY (idPersona),
  FOREIGN KEY (Tipo) references tiposDeContacto (Tipo),
  FOREIGN KEY (Domicilio) references domicilios (idDomicilio)
);
