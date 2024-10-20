package geekbrains.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import geekbrains.model.Task;
import geekbrains.model.TaskStatus;
import geekbrains.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    public Task addTask(Task task) {
        return repository.save(task);
    }
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public List<Task> findByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    public Task updateTaskStatus(Long id, Task task) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task1 = optionalTask.get();
            task1.setStatus(task.getStatus());
            return repository.save(task1);
        } else {
            throw new IllegalArgumentException("Task not found with id");
        }
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

}