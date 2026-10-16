# AGD — API REST /api/tasks

Fuente: http://localhost:8090/spaces/AGD/pages/1004

# AGD — API REST /api/tasks

Endpoints 
 Método Ruta Descripción 
 GET /api/tasks Lista todas las tareas (orden: created_at) 
 POST /api/tasks Crea tarea. Body: {title, dueDate?, priority?} 
 PATCH /api/tasks/{id} Actualiza campos (done, title) 
 PUT /api/tasks/{id} Reemplaza la tarea 
 DELETE /api/tasks/{id} Borra una tarea 
 DTO Task 
 { "id": 1, "title": "...", "done": false, "createdAt": "...", "dueDate": "2026-10-20", "priority": "MEDIUM" } 
 dueDate : campo opcional ISO-8601 (yyyy-MM-dd). Persiste en tasks.due_date 
(según AGD — Modelo de datos tasks la columna ya existe — no hace falta migración).
 priority : campo opcional (`LOW`, `MEDIUM`, `HIGH`); por defecto `MEDIUM`.
