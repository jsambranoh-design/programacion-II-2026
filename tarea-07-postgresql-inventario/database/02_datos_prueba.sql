INSERT INTO Producto
(Codigo, Nombre, Categoria, Precio, Stock)
VALUES ('SNA-348', 'Cheetos Crunchy', 'Snack', 64.95, 20);

INSERT INTO Producto
(Codigo, Nombre, Categoria, Precio, Stock, Activo)
VALUES ('HGR-152', 'Botes con Pedal', 'Hogar', 189.95, 0, TRUE);

INSERT INTO Producto
(Codigo, Nombre, Categoria, Precio, Stock, Activo)
VALUES ('HGR-320', 'Escoba Industrial', 'Hogar', 179.95, 5, TRUE);

INSERT INTO Producto
(Codigo, Nombre, Categoria, Precio, Stock, Activo)
VALUES ('HGR-214', 'Canasta Organizadora', 'Hogar', 249.95, 2, TRUE);

INSERT INTO Producto
(Codigo, Nombre, Categoria, Precio, Stock, Activo)
VALUES ('ELC-159', 'Cerradura De Puerta Wi-Fi Inteligente', 'Electronicos', 629.95, 19, TRUE);


-- Error de código
INSERT INTO Producto
(Codigo, Nombre, Categoria, Precio, Stock, Activo)
VALUES
    ('HGR-320', 'Perchero para Ropa', 'Hogar', 679.95, 3, TRUE);

-- Instrucción corregida
INSERT INTO Producto
(Codigo, Nombre, Categoria, Precio, Stock, Activo)
VALUES
    ('HGR-3120', 'Perchero para Ropa', 'Hogar', 679.95, 3, TRUE);

