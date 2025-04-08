import { Component } from '@angular/core';
import { OtpService } from '../services/otp.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-otp',
  imports: [FormsModule, CommonModule],
  templateUrl: './otp.component.html',
  styleUrl: './otp.component.css'
})
export class OtpComponent {
  email: string = ''
  otp: string = ''
  otpSent: boolean = false
  success: boolean = false
  message: string = ''

  constructor(private service:OtpService){}

 
  requestOtp(){  
  this.service.sendOtp(this.email).subscribe({
      next: (response)=>{
        this.otpSent=true
        this.success=true
        this.message=response.message
      },
      error: ()=>{
        this.message = "Failed to send OTP"
        this.success = false
      }
      
      });
  }

     
  verifytOtp(){  
    this.service.verifyOtp(this.email, this.otp).subscribe({
        next: (response)=>{
          this.otpSent=true
          this.success=response.message.includes("sucessful")
          this.message=response.message
        },
        error: ()=>{
          this.message = "Failed to send OTP"
          this.success = false
        }
        
        });
    }
}
