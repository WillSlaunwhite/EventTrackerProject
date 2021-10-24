export class Bet {
  id: number;
  name: string;
  wager: string;
  completed: boolean;
  wagerDate: string;
  deadlineDate: string | null;
  completeDate: string | null;

  constructor(
    id: number = 0,
    name: string = '',
    wager: string = '',
    completed: boolean = false,
    wagerDate: string = '',
    deadlineDate: string = '',
    completeDate: string = ''
  ) {
    this.id = id;
    this.name = name;
    this.wager = wager;
    this.wagerDate = wagerDate;
    this.completed = completed;
    this.deadlineDate = deadlineDate;
    this.completeDate = completeDate;
  }


}
