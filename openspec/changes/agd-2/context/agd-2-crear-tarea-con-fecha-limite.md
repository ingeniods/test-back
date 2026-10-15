# AGD-2: Crear tarea con fecha límite

Fuente: http://localhost:8091/browse/AGD-2

# AGD-2: Crear tarea con fecha límite

**Tipo**: Story | **Estado**: To Do | **Prioridad**: High
**Proyecto**: Agenda | **Componentes**: backend, frontend
**Asignado**: - | **Reporta**: PO
**Creado**: 2026-10-01 | **Actualizado**: 2026-10-01

## Descripción

h2. Contexto
El usuario debe poder crear tareas con fecha límite desde el calendario.

h2. Nota técnica
La columna due_date YA EXISTE en la tabla tasks (ver Confluence: AGD — Modelo de datos tasks).

## Criterios de aceptación

* Formulario con título + fecha
* La tarea aparece en el calendario
* Persiste en BD

## Issues relacionados

- blocks AGD-3

## Comentarios recientes

- Tech Lead (2026-10-02): Ojo: el front consume POST /api/tasks vía gateway.
