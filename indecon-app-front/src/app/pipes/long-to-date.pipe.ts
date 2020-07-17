import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'longToDate'
})
export class LongToDatePipe implements PipeTransform {

  transform(value: number): Date {
    return new Date(value * 1000);
  }

}
