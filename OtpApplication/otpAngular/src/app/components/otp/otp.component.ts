import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { OtpService } from '../../services/otp.service';

@Component({
  selector: 'app-otp',
  imports: [FormsModule, CommonModule],
  templateUrl: './otp.component.html',
  styleUrl: './otp.component.css'
})
export class OtpComponent {
  email: string = '';
  otp: string = '';
  otpSent: boolean = false;
  message: string = '';
  success: boolean = false;

  constructor(private otpService: OtpService) {}

  requestOtp() {
    this.otpService.sendOtp(this.email).subscribe({
      next: (response) => {
        this.otpSent = true;
        this.message = response.message; // Extract message from JSON
        this.success = true;
      },
      error: () => {
        this.message = "Failed to send OTP.";
        this.success = false;
      }
    });
  }
  
  verifyOtp() {
    this.otpService.verifyOtp(this.email, this.otp).subscribe({
      next: (response) => {
        this.message = response.message; // Extract message from JSON
        this.success = response.message.includes("successful");
      },
      error: () => {
        this.message = "Invalid or expired OTP.";
        this.success = false;
      }
    });
  }
}
