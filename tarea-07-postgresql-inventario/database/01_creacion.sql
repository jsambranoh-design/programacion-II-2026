CREATE DATABASE control_inventario;

CREATE TABLE Producto(
                         Id BIGINT GENERATED ALWAYS AS IDENTITY,
                         Codigo VARCHAR(15) NOT NULL,
                         Nombre VARCHAR(80) NOT NULL,
                         Categoria VARCHAR(40) NOT NULL,
                         Precio NUMERIC(8,2) NOT NULL,
                         Stock INTEGER NOT NULL,
                         Activo BOOLEAN NOT NULL DEFAULT TRUE,

                         CONSTRAINT pk_Producto PRIMARY KEY (Id),
                         CONSTRAINT uk_Producto_Codigo UNIQUE (Codigo),
                         CONSTRAINT ck_Producto_Precio CHECK (Precio > 0),
                         CONSTRAINT ck_Producto_Stock CHECK (Stock >= 0)
);
