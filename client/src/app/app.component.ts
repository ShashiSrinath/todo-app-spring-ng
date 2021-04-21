import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  newTodoText: string;

  constructor(private http: HttpClient) {
    this.newTodoText = '';
  }

  handleAddNewTodoClick() {
    this.http.get('localhost:8088/api/todos').subscribe((data) => {
      console.log(data);
    });
  }
}
