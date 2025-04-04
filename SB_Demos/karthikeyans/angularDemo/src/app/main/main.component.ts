import { Component } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-main',
  imports: [MainComponent,FooterComponent,HeaderComponent],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {


  title = 'angularDemo';
  message = "Good day to be here";
  isMessageVisible = true;

  showTest() {

    this.message = "Button Clicked!";
  }
  pic1: String ="imgs\\ad-pay-logo.jpg"
}
