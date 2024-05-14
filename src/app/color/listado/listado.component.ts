import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ColorService } from '../color.service';
import { Color } from '../color';
import { HeaderComponent } from '../../pages/header/header.component';

@Component({
  selector: 'app-listado',
  standalone: true,
  imports: [CommonModule, RouterModule,HeaderComponent],
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css','../../app.component.css']
})
export class ListadoComponent {

  colors: Color[] = [];
    
  
  constructor(public colorService: ColorService, private router: Router) { }
    
  /**
   * Write code on Method
   *
   * @return response()
   */
  ngOnInit(): void {
    this.colorService.getAll().subscribe((data: Color[])=>{
      this.colors = data;
      console.log(this.colors);
    })  
  }

  /**
   * Write code on Method
   *
   * @return response()
   */

  deleteColor(idcolor:number){
    this.colorService.status(idcolor).subscribe(res => {
      this.loadData();
      console.log('Color Eliminado Correctamente');
    })
  }

  loadData() {
    this.colorService.getAll().subscribe(
      (data) => {
        this.colors = data;
      },
      (error) => {
        console.error('Error al cargar los colores:', error);
      }
    );
  }

}
