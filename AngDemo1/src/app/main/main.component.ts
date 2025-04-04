import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-main',
  imports: [FormsModule, CommonModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
  num1: number = 1565
  num2: number = 54

  pic1: string = "images\\teamtraining.jpg"
  altText: string = "Image Unavailable now..."
  text: string = ""
  message: string ="Vmware courses"

  showText(){
    this.text="Hello everyone! Welcome to the session!!"
  }
}
