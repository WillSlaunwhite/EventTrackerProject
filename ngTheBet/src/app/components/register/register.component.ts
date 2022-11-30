import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  constructor(private auth: UserService, private router: Router) { }

  newUser: User = new User();

  register(user: User) {
    console.log('Registering user:');
    console.log(user);
    this.auth.register(user).subscribe(
      data => {
        console.log('RegisterComponent.register(): user registered.');
        this.auth.login(user.username, user.password).subscribe(
          next => {
            console.log('RegisterComponent.register(): user logged in, routing to /bets.');
            this.router.navigateByUrl('/bets');
          },
          error => {
            console.error('RegisterComponent.register(): error logging in.');
            console.error(error);
          }
        );
      },
      err => {
        console.error('RegisterComponent.register(): error registering.');
        console.error(err);
      }
    );
  }

  ngOnInit(): void {
  }

}
