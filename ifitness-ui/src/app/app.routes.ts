import { Routes } from '@angular/router';

import { LoginFormComponent } from './security/login-form/login-form.component';
import { UserRegisterComponent } from './users/user-register/user-register.component';
import { HomeComponent } from './core/home/home.component';
import { NotAuthorizedComponent } from './core/not-authorized/not-authorized.component';
import { PageNotFoundComponent } from './core/page-not-found/page-not-found.component';
import { authGuard } from './security/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {
    path: 'home',
    component: HomeComponent,
    title: 'IFitness - Painel Inicial',
    canActivate: [authGuard],
    data: { roles: ['ROLE_SEARCH_USER'] }
  },
  { path: 'login', component: LoginFormComponent, title: 'IFitness - Login' },
  { path: 'users/new', component: UserRegisterComponent, title: 'IFitness - Cadastro de Usuário' },
  { path: 'not-authorized', component: NotAuthorizedComponent, title: 'IFitness - Acesso negado' },
  { path: 'page-not-found', component: PageNotFoundComponent, title: 'IFitness - Página não encontrada' },
  { path: '**', redirectTo: 'page-not-found' } // importante que seja a última rota
];