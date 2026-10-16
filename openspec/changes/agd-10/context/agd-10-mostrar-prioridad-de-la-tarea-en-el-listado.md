# AGD-10: Mostrar prioridad de la tarea en el listado

Fuente: http://localhost:8091/browse/AGD-10

# AGD-10: Mostrar prioridad de la tarea en el listado

**Tipo**: Story | **Estado**: To Do | **Prioridad**: Medium
**Proyecto**: Agenda | **Componentes**: backend, frontend
**Asignado**: - | **Reporta**: PO
**Creado**: 2026-10-15 | **Actualizado**: 2026-10-15

## Descripción

h2. Contexto
Los usuarios quieren distinguir a simple vista qué tareas son urgentes. Confluence describe el modelo actual y las convenciones.

h2. Alcance
* Back: campo `priority` en tasks (LOW, MEDIUM, HIGH — default MEDIUM) con su migración Flyway.
* El GET /api/tasks debe devolver `priority`.
* Front: el listado muestra la prioridad como badge de color (ver página de historia).

h2. Referencias
* AGD — Historia del producto (Confluence 1008) — explica el porqué en back y front.
* AGD — Modelo de datos tasks (1002), Convenciones backend (1007), API REST (1004).

## Criterios de aceptación

* La tabla `tasks` tiene columna `priority` vía migración Flyway V3 (V1 y V2 ya existen).
* `GET /api/tasks` devuelve `priority` por tarea (default MEDIUM si no se indica).
* `POST /api/tasks` acepta `priority` opcional.
* El listado muestra un badge: LOW gris, MEDIUM azul, HIGH rojo.
* Verificación: smoke de arranque sin errores y GET /api/tasks con priority.

## Comentarios recientes

- Tech Lead (2026-10-15): Pequeña a propósito para la demo E2E: una columna + badge. Seguir las convenciones de la página 1007 y respetar la numeración Flyway.
