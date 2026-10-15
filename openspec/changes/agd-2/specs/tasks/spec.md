# Delta: tasks — fecha límite (AGD-2)

## ADDED Requirements

### Requirement: Tarea con fecha límite
Una tarea SHALL poder llevar una fecha límite (`dueDate`, ISO-8601 `yyyy-MM-dd`) que se persiste en la columna `tasks.due_date` y se devuelve en el DTO de `/api/tasks`.

Nota de datos: según *AGD — Modelo de datos tasks* (Confluence 1002), la columna `due_date` **ya existe** en el esquema — no se requiere migración.

#### Scenario: Crear tarea con fecha límite
- **WHEN** el cliente hace `POST /api/tasks` con `{ "title": "...", "dueDate": "2026-10-20" }`
- **THEN** la tarea se persiste con `due_date = 2026-10-20`
- **AND** `GET /api/tasks` la devuelve con `"dueDate": "2026-10-20"`

#### Scenario: Tarea sin fecha límite
- **WHEN** el cliente crea una tarea sin `dueDate`
- **THEN** `due_date` queda `NULL` y el DTO devuelve `"dueDate": null`
