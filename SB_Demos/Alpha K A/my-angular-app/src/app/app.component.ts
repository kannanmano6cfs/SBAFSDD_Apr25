import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MainComponent } from './main/main.component';

@Component({
  selector: 'app-root',
 // imports: [RouterOutlet, HeaderComponent, MainComponent, FooterComponent],
 imports: [RouterOutlet, HeaderComponent,  FooterComponent],
 templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'my-angular-app';
  message = "Welcome to explore my first angular web project";
}
