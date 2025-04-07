import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor() { }

  private courses:Course[]=[
    {id:1,name:"SPring boot ",descn:"Complete Spring boot course",instructor:"Vijay"},
    {id:2,name:"Angular boot ",descn:"Complete Angular boot",instructor:"Karthik"},
    {id:3,name:"Full Stack development ",descn:"Complete Full Stack development ",instructor:"Alpha"}
  ]

  getCourses()
  {
    return of(this.courses)//retirn mock data as an Observable
  }
}
