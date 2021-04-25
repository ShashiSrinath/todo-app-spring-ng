import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const API_PATH = 'http://localhost:8088/api';

type Todo = {
  id: number;
  task: string;
};

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  newTodoText: string;
  todos: Todo[];

  constructor(private http: HttpClient) {
    this.newTodoText = '';
    this.todos = [];
  }

  _refresh() {
    this.http.get(`${API_PATH}/todos`).subscribe((data: Todo[]) => {
      data.reverse();
      this.todos = data;
    });
  }

  ngOnInit() {
    this._refresh();
  }

  handleAddNewTodoClick() {
    this.http
      .post(`${API_PATH}/todos`, {
        task: this.newTodoText,
      })
      .subscribe(() => {
        this._refresh();
        this.newTodoText = '';
      });
  }

  handleDeleteTodoClick(id: number) {
    this.http
      .delete(`${API_PATH}/todos/${id}`)
      .subscribe((response: { message: string }) => {
        console.log(response.message);
        this._refresh();
      });
  }
}
