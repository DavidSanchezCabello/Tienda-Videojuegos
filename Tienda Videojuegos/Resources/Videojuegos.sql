-- Creacion de la base de datos
create database GameStore character set utf8 collate utf8_spanish2_ci;
use GameStore;
-- Creacion de las tablas
create table Videojuego(idVideojuego integer auto_increment unique not null, titulo varchar(80) not null,
	version varchar(20) not null, genero varchar(45) not null, tipoLicencia varchar(45), cantidadStock integer not null,
    primary key(idVideojuego));
create table Cliente(idCliente integer auto_increment unique not null, nombre varchar(45), apellido
	varchar(45), fechaNacimiento date, dni varchar(9) not null, saldo float not null, primary key
    (idCliente));
create table Venta(idVenta integer not null unique auto_increment, idVideojuegoFK integer not null, idClienteFK integer not null, licencia varchar(45)
	not null, suscripcion boolean not null, primary key(idVenta), foreign key(idVideojuegoFK) references Videojuego(idVideojuego),
    foreign key(idClienteFK) references
    Cliente(idCliente));
-- Realizando los insert
insert into Videojuego values(1, 'Space Engineers', '0.4', 'Sandbox', 'Early access', 20),(2, 'MrHack', '1.0', 'Puzzle',
	'Completa', 5),(3, 'Minecraft', '1.12', 'Sandbox', 'Completo', 80),(4, 'Starcraft 2', '3.10' , 'Estrategia', 'Completo', 10),
    (5, 'Portal', '1.2', 'Puzzle', 'Completo', 15);
insert into Cliente values(1,'Fernando' ,'Soto', "2005-01-15", '46587123L', 0.0), (2,'Juan' ,'Ortiz', "200-10-20", '45982017N', 0.25),
	(3,'Sara' ,'Ruiz', "1998-04-09", '63718529U', 15.1), (4,'Rosa' ,'Espino', "2004-05-05", '12345678W', 150.6), (5,'Pepe' ,'El Cateto',
    "2008-03-01", '57618342C', 3.75);
insert into Venta values(1, 1, 2, 'Completo', false), (2, 4, 3, 'Completo', true),(3, 2, 1,
	'Temporal', true),(4, 5, 3, 'Completo', false), (5, 3, 5, 'Completo', true);