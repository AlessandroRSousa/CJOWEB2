import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

import { User } from '../../core/model';
import { UserService } from '../user.service';
import { ErrorHandlerService } from '../../core/error-handler.service';
import { MessageService } from '../../core/message.service';
import { MessageComponent } from '../../shared/message/message.component';

@Component({
  selector: 'app-user-register',
  imports: [
    FormsModule,
    RouterLink,
    MessageComponent
  ],
  templateUrl: './user-register.component.html',
  styleUrl: './user-register.component.css'
})
export class UserRegisterComponent {

  user = new User();

  genders = [
    { label: 'Masculino', value: 'MASCULINO' },
    { label: 'Feminino', value: 'FEMININO' },
    { label: 'Outro', value: 'OUTRO' },
    { label: 'Prefiro não dizer', value: 'PREFIRO_NAO_DIZER' }
  ];

  passwordConfirmation = '';

  constructor(
    private userService: UserService,
    private errorHandler: ErrorHandlerService,
    private messageService: MessageService,
    private router: Router
  ) { }

  save(): void {
    this.userService.add(this.user)
      .then(() => this.router.navigate(['/login']))
      .then(() => this.messageService.success('Usuário cadastrado com sucesso! Faça o login.'))
      .catch(response => this.errorHandler.handle(response));
  }

  passwordsMatch(): boolean {
    return this.user.password === this.passwordConfirmation;
  }

}
