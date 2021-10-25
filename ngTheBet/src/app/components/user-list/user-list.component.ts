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
    // may need to come back to this later if I find I need
    // a way to generate a list of users.

    // I created this class during the setup/demo and ended up not needing it.

    // this.loadUsers();
  }

  // loadUsers(){
  //   this.userService.index().subscribe(
  //     usersLoaded => {
  //       this.users = usersLoaded;
  //     },
  //     fail => {
  //       console.error('UserListComponent.loadUsers(): error loading users');
  //       console.error(fail);
  //     });

  // }

}
