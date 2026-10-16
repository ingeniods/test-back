# AGD — Convenciones backend

Fuente: http://localhost:8090/spaces/AGD/pages/1007

# AGD — Convenciones backend

Spring Boot 3 + JPA, ddl-auto: none — toda columna nueva exige migración Flyway (V{n}__desc.sql) 
 DTOs planos, snake_case en BD / camelCase en API 
 SmokeRunner es el canario post-arranque: debe salir "SMOKE CHECK OK"
