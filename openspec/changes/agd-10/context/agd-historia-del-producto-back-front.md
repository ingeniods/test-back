# AGD — Historia del producto (back + front)

Fuente: http://localhost:8090/pages/1008

# AGD — Historia del producto (back + front)

Cómo nació Agenda La app empezó como un listado plano de tareas (AGD-1): un test-back Spring Boot con JPA + Flyway (V1 crea tasks ) y un test-front Vue 3 que pinta la tabla. Luego se añadió la fecha límite (AGD-2): columna due_date vía V2, campo en el POST y el calendario la usa para posicionar la tarea. Reglas que no se negocian Toda columna nueva entra por migración Flyway numerada en orden — nunca editar V1/V2 ya aplicadas. El controller delega en el repository: sin lógica de negocio en endpoints. El smoke de arranque ( SmokeRunner ) debe seguir ejercitando findAll() — es la red que detecta drift entidad↔esquema. Front: la tabla del listado vive en un solo componente; los badges de estado usan clases semánticas (low/medium/high), no colores en línea. Esta historia (AGD-10) Pedido pequeño a propósito: prioridad visible. En back es una columna enum nueva ( priority : LOW, MEDIUM, HIGH; default MEDIUM) con V3; en front es un badge por fila: LOW gris, MEDIUM azul, HIGH rojo. La conversación completa con PO está en el attachment historia-prioridad.md .
