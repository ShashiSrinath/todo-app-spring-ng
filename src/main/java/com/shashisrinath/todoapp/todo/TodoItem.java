package com.shashisrinath.todoapp.todo;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table()
public class TodoItem {
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 1000)
    @NonNull
    private String task;


    public TodoItem() {
    }

    public TodoItem(String task) {
        this.task = task;
    }

    public TodoItem(int id, @NonNull String task) {
        this.id = id;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", task='" + task + '\'' +
                '}';
    }
}
