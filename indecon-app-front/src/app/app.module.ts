import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { SearchComponent } from './components/search/search.component';
import { IndeconService } from './services/indecon.service';
import { HttpClientModule } from '@angular/common/http';
import { DomseguroPipe } from './pipes/domseguro.pipe';
import { ElementoComponent } from './components/elemento/elemento.component';
import { LongToDatePipe } from './pipes/long-to-date.pipe';
import { LineasComponent } from './components/lineas/lineas.component';
import { ChartsModule } from 'ng2-charts';
import { LoadingComponent } from './components/loading/loading.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    SearchComponent,
    DomseguroPipe,
    ElementoComponent,
    LongToDatePipe,
    LineasComponent,
    LoadingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ChartsModule
  ],
  providers: [
    IndeconService],
  bootstrap: [AppComponent]
})
export class AppModule { }
