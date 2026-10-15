# AGD-5: Editar el título de una tarea

Fuente: http://localhost:8091/browse/AGD-5

# AGD-5: Editar el título de una tarea

**Tipo**: Story | **Estado**: To Do | **Prioridad**: Medium
**Proyecto**: Agenda | **Componentes**: backend, frontend
**Asignado**: - | **Reporta**: PO
**Creado**: 2026-10-01 | **Actualizado**: 2026-10-01

## Descripción

h2. Contexto
Desde el detalle se puede corregir el título de una tarea existente.

h2. API
PUT /api/tasks/{id} con {title}.

## Criterios de aceptación

* PUT persiste el nuevo título
* 404 si el id no existe
* Título vacío rechazado con 400
