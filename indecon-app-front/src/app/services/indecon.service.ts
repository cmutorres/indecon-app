import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IndeconService {

  constructor(private http: HttpClient) { }

  getGlobal(query: string){
    const url = `http://localhost:8096/onboarding-indecon/${query}`;
    return this.http.get(
      url)
    .pipe(
      map( resp => {
        return resp;
      })
    );
}

  ultimosValores(){
    return this.getGlobal('ultimos-valores');
  }

  valores(key: string){
   return this.getGlobal(`valores?keyIndecon=${key.toUpperCase()}`);
  }

  valoresAnio(key: string){
    return this.getGlobal(`valores/anio?keyIndecon=${key.toUpperCase()}`);
  }
}

