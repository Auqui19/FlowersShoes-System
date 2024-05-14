  /**
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {  Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Talla } from './talla';
  
@Injectable({
  providedIn: 'root'
})
export class TallaService{

  
    private apiURL = "http://localhost:8092/talla/";
    
 
    httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
     
 
    constructor(private httpClient: HttpClient) { }
      
    
    getAll(): Observable<any> {
      const token=localStorage.getItem('token');
      console.log(token);
      const headers=new HttpHeaders({
        'Authorization':`${token}`
      });
      return this.httpClient.get(this.apiURL + 'listado',{headers:headers})
      .pipe(
        catchError(this.errorHandler)
      )
    }

    status(idcolor:number){
      const token=localStorage.getItem('token');
      console.log(token);
      const headers=new HttpHeaders({
        'Authorization':`${token}`
      });
      return this.httpClient.delete(this.apiURL + 'status/' + idcolor ,{headers:headers})
    
      .pipe(
        catchError(this.errorHandler)
      )
    }

    save(color:Color): Observable<any> {
      const token=localStorage.getItem('token');
      console.log(token);
      const headers = new HttpHeaders({
        'Authorization': `${token}`,
        'Content-Type': 'application/json' 
      });
      return this.httpClient.post(this.apiURL + 'save', JSON.stringify(color), {headers:headers})
   
      .pipe( 
        catchError(this.errorHandler)
      )
    }

     
    find(idcolor:number): Observable<any> {
      const token=localStorage.getItem('token');
      console.log(token);
      const headers = new HttpHeaders({
        'Authorization': `${token}`,
        'Content-Type': 'application/json' 
      });
      return this.httpClient.get(this.apiURL + 'encontrar/' + idcolor, {headers:headers})
    
      .pipe(
        catchError(this.errorHandler)
      )
    }
    
    errorHandler(error:any) {
      let errorMessage = '';
      if(error.error instanceof ErrorEvent) {
        errorMessage = error.error.message;
      } else {
        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
      }
      return throwError(errorMessage);
   }
   
}

**/