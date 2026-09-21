--CONSULTAS
-- Mostrar el código, nombre, categoría, precio y stock de todos los productos
SELECT Codigo, Nombre, Categoria, Precio, Stock FROM Producto;

-- Buscar los productos de una categoría específica
SELECT Codigo, Nombre, Categoria, Precio, Stock , Activo FROM Producto
WHERE Categoria = 'Hogar';
--FILTROS/ORDENAMIENTO
-- Mostrar los productos ordenados del precio más alto al más bajo
SELECT Codigo, Nombre, Categoria, Precio, Stock
FROM Producto
ORDER BY Precio DESC;

-- Mostrar únicamente los productos con tres unidades o menos
SELECT Codigo, Nombre, Categoria, Precio, Stock, Activo
FROM Producto
WHERE Stock <= 3;

-- Mostrar los productos activos que todavía tengan existencias
SELECT Codigo, Nombre, Categoria, Precio, Stock, Activo
FROM Producto
WHERE Activo = TRUE AND Stock > 0;

-- Buscar un producto mediante su código (ejemplo: 'ELC-159')
SELECT Id, Codigo, Nombre, Categoria, Precio, Stock, Activo
FROM Producto
WHERE Codigo = 'HGR-320';
--ACTUALIZACION
-- Buscar un producto mediante su código (ejemplo: 'ELC-599')
SELECT Codigo, Nombre, Categoria, Precio, Stock
FROM Producto
WHERE Codigo = 'ELC-599';

-- Actualizar el stock de un producto (ejemplo: restar 2 unidades al código 'ELC-599')
UPDATE Producto
SET Stock = Stock - 2
WHERE Codigo = 'ELC-599';
--Actualizacion de los productos agotados marcados como inactivos
UPDATE Producto
SET Activo = FALSE
WHERE Stock = 0;

SELECT Id, Codigo, Nombre, Categoria, Precio, Stock, Activo
FROM Producto;
-- ELIMINACION
SELECT Id, Codigo, Nombre, Categoria, Precio, Stock, Activo
FROM Producto;
--Insercion de dato temporal
INSERT INTO Producto
(Codigo, Nombre, Categoria, Precio, Stock, Activo)
VALUES
    ('TEMP-001', 'Smart TV', 'Electronicos', 3599.95, 4, TRUE);
--Eliminacion de dato temporal
DELETE FROM Producto
WHERE Codigo = 'TEMP-001';

