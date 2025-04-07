import { CommonModule } from '@angular/common';
import { Component ,input,Input} from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
myForm=new FormGroup({
    username:new FormControl('',[Validators.required,Validators.email]),
    password:new FormControl('',[Validators.required,Validators.minLength(8)])
  })

  onSubmit()
  {
    console.log(this.myForm);
  }

  @Input() companyName:string="Login"

}
