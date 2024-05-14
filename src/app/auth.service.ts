import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate {

  constructor(private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    // Verificar si el token existe en el localStorage
    const token = localStorage.getItem('token');

    // Si no hay token, redirigir al usuario a la página de inicio de sesión
    if (!token) {
      this.router.navigate(['trabajador/login'], { queryParams: { returnUrl: state.url } });
      return false; // Retorna falso para evitar el acceso a la ruta protegida
    }

    return true; 
  }
}