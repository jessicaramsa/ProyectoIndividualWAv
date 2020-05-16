/**
 * Author:  jessicaramsa
 * Created: 7/03/2020
 */

CREATE DATABASE videojuegos;
USE videojuegos;

CREATE TABLE videojuego(
	clave int(6),
	nombre varchar(150),
	genero varchar(150),
	plataforma varchar(150),
	precio varchar(150)
);

INSERT INTO videojuego VALUES(029010, 'Cities Skylines', 'Constructor', 'PC', '300');
INSERT INTO videojuego VALUES(108249, 'Celeste', 'Indie', 'PC/Nintendo Switch', '500');
INSERT INTO videojuego VALUES(120945, 'Bad North Jotunn Edition', 'Combate', 'PC', '200');
INSERT INTO videojuego VALUES(092375, 'Fox Game', 'RPG', 'PC', '900');
INSERT INTO videojuego VALUES(834902, 'Mortal Kombat', 'Combate', 'PC', '599');

CREATE TABLE usuario(
    id bigint not null auto_increment primary key,
    nombre varchar(100) not null,
    apellidos varchar(100) not null,
    rol varchar(20) not null,
    username varchar(100) not null,
    password varchar(250) not null,
    email varchar(100) not null
);

INSERT INTO usuario(nombre, apellidos, rol, username, password, email)
VALUES('Jessica', 'Ramirez', 'admin', 'jessica', 'una_facil', 'jessicaramsa@gmail.com');
INSERT INTO usuario(nombre, apellidos, rol, username, password, email)
VALUES('Angélica', 'Ortiz', 'prueba', 'prueba', 'una_facil', 'prueba@gmail.com');
