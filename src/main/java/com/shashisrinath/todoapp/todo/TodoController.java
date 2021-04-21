package com.shashisrinath.todoapp.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/api/todos")
    public List<TodoItem> findAll() {
        return todoService.findAll();
    }

}