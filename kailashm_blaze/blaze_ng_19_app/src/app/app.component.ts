import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'blaze_ng_19_app';
  appName = 'Angular Demo App';
  oneWayValue = 'Initial Value';
  twoWayValue = 'Kailash Mishra';

  getCurrentDate() {
    return new Date().toLocaleDateString();
  }

  changeOneWayValue() {
    this.oneWayValue = 'Updated at ' + new Date().toLocaleTimeString();
  }
}
