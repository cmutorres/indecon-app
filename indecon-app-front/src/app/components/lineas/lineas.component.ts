import { Component, OnInit , Input} from '@angular/core';
import { ChartDataSets, ChartOptions } from 'chart.js';
import { Color, BaseChartDirective, Label } from 'ng2-charts';

@Component({
  selector: 'app-lineas',
  templateUrl: './lineas.component.html'
})
export class LineasComponent  implements OnInit {

  @Input() item: any = {};
  @Input() key: string;

  VALUES: Map<string, any>  = new Map<string, any>([]);

  data: boolean = false;

  constructor() { }

  ngOnInit() {
    while( ! this.key ){
      console.log(this.key);
    }

    this.data = true;
    this.randomize();
  }

  public barChartOptions: ChartOptions = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: { xAxes: [{}], yAxes: [{}] },
    plugins: {
      datalabels: {
        anchor: 'end',
        align: 'end',
      }
    }
  };
  public barChartLabels: Label[] = ['Enero', 'Febreo', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
  public barChartType: any = 'bar';
  public barChartLegend = true;

  public barChartData: ChartDataSets[] = [
    { data: [], label: '2019' },
    { data: [], label: '2020' }
  ];
  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public randomize(anio:string = ''): void {
    this.VALUES = this.item;

    this.barChartData[0].data = [];
    this.barChartData[1].data = [];

    if ( anio === '2019'){
        this.barChartData[0].data = this.setAnio(anio);
    } else if ( anio === '2020'){
      this.barChartData[1].data = this.setAnio(anio);
    } else {
      this.barChartData[0].data = this.setAnio('2019');
      this.barChartData[1].data = this.setAnio('2020');
    }
    console.log(this.item)
  }

  setAnio(anio: string){
      const reporteOn: any[] = this.VALUES[anio];

      const dataOn = [
      reporteOn['Enero'],
      reporteOn['Febrero'],
      reporteOn['Marzo'],
      reporteOn['Abril'],
      reporteOn['Mayo'],
      reporteOn['Junio'],
      reporteOn['Julio'],
      reporteOn['Agosto'],
      reporteOn['Septiembre'],
      reporteOn['Octubre'],
      reporteOn['Noviembre'],
      reporteOn['Diciembre']];

      return dataOn;
  }

}