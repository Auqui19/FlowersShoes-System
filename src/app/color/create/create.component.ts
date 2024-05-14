import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ColorService } from '../color.service';
import { Router } from '@angular/router';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { HeaderComponent } from '../../pages/header/header.component';
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-create',
  standalone: true,
  imports: [CommonModule, RouterModule,HeaderComponent,ReactiveFormsModule],
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css','../../app.component.css']
})

export class CreateComponent {

  form!: FormGroup;

  constructor(
    public colorService: ColorService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      color: new FormControl('', [Validators.required]),
    });
  }

  get f(){
    return this.form.controls;
  }

  submit(){
    console.log(this.form.value);
    this.colorService.save(this.form.value).subscribe((res:any) => {
         console.log('Color created successfully!');
         this.router.navigateByUrl('color/listado');
    })
  }

}