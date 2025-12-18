package com.java360.pmanager.infrascructure.controller;

import com.java360.pmanager.domain.applicationservice.TaskService;
import com.java360.pmanager.domain.entity.Task;
import com.java360.pmanager.infrascructure.dto.SaveTaskDataDTO;
import com.java360.pmanager.infrascructure.dto.TaskDTO;
import com.java360.pmanager.infrascructure.util.SortProperties;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static com.java360.pmanager.infrascructure.controller.RestConstants.PATH_TASKS;

@RestController
@RequestMapping(PATH_TASKS)
@RequiredArgsConstructor
public class TaskRestResource {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createProject(@RequestBody @Valid SaveTaskDataDTO saveTaskData) {
        Task task = taskService.createTask(saveTaskData);
        return ResponseEntity
                .created(URI.create(PATH_TASKS + "/" + task.getId()))
                .body(TaskDTO.create(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> loadProject(@PathVariable("id") String taskId) {
        Task task = taskService.loadTaskById(taskId);
        return ResponseEntity.ok(TaskDTO.create(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") String taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(
            @PathVariable("id") String taskId,
            @RequestBody @Valid SaveTaskDataDTO saveTaskData) {
        Task task = taskService.updateTask(taskId, saveTaskData);
        return ResponseEntity.ok(TaskDTO.create(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findTasks(
            @RequestParam(value = "projectId", required = false) String projectId,
            @RequestParam(value = "memberId", required = false) String memberId,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "partialTitle", required = false) String partialTitle,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "direction", required = false) String direction,
            @RequestParam(value = "sort", required = false) SortProperties properties
    ) {
//        List<Task> tasks = taskService.findTasks(projectId, memberId, status, partialTitle);

        Page<Task> tasks = taskService.findTasks(
                projectId,
                memberId,
                status,
                partialTitle,
                page,
                direction,
                Optional
                        .ofNullable(properties)
                        .map(SortProperties::getSortPropertiesList)
                        .orElse(List.of())
        );

        return ResponseEntity.ok(tasks.stream().map(TaskDTO::create).toList());
    }
}
