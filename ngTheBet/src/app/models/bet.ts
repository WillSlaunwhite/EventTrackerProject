export class Bet {
  id: number;
  name: string;
  wager: string;
  completed: boolean;
  failed: boolean | undefined;
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
    failed: boolean = false,
    wagerDate: string = '',
    deadlineDate: string = '',
    completeDate: string = '',
    betteeId: number = 1,
    bettorId: number = 3
    ) {
      this.id = id;
      this.name = name;
      this.wager = wager;
      this.wagerDate = wagerDate;
      this.completed = completed;
      this.failed = failed;
      this.deadlineDate = deadlineDate;
      this.completeDate = completeDate;
      this.bettorId = bettorId;
      this.betteeId = betteeId;
    }

  }
