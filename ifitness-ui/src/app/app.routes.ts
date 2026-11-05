import { Routes } from '@angular/router';

import { LoginFormComponent } from './security/login-form/login-form.component';
import { UserRegisterComponent } from './users/user-register/user-register.component';
import { PageNotFoundComponent } from './core/page-not-found/page-not-found.component';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginFormComponent, title: 'IFitness - Login' },
  { path: 'users/new', component: UserRegisterComponent, title: 'IFitness - Cadastro de Usuário' },
  { path: 'page-not-found', component: PageNotFoundComponent, title: 'IFitness - Página não encontrada' },
  { path: '**', redirectTo: 'page-not-found' } // importante que seja a última rota
];

