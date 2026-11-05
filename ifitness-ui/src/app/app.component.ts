import { Component } from '@angular/core';
import { NavigationStart, Router, RouterOutlet } from '@angular/router';

import { FooterComponent } from './core/footer/footer.component';
import { AlertComponent } from './shared/alert/alert.component';
import { MessageService } from './core/message.service';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    AlertComponent,
    FooterComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'IFitness';

  constructor(
    private router: Router,
    private messageService: MessageService
  ) {
    // limpa as mensagens sempre que o usuário muda de página
    this.router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        this.messageService.clear();
      }
    });
  }

}
