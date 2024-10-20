package geekbrains.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import geekbrains.model.Task;
import geekbrains.model.TaskStatus;
import geekbrains.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        task.setCreatedDate(LocalDateTime.now());
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> findByStatus(@PathVariable TaskStatus status){
        return taskService.findByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTaskStatus(id,task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}