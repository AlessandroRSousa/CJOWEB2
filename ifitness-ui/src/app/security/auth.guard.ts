import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

import { AuthService } from './auth.service';

export const authGuard: CanActivateFn = (route, state) => {
  const auth = inject(AuthService);
  const router = inject(Router);

  // 1. Sem token ou com token expirado: o usuário não está logado
  if (auth.isInvalidAccessToken()) {
    auth.logout();
    return router.createUrlTree(['/login']);
  }

  // 2. Está logado. Tem alguma das permissões exigidas pela rota?
  const roles = route.data['roles'];
  if (roles && !auth.hasAnyPermission(roles)) {
    return router.createUrlTree(['/not-authorized']);
  }

  return true;
};