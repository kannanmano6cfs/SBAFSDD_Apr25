import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { OtpComponent } from "./otp/otp.component";

@Component({
  selector: 'app-root',
  imports: [OtpComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'otp_angular';
}
