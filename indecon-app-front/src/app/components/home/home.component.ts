import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { IndeconService } from '../../services/indecon.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent {

  elementos: any = [];
  loading: boolean = true;
  error: boolean = false;

  constructor(private indeconService: IndeconService,
              private router: Router) {
    this.ultimosValores();
  }


  ultimosValores(){
    this.indeconService.ultimosValores()
    .subscribe( resp => {
      this.loading = false;
      this.elementos = resp;
    }, (err) => {
      this.loading = false;
      this.error = true;
  });
  }


  verElemento(keyElemento: string ){
    this.router.navigate(['/elemento', keyElemento]);
  }

}
