import { Component } from '@angular/core';

@Component({
  selector: 'app-main',
  imports: [],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
  num1: number = 1565
  num2: number = 54

  greatToPlaceImg: string = "images\\FSS07743.jpg"
  altText: string = "Image Unavailable now..."
  text: string = ""
  message: string ="Vmware courses"

  showText(){
    this.text="Hello everyone! Welcome to the session!!"
  }
}
