import { Component, OnInit } from '@angular/core';
import { CourseService } from '../services/course.service';
import { Course } from '../models/course';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-courselist',
  imports: [CommonModule],
  templateUrl: './courselist.component.html',
  styleUrl: './courselist.component.css'
})
export class CourselistComponent implements OnInit{

  courses:Course[]=[];

  constructor(private service:CourseService){}

  ngOnInit(): void {
    this.service.getCourses().subscribe((courses)=>{
      this.courses=courses;
    })
    
  }
}

