# Design — Mostrar prioridad de la tarea en el listado

## Context
AGD-10: distinguir a simple vista las tareas urgentes — badge de prioridad por fila. La decisión técnica y la conversación con PO están en el archivo adjunto historia-prioridad.md y en la página Confluence 1008.

- Proyecto: **test-back** (`/Users/meryluzespinosa/sandbox/projects/test-back`)
- Stack: sin stack detectado

## Goals
- Persistir `LOW`, `MEDIUM` o `HIGH` en `tasks` mediante Flyway V3, conservando
  `MEDIUM` para las tareas existentes.
- Devolver siempre la prioridad en `GET /api/tasks` y aceptar una prioridad
  opcional en `POST /api/tasks`.

## Non-Goals
- Filtrar u ordenar tareas por prioridad, o permitir editarla desde el front.
- Implementar cambios de interfaz: este repositorio contiene únicamente el
  backend `test-back`.

## Decisions
- Usar `TaskPriority` como enum persistido por nombre (`EnumType.STRING`) para
  mantener el contrato API en mayúsculas y legible en la base de datos.
- Añadir `priority VARCHAR(10) NOT NULL DEFAULT 'MEDIUM'` con
  `V3__add_priority.sql`; no modificar V1 ni V2.
- Aplicar el default `MEDIUM` también en el modelo y al crear tareas, de modo
  que tanto las filas nuevas como las existentes tengan una prioridad válida.
- Mantener la lógica de acceso a datos en `TaskRepository` y la coordinación
  de la operación en `TaskController`.
