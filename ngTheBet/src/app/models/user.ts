import { Bet } from "./bet";

export class User {
  id: number;
  name: string;
  username: string;
  password: string;
  bets: Bet[] = [];


  constructor(
    id: number = 0,
    name: string = '',
    username: string = '',
    password: string = ''
  ) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
  }
}
