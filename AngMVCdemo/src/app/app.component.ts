import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CourselistComponent } from '../courselist/courselist.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,CourselistComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'trainingmgmtapp';
}
