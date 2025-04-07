import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor() { }

  //shared data 
  private items:string []=[]
  
  addItem(item:string)
  {
    this.items.push(item)
  }

  getItems():string[]{
    return this.items;
  }
}
