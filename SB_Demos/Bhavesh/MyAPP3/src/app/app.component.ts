import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AddTodoComponent } from '../add-todo/add-todo.component';
import { ListTodoComponent } from '../list-todo/list-todo.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,AddTodoComponent,ListTodoComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angulardemo3';
}
