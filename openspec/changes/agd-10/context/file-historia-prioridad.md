# historia-prioridad.md

Fuente: /Users/meryluzespinosa/projects/PROSEGUR/cash-innovation-cash-today-devices-backoffice-jenkins-helper2/sandbox/e2e/context/historia-prioridad.md

# Historia: prioridad en el listado

## Lo que pidió PO
"Quiero que al abrir la agenda se vea de un vistazo qué es urgente. Nada de
filtros todavía — solo que cada fila del listado marque la prioridad."

## Decisión técnica acordada
- **Back** (`test-back`): enum `TaskPriority { LOW, MEDIUM, HIGH }` + columna
  `priority varchar(10) not null default 'MEDIUM'` — migración
  `V3__add_priority.sql` (V1 y V2 ya están aplicadas en DEV, no tocarlas). El
  `Task` entity mapea el enum con `@Enumerated(STRING)`; el POST la acepta
  opcional y el GET la devuelve siempre.
- **Front** (`test-front`): la columna nueva va a la derecha de `done`; un
  `<span class="badge badge-low|badge-medium|badge-high">` — gris/azul/rojo.
  Sin librerías nuevas.
- **Contrato**: `priority` es string en mayúsculas; el front no traduce.

## Qué NO pedir en esta iteración
- Sin filtrado ni ordenación por prioridad (viene en AGD-12).
- Sin edición de prioridad desde el front (solo lectura en listado).

