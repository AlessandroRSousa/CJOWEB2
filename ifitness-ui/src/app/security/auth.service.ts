import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loginUrl = 'http://localhost:8080/api/auth/login';

  // conteúdo do token: sub, name, user_id, authorities, exp...
  jwtPayload: any;

  constructor(
    private http: HttpClient,
    private jwtHelper: JwtHelperService
  ) {
    this.loadToken();
  }

  async login(email: string, password: string): Promise<void> {
    const body = { username: email, password: password };
    const response: any = await firstValueFrom(this.http.post(this.loginUrl, body));
    this.storeToken(response['accessToken']);
  }

  logout(): void {
    localStorage.removeItem('token');
    this.jwtPayload = null;
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  isInvalidAccessToken(): boolean {
    const token = this.getToken();
    return !token || this.jwtHelper.isTokenExpired(token);
  }

  isLoggedIn(): boolean {
    return !this.isInvalidAccessToken();
  }

  hasPermission(permission: string): boolean {
    const authorities: string = this.jwtPayload?.authorities ?? '';
    return authorities.split(' ').includes(permission);
  }

  hasAnyPermission(roles: string[]): boolean {
    for (const role of roles) {
      if (this.hasPermission(role)) {
        return true;
      }
    }
    return false;
  }

  private storeToken(token: string): void {
    this.jwtPayload = this.jwtHelper.decodeToken(token);
    localStorage.setItem('token', token);
  }

  // ao abrir ou recarregar a aplicação, recupera o token guardado no navegador
  private loadToken(): void {
    const token = this.getToken();
    if (token) {
      this.storeToken(token);
    }
  }

}