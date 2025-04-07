import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-main',
  imports: [FormsModule,CommonModule],
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
  flag: boolean=true
  
  showCourses(){
    this.flag=true
    }
    hideCourses(){
      this.flag=false
      }
  courses: string[]=[
  "Spring Boot Course",
  "MS SQL Server Course",
    "Angular Course",
    "Full Stack Development Course"]
  showText(){
    this.text="Hello everyone! Welcome to the session!!"
  }
 
  height:string ="500px"
  width:string="700px"
  changeHeight()
  {
    if(this.height=="500px")
    {this.height="800px"
    this.width="1000px"}
    else
    {this.height="500px"
      this.width="700px"}
  }
 
  className: string="class1"
  changeClass(){
    this.className="class2"
  }
}
