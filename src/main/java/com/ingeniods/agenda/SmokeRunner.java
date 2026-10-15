package com.ingeniods.agenda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Verifica al arranque que el modelo JPA encaja con la BD real.
 * Con ddl-auto=none una columna/entidad desacoplada NO tumba el pod:
 * se loguea ERROR y la app sigue Ready → el monitor de despliegue
 * captura la firma en la ventana de observación.
 */
@Configuration
public class SmokeRunner {

    private static final Logger log = LoggerFactory.getLogger(SmokeRunner.class);

    @Bean
    ApplicationRunner schemaSmokeCheck(TaskRepository repo) {
        return args -> {
            try {
                // findAll() (no count()): el SELECT incluye TODAS las columnas
                // mapeadas → si falta alguna en la BD, el driver lanza el
                // error literal ("column due_date does not exist").
                long count = repo.findAll().size();
                log.info("SMOKE CHECK OK — tabla tasks accesible ({} filas)", count);
            } catch (Exception e) {
                log.error("SMOKE CHECK FAILED — modelo JPA desacoplado de la BD: {}",
                        e.getMessage(), e);
            }
        };
    }
}
