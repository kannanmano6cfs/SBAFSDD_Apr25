import { Component } from '@angular/core';
import { TodoService } from '../services/todo.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-todo',
  imports: [FormsModule, CommonModule],
  templateUrl: './add-todo.component.html',
  styleUrl: './add-todo.component.css'
})
export class AddTodoComponent {

  //Dependency Injection in Angular - pass singleton object
  constructor(private service:TodoService){}

  onSubmit(data:any){
    this.service.addItem(data.value.item)
    data.reset()
  }
}
