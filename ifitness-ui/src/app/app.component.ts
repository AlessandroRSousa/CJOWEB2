import { Component } from '@angular/core';

import { FooterComponent } from './core/footer/footer.component';
import { UserRegisterComponent } from './users/user-register/user-register.component';

@Component({
  selector: 'app-root',
  imports: [
    UserRegisterComponent,
    FooterComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'IFitness';
}