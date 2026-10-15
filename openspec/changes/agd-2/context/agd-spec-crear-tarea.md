# AGD — Spec crear tarea

Fuente: http://localhost:8090/spaces/AGD/pages/1003

# AGD — Spec crear tarea

POST /api/tasks — body {title, dueDate} → 201 Created. Validación: título obligatorio, fecha en ISO (YYYY-MM-DD). La tarea aparece en la lista y en el calendario.
