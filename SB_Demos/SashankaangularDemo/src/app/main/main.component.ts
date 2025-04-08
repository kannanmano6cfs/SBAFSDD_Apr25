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
  num1: number = 78
  num2: number = 51

  pic1: string = "images\\teamtraining.jpg"
  altText: string = "Image Unavailable now..."
  text: string = ""
  message: string ="Sashanka"
  flag: boolean =true

  courses: string[] =[
    "Java Courses",
    "Azure and AWS Courses",
    "Networking Courses",
    "Development Courses"
  ]

  showCourses(){
    this.flag=true
  }

  hideCourses(){
    this.flag=false
  }

  showText(){
    this.text="Hello everyone! Welcome to the session!!"
  }

  height: string ="300px"
  changeHeight(){
    if(this.height=="300px")
      this.height="500px"
    else
      this.height="300px"
  }
  
  className: string = "class1"
  changeClass(){
    this.className="class2"
  }
}
