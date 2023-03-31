DROP DATABASE IF EXISTS gestionale_stabili;
CREATE DATABASE gestionale_stabili;
USE gestionale_stabili;

CREATE TABLE Administrator(
	administratorID INTEGER PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(250) NOT NULL UNIQUE,
    pass VARCHAR(250) NOT NULL
);

CREATE TABLE Commonhold(
	commonholdID INTEGER PRIMARY KEY AUTO_INCREMENT,
	commonholdName VARCHAR(250) NOT NULL,
    commonholdAddress VARCHAR(250) NOT NULL,
    uniqueCode VARCHAR(250) NOT NULL UNIQUE,
    administratorRIF INTEGER ,
    FOREIGN KEY (administratorRIF) REFERENCES Administrator(administratorID) ON DELETE SET NULL
);

CREATE TABLE Apartment(
	apartmentID INTEGER PRIMARY KEY AUTO_INCREMENT,
	uniqueCode VARCHAR(250) NOT NULL UNIQUE,
    person VARCHAR(250) NOT NULL,
	pass VARCHAR(250) NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL,
    email VARCHAR(250) NOT NULL,
    commonholdRIF INTEGER NOT NULL,
	FOREIGN KEY (commonholdRIF) REFERENCES Commonhold(commonholdID) ON DELETE CASCADE
);

CREATE TABLE InfoMessage(
	infoMessageID INTEGER PRIMARY KEY AUTO_INCREMENT,
	dateInfoMessage DATE NOT NULL,
    title VARCHAR(250) NOT NULL,
    descriptionInfoMessage VARCHAR(250) NOT NULL,
	commonholdRIF INTEGER NOT NULL,
    FOREIGN KEY (commonholdRIF) REFERENCES Commonhold(commonholdID) ON DELETE CASCADE
);

CREATE TABLE RequestMessage(
    requestID INTEGER PRIMARY KEY AUTO_INCREMENT,
    dateRequest DATE NOT NULL,
    title VARCHAR(250) NOT NULL,
    descriptionInfoMessage VARCHAR(250) NOT NULL,
    uniqueCode VARCHAR(250) NOT NULL UNIQUE,
    requestState ENUM('Creato', 'In Lavorazione', 'Risolto', 'Respinto'),
    apartmentRIF INTEGER NOT NULL,
    FOREIGN KEY (apartmentRIF) REFERENCES Apartment(apartmentID) ON DELETE CASCADE
);

INSERT INTO Administrator (userName, pass) VALUES
('admin1', '1234');

INSERT INTO Commonhold (commonholdAddress, commonholdName, uniqueCode, administratorRIF) 
VALUES ('Via Roma 1', 'Palazzo A', 'ABCD1234', 1),
       ('Via Roma 2', 'Palazzo B', 'EFGH5678', 1),
       ('Via Milano 3', 'Palazzo C', 'IJKL9012', 1);
       
INSERT INTO Apartment (uniqueCode, person, pass, phoneNumber, email, commonholdRIF) 
VALUES ('1A', 'Mario Rossi','1234', '3331234567', 'mario.rossi@example.com', 1),
       ('1B', 'Laura Bianchi','1234', '3339876543', 'laura.bianchi@example.com', 1),
       ('2A', 'Luigi Verdi','1234', '3335554444', 'luigi.verdi@example.com', 2),
       ('3A', 'Alessio Gialli','1234', '3333333333', 'alessio.gialli@example.com', 3),
       ('3B', 'Valentina Viola','1234', '3334445555', 'valentina.viola@example.com', 3);

INSERT INTO InfoMessage (dateInfoMessage, title, descriptionInfoMessage, commonholdRIF) 
VALUES ('2022-03-28', 'Lavori di manutenzione', 'Saranno effettuati lavori di manutenzione nelle scale del palazzo', 1),
       ('2022-03-29', 'Chiusura temporanea ascensore', 'L\'ascensore sarà chiuso per lavori di riparazione fino a date da definirsi', 2),
       ('2022-03-30', 'Incontro condominiale', 'Si comunica che il prossimo incontro condominiale si terrà il 15 aprile alle ore 18:00 nel salone del palazzo', 3);

INSERT INTO RequestMessage (dateRequest, title, descriptionInfoMessage, uniqueCode, requestState, apartmentRIF) 
VALUES 
('2022-01-15', 'Riparazione perdita acqua', 'Richiedo assistenza per la riparazione di una perdita d\'acqua nel bagno principale', 'ABCD1234', 'Creato', 1),
('2022-02-07', 'Sostituzione finestre', 'Richiedo la sostituzione di tutte le finestre dell\'apartment', 'EFGH5678', 'In Lavorazione', 2),
('2022-03-12', 'Riparazione riscaldamento', 'Richiedo assistenza per la riparazione del sistema di riscaldamento', 'IJKL9012', 'Respinto', 3),
('2022-04-02', 'Manutenzione ascensore', 'Richiedo la manutenzione dell\'ascensore del mio commonhold', 'MNOP3456', 'Creato', 4),
('2022-05-22', 'Installazione aria condizionata', 'Richiedo l\'installazione di un sistema di aria condizionata nell\'apartment', 'QRST7890', 'In Lavorazione', 5);

SELECT * FROM Administrator;

SELECT * FROM Commonhold;

SELECT * FROM Apartment;

SELECT * FROM InfoMessage;

SELECT * FROM RequestMessage;
