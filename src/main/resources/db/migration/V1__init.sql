CREATE TABLE tasks (
    id         BIGSERIAL PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    done       BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

INSERT INTO tasks (title, done) VALUES
    ('Revisar informe mensual', false),
    ('Llamar al proveedor', false),
    ('Preparar demo interna', true);
