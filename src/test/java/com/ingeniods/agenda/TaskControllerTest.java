package com.ingeniods.agenda;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaskRepository repo;

    @Test
    void listIncludesPriority() throws Exception {
        Task task = new Task();
        task.setPriority(TaskPriority.HIGH);
        when(repo.findAll()).thenReturn(List.of(task));

        mvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].priority").value("HIGH"));
    }

    @Test
    void createDefaultsPriorityToMedium() throws Exception {
        when(repo.save(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));

        mvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Prepare demo\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priority").value("MEDIUM"));

        org.mockito.ArgumentCaptor<Task> taskCaptor = org.mockito.ArgumentCaptor.forClass(Task.class);
        verify(repo).save(taskCaptor.capture());
        org.junit.jupiter.api.Assertions.assertEquals(TaskPriority.MEDIUM, taskCaptor.getValue().getPriority());
        org.junit.jupiter.api.Assertions.assertNotNull(taskCaptor.getValue().getCreatedAt());
    }

    @Test
    void createAcceptsPriority() throws Exception {
        when(repo.save(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));

        mvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Urgent task\",\"priority\":\"HIGH\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priority").value("HIGH"));
    }
}
