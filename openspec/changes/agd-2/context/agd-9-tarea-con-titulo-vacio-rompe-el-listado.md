# AGD-9: Tarea con título vacío rompe el listado

Fuente: http://localhost:8091/browse/AGD-9

# AGD-9: Tarea con título vacío rompe el listado

**Tipo**: Bug | **Estado**: To Do | **Prioridad**: Highest
**Proyecto**: Agenda | **Componentes**: backend, frontend
**Asignado**: - | **Reporta**: PO
**Creado**: 2026-10-01 | **Actualizado**: 2026-10-01

## Descripción

h2. Contexto
Una tarea con title NULL o vacío hace que el front pinte una fila en blanco.

h2. Esperado
Validar title NOT NULL en BD y en el POST.

## Criterios de aceptación

* POST sin título → 400
* title NOT NULL en la tabla
* El front no pinta filas vacías

## Comentarios recientes

- QA (2026-10-05): Reproducido en DEV insertando a mano title=''. El API lo acepta sin validar.
