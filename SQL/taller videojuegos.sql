CREATE TABLE videojuegos(
    codigo VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    plataforma VARCHAR(50) NOT NULL,
    precio DOUBLE PRECISION NOT NULL,
    disponible BOOLEAN NOT NULL,
    genero VARCHAR(50)
);

--ejecutar consulta

SELECT column_name, data_type
FROM information_schema.columns
WHERE table_name = 'videojuegos'
ORDER BY ordinal_position;

SELECT * FROM videojuegos 
SELECT * FROM videojuegos WHERE codigo = 'VG001';