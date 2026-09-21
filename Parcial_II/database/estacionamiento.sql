CREATE DATABASE parcial2_estacionamiento;

CREATE TABLE vehiculo (
                          id BIGINT GENERATED ALWAYS AS IDENTITY,
                          placa VARCHAR(20) NOT NULL,
                          propietario VARCHAR(100) NOT NULL,
                          tipo VARCHAR(20) NOT NULL,
                          hora_ingreso VARCHAR(10) NOT NULL,
                          horas_utilizadas INTEGER NOT NULL,
                          costo NUMERIC(10,2) NOT NULL,
                          activo BOOLEAN DEFAULT TRUE,

                          CONSTRAINT pk_vehiculo PRIMARY KEY (id),
                          CONSTRAINT uq_vehiculo_placa UNIQUE (placa),
                          CONSTRAINT ck_vehiculo_horas CHECK (horas_utilizadas > 0),
                          CONSTRAINT ck_vehiculo_costo CHECK (costo >= 0)
);

SELECT * FROM vehiculo;

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
    ('PJJ-502', 'Gabriela Yaozca', 'Motocicleta', '08:00', 3, 30.00),
    ('AKJ-486', 'Cesar Saquice', 'Motocicleta', '09:15', 4, 24.00),
    ('PBV-995', 'Mirna Morales', 'Automovil', '10:30', 6, 54.00),
    ('MOF-967', 'Wendy Castellanos', 'Motocicleta', '11:00', 2, 12.00),
    ('SHF-928', 'Maria Castro', 'Automovil', '13:20', 8, 72.00);

SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo;

SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo
WHERE tipo = 'Automovil';


SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo
WHERE tipo = 'Motocicleta';

SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo
WHERE costo > 15;

SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo
ORDER BY costo DESC;

UPDATE vehiculo
SET hora_ingreso = '13:40'
WHERE placa = 'SHF-928';


SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo WHERE placa ='SHF-928';

DELETE FROM vehiculo
WHERE placa = 'PBV-995';

SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo;

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
    ('PJJ-502', 'Gabriela Yaozca', 'Motocicleta', '08:00', 3, 30.00);


INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
    ('PJJ-512', 'Gabriela Yaozca', 'Motocicleta', '08:00', -2, 30.00);
