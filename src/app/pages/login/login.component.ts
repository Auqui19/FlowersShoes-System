import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

import { TrabajadorService } from '../../Trabajador/Trabajador.service';
import { LoginResponse, Trabajador } from '../../Trabajador/Trabajador';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css','../../app.component.css']
})
export class LoginComponent {
  form!: FormGroup;

  constructor(public trabajadorService: TrabajadorService, private router: Router ) { }
    
  /**
   * Write code on Method
   *
   * @return response()
   */
  ngOnInit(): void {
    this.form = new FormGroup({
      email: new FormControl('', [Validators.required]),
      password: new FormControl('', Validators.required)
    });
  }

  /**
   * Write code on Method
   *
   * @return response()
   */
  get f(){
    return this.form.controls;
  }

  submit(): void {
    this.trabajadorService.login(this.form.value).subscribe((res:LoginResponse) => {
      console.log('Post created successfully!');
      console.log(res.token);
      localStorage.setItem('token',res.token);
      this.router.navigateByUrl('color/listado');
    }) 
  }
}
