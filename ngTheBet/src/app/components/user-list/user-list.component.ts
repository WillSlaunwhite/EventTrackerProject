import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(){
    this.userService.index().subscribe(
      usersLoaded => {
        this.users = usersLoaded;
      },
      fail => {
        console.error('UserListComponent.index(): error loading users');
        console.error(fail);

      });

  }

}
