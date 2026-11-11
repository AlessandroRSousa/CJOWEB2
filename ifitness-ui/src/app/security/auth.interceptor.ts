import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';

import { AuthService } from './auth.service';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const auth = inject(AuthService);

  // sem token válido (login, cadastro de usuário): a requisição segue como está
  if (auth.isInvalidAccessToken()) {
    return next(req);
  }

  // com token: a requisição é copiada com o cabeçalho Authorization
  const authReq = req.clone({
    setHeaders: {
      Authorization: `Bearer ${auth.getToken()}`
    }
  });
  return next(authReq);
};
