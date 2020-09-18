import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
import { PlanetListComponent } from './planet-list/planet-list.component';
import { PrependPipe } from './shared/prepend.pipe';

//This is a decorator in Angular, looks like an annotation in Java. 
//Speficially the "NgModule" decorator 
@NgModule({
  declarations: [ // used for declaring components (and pipes)
    AppComponent, TestComponent, PlanetListComponent, PrependPipe
  ],
  imports: [ // used to import external modules 
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
