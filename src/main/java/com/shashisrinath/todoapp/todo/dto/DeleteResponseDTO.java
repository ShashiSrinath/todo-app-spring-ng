package com.shashisrinath.todoapp.todo.dto;

public class DeleteResponseDTO {
    private String message;

    public DeleteResponseDTO() {
    }

    public DeleteResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
