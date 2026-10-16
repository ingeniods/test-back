# Tasks — delta prioridad

## ADDED Requirements

### Requirement: Prioridad de tarea
La tabla `tasks` SHALL persistir una columna `priority` con valores `LOW`, `MEDIUM` o `HIGH`, introducida por la migración Flyway `V3__add_priority.sql` sin modificar V1 ni V2. Las tareas existentes MUST quedar con `priority='MEDIUM'` tras la migración.

#### Scenario: Migración V3 aplica sobre esquema V2
- **WHEN** se despliega la app sobre una base de datos en versión V2
- **THEN** Flyway aplica `V3__add_priority.sql` y la columna `priority` existe con default `MEDIUM`

#### Scenario: Crear tarea sin prioridad
- **WHEN** se hace `POST /api/tasks` sin el campo `priority`
- **THEN** la tarea se persiste con `priority=MEDIUM`

#### Scenario: Crear tarea con prioridad
- **WHEN** se hace `POST /api/tasks` con `priority=HIGH`
- **THEN** la tarea se persiste y `GET /api/tasks` la devuelve con `priority=HIGH`

#### Scenario: Listado incluye prioridad
- **WHEN** se consulta `GET /api/tasks`
- **THEN** cada tarea incluye el campo `priority` en mayúsculas (`LOW|MEDIUM|HIGH`)
