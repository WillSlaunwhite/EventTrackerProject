export class Bet {
  id: number;
  name: string;
  wager: string;
  completed: boolean;
  wagerDate: string;
  deadlineDate: string | null;
  completeDate: string | null;
  betteeId: number;
  bettorId: number;

  constructor(
    id: number = 0,
    name: string = '',
    wager: string = '',
    completed: boolean = false,
    wagerDate: string = '',
    deadlineDate: string = '',
    completeDate: string = '',
    betteeId: number = 1,
    bettorId: number = 1
  ) {
    this.id = id;
    this.name = name;
    this.wager = wager;
    this.wagerDate = wagerDate;
    this.completed = completed;
    this.deadlineDate = deadlineDate;
    this.completeDate = completeDate;
    this.bettorId = bettorId;
    this.betteeId = betteeId;
  }


}
