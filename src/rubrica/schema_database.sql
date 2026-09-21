
DROP DATABASE IF EXISTS Rubrica;

CREATE DATABASE Rubrica;

USE Rubrica;

CREATE TABLE Persona (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    telefono VARCHAR(55) NOT NULL,
    indirizzo VARCHAR(100) NOT NULL,
    eta INT NOT NULL
);

CREATE TABLE Utente (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL
);

INSERT INTO Persona (id, nome, cognome, telefono, indirizzo, eta) VALUES
(1, 'Steve','Jobs','via Cupertino 13','0612344',56),
(2, 'Luigi', 'Verdi', '0987654321', 'Via Milano 2',23),
(3, 'Giulia', 'Bianchi', '5555555555', 'Via Napoli 3',12);