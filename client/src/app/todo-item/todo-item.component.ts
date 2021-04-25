import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

const { API_PATH } = environment;

export type Todo = {
  id: number;
  task: string;
};

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.scss'],
})
export class TodoItemComponent implements OnInit {
  @Input() todo: Todo;
  @Output() changedEvent = new EventEmitter();
  isEditing: boolean;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {}

  handleDeleteTodoClick(id: number) {
    this.http
      .delete(`${API_PATH}/todos/${id}`)
      .subscribe((response: { message: string }) => {
        console.log(response.message);
        this.changedEvent.emit();
      });
  }

  toggleEditingMode() {
    this.isEditing = !this.isEditing;
  }

  handleSaveTodoClick() {
    this.http
      .put(`${API_PATH}/todos/${this.todo.id}`, this.todo)
      .subscribe((response) => {
        this.toggleEditingMode();
        this.changedEvent.emit();
      });
  }
}
