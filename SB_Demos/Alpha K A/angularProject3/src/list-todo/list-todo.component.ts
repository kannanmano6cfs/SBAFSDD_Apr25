import { Component } from '@angular/core';
import { TodoService } from '../services/todo.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-list-todo',
  imports: [CommonModule],
  templateUrl: './list-todo.component.html',
  styleUrl: './list-todo.component.css'
})
export class ListTodoComponent {
  localItems:string[]=[]
 //dependency Injection in angular for service class 
constructor(private service:TodoService){
this.localItems=this.service.getItems();

}
}
