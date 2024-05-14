import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ColorService } from '../color.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Color } from '../color';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { RouterModule } from '@angular/router';
@Component({
  selector: 'app-edit-color',
  standalone: true,
  imports: [CommonModule, RouterModule, ReactiveFormsModule],
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css','../../app.component.css']
})
export class EditComponent {

  idcolor!: number;
  color!: Color;
  form!: FormGroup;

  constructor(
    public colorService: ColorService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.idcolor = this.route.snapshot.params['colorId'];
    this.colorService.find(this.idcolor).subscribe((data: Color)=>{
      this.color = data;
    }); 

    this.form = new FormGroup({
      idcolor: new FormControl('', [Validators.required]),
      color: new FormControl('', Validators.required)
    });
  }

  get f(){
    return this.form.controls;
  }

  submit(){
    console.log(this.form.value);
    this.colorService.save(this.form.value).subscribe((res:any) => {
         console.log('Color updated successfully!');
         this.router.navigateByUrl('color/listado');
    })
  }

}