import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(
    private userSvc: UserService,
    private router: Router
  ) { }

  loginUser: User = new User();

  login(user: User) {
    console.log('logging in');
    console.log(user);
    this.userSvc.login(user.username, user.password).subscribe(
      login => {
        this.router.navigateByUrl('/bets');
      },
      fail => {
        console.error('LoginComponent.login(): login failed');
        console.error(fail);
      }
    );


  }

  ngOnInit(): void {
  }

}
