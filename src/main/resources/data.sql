CREATE TABLE IF NOT EXISTS "USUARIO" (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    tipo_usuario VARCHAR(31) NOT NULL
);

INSERT INTO "USUARIO" (id, nombre, tipo_usuario) VALUES (1 ,'default_invitado', 'INVITADO');

