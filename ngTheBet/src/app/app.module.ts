import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserService } from './services/user.service';
import { HttpClientModule } from '@angular/common/http'
import { BetService } from './services/bet.service';
import { BetComponent } from './components/bet/bet.component';
import { FormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { IncompletePipe } from './pipes/incomplete.pipe';
import { HomeComponent } from './components/home/home.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { NotFoundComponent } from './components/not-found/not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    BetComponent,
    IncompletePipe,
    HomeComponent,
    NavigationComponent,
    LoginComponent,
    RegisterComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    UserService,
    BetService,
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
