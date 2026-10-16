package com.ingeniods.agenda;

import java.time.LocalDate;

public record TaskCreateRequest(String title, LocalDate dueDate, TaskPriority priority) {
}
