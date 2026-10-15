-- Correccion: la doc decia que due_date existia; V1 no la creo.
ALTER TABLE tasks ADD COLUMN due_date DATE;
