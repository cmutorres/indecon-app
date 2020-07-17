import { Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';

@Pipe({
  name: 'domseguro'
})
export class DomseguroPipe implements PipeTransform {

  flagUri: any[] = [];

  constructor(private domSanitizer: DomSanitizer){}
  transform(value: string): any {

    this.flagUri = value.split(':');
    const url = 'http://www.indecon.online/';
    return this.domSanitizer.bypassSecurityTrustResourceUrl( url + value);
  }

}
