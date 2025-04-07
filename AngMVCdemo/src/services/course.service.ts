import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { of } from 'rxjs'//mock data

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor() { }

  private courses: Course[]=[
    {id:1,name:'VMware Courses', descn:'All vSphere, NSX and VCF courses', instructor:'Kannan'},
    {id:2,name:'AWS Courses', descn:'All AWS courses', instructor:'Bhavesh'},
    {id:3,name:'Azure Courses', descn:'All Azure courses', instructor:'Alpha'}
  ]

  getCourses(){
    return of(this.courses)//return mock data as an Observable
  }
}
