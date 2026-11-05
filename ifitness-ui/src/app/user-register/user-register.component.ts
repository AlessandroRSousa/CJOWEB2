import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

import { User } from '../../core/model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-register',
  imports: [
    FormsModule
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

  successMessage = '';
  errorMessages: string[] = [];

  constructor(private userService: UserService) { }

  save(form: NgForm): void {
    this.successMessage = '';
    this.errorMessages = [];

    this.userService.add(this.user)
      .then(userSaved => {
        this.successMessage = `Usuário ${userSaved.name} cadastrado com sucesso!`;
        this.clear(form);
      })
      .catch(response => {
        this.errorMessages = this.getErrorMessages(response);
      });
  }

  clear(form: NgForm): void {
    form.resetForm();
    this.user = new User();
    this.passwordConfirmation = '';
  }

  passwordsMatch(): boolean {
    return this.user.password === this.passwordConfirmation;
  }

  private getErrorMessages(response: any): string[] {
    // erros de validação: a API devolve uma lista
    if (Array.isArray(response.error)) {
      return response.error.map((error: any) => error.userMessage);
    }
    // mensagem inválida: a API devolve um único objeto
    if (response.error?.userMessage) {
      return [response.error.userMessage];
    }
    return ['Erro ao processar serviço remoto. Tente novamente.'];
  }

}
