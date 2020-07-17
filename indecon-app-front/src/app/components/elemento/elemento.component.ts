import { Component, OnInit } from '@angular/core';
import { IndeconService } from '../../services/indecon.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-elemento',
  templateUrl: './elemento.component.html'
})
export class ElementoComponent implements OnInit {

  elem: any = {};
  loading: boolean = true;
  servicio: boolean = false;
  key: string;
  error: boolean = false;

  constructor(private activatedRouter: ActivatedRoute,
              private router: Router,
              private indecon: IndeconService ) {

    this.loading = true;
    this.servicio = false;

    this.activatedRouter.params.subscribe(params => {
            this.key = params['key'];
    });

    this.valdiarKey(this.key );
    this.valoresAnio( this.key );
  }

  ngOnInit(): void {
  }

  valdiarKey(key: string){
      let listEnum: string[] = ['cobre', 'dolar', 'euro', 'ipc', 'ivp', 'oro', 'plata', 'uf', 'utm', 'yen'];
      if(listEnum.includes(key)){
          return;
      }else {
        this.loading =  false;
        this.router.navigate(['/home']);
      }
  }

  valores(key: string){
    this.indecon.valores(key)
              .subscribe( resp => {
                  this.elem = resp;
                  this.servicio = true;
                  this.loading = false;
                  }, (err) => {
                          this.loading = false;
                          this.servicio = false;
                          this.error = true;
                  });
  }

  valoresAnio(key: string){
    this.indecon.valoresAnio(key)
              .subscribe( resp => {
                  this.elem = resp;
                  this.loading = false;
                  this.servicio = true;
                  }, (err) => {
                          this.loading = false;
                          this.servicio = false;
                          this.error = true;
                  });
  }

  volver(){
    this.router.navigate(['/home']);
  }

}
