# AGD-8: Marcar tarea como completada

Fuente: http://localhost:8091/browse/AGD-8

# AGD-8: Marcar tarea como completada

**Tipo**: Story | **Estado**: Done | **Prioridad**: Medium
**Proyecto**: Agenda | **Componentes**: backend, frontend
**Asignado**: Sandbox Bot | **Reporta**: PO
**Creado**: 2026-09-01 | **Actualizado**: 2026-09-01

## Descripción

h2. Contexto
Checkbox en el listado que marca done=true sin recargar.

h2. Estado
Implementado en develop (baseline) — PATCH /api/tasks/{id}.

## Criterios de aceptación

* El checkbox refleja done
* PATCH persiste el cambio
* Optimista en UI
