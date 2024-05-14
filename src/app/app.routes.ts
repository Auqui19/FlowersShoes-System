import { Routes } from '@angular/router';
import { ListadoComponent } from './color/listado/listado.component';
import { LoginComponent } from './pages/login/login.component';
import { CreateComponent } from './color/create/create.component';
import { EditComponent } from './color/edit/edit.component';
import { AuthService } from './auth.service';

export const routes: Routes = [
  { path: '', redirectTo: 'trabajador/login', pathMatch: 'full'},
  { path: 'trabajador/login', component: LoginComponent },
  { path: 'color/listado', component: ListadoComponent, canActivate: [AuthService] },
  { path: 'color/create', component: CreateComponent, canActivate: [AuthService] },
  { path: 'color/:colorId/edit', component: EditComponent, canActivate: [AuthService] }
];