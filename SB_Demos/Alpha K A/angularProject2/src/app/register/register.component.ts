import { CommonModule } from '@angular/common';
import { Component ,Input} from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  imports: [FormsModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

title: string = "Course Particulars"
noOfCourses:number=5

onSubmit(data:any)
{
  console.log(data);
}
@Input() companyName:string="Register Company"

}
