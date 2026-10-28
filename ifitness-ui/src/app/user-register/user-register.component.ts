import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

import { User } from '../../core/model';

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

  save(form: NgForm): void {
    console.log(this.user);
  }

  clear(form: NgForm): void {
    form.resetForm();
    this.user = new User();
    this.passwordConfirmation = '';
  }

  passwordsMatch(): boolean {
    return this.user.password === this.passwordConfirmation;
  }

}
