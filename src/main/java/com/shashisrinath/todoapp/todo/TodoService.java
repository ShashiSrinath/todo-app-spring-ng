package com.shashisrinath.todoapp.todo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    public TodoItem findById(int id) {
        Optional<TodoItem> item = todoRepository.findById(id);

        if (item.isPresent()) {
            return item.get();
        } else {
            throw new TodoItemNotFoundException();
        }
    }

    public TodoItem create(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    public TodoItem update(TodoItem todoItem, int id) {
        Optional<TodoItem> item = todoRepository.findById(id);

        if (item.isPresent()) {
            todoItem.setId(id);
            return todoRepository.save(todoItem);
        } else {
            throw new TodoItemNotFoundException();
        }

    }

    public void delete(int id) {
        Optional<TodoItem> item = todoRepository.findById(id);

        if (item.isPresent()) {
            todoRepository.deleteById(id);
        } else {
            throw new TodoItemNotFoundException();
        }
    }

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class TodoItemNotFoundException extends HttpClientErrorException {

    public TodoItemNotFoundException() {
        super(HttpStatus.NOT_FOUND, "todo item not found");
    }
}
