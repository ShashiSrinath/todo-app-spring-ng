package com.shashisrinath.todoapp.todo;

import com.shashisrinath.todoapp.todo.dto.CreateTodoDTO;
import com.shashisrinath.todoapp.todo.dto.DeleteResponseDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/api/todos")
    public List<TodoItem> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/api/todos/{id}")
    public TodoItem findById(@PathVariable int id) {
        return todoService.findById(id);
    }

    @PostMapping("/api/todos")
    public TodoItem create(@Validated @RequestBody CreateTodoDTO dto) {
        return todoService.create(new TodoItem(dto.getTask()));
    }

    @PutMapping("/api/todos/{id}")
    public TodoItem update(@PathVariable int id, @Validated @RequestBody TodoItem todoItem) {
        return todoService.update(todoItem, id);
    }

    @DeleteMapping("/api/todos/{id}")
    public DeleteResponseDTO delete(@PathVariable int id) {
        todoService.delete(id);
        return new DeleteResponseDTO("todo item deleted successfully");
    }
}

