import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bet } from 'src/app/models/bet';
import { User } from 'src/app/models/user';
import { BetService } from 'src/app/services/bet.service';

@Component({
  selector: 'app-bet',
  templateUrl: './bet.component.html',
  styleUrls: ['./bet.component.css'],
})
export class BetComponent implements OnInit {
  constructor(
    private betService: BetService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  bets: Bet[] = [];
  selectedBet: Bet | null = null;
  newBet: Bet = new Bet(0, '', '', false); // this line might cause an error, remove optional modifier from bet args
  betToEdit: Bet | null = null;
  showCompletedBets = false;

  ngOnInit(): void {
    if (!this.selectedBet && this.route.snapshot.paramMap.get('id')) {
      this.betService.show(this.route.snapshot.params['id']).subscribe(
        (success) => {
          this.loadBets();
          this.selectedBet = success;
        },
        (fail) => {
          console.error(
            'TodoListComponent.ngOnInit(): error initializing todo by id'
          );
          console.error(fail);
          this.router.navigateByUrl('notfound');
        }
      );
    } else {
      this.loadBets();
    }
  }

  loadBets() {
    this.betService.index().subscribe(
      (betList) => {
        this.bets = betList;
      },
      (failed) => {
        console.error('BetComponent.loadBets(): Error getting bets list');
      }
    );
  }

  createBet(bet: Bet) {
    this.betService.create(bet).subscribe(
      (newBet) => {
        this.loadBets();
        this.newBet = new Bet();
      },
      (fail) => {
        console.error('BetComponent.addBet(): Error creating Bet');
        console.error(fail);
      }
    );
  }

  updateBet(bet: Bet, showBet = true): void {
    this.betService.update(bet).subscribe(
      (betUpdated) => {
        this.loadBets();
        this.betToEdit = null;
        if (showBet) {
          this.selectedBet = betUpdated;
        }
      },
      (failedToUpdate) => {
        console.error('BetComponent.updateBet(): error updating Bet');
        console.error(failedToUpdate);
      }
    );
  }

  deleteBet(id: number): void {
    this.betService.destroy(id).subscribe(
      (deletedBet) => {
        this.loadBets();
        console.log('successfully deleted bet number ' + String(id));
      },
      (failedToDelete) => {
        console.error('BetComponent.delete(): error deleting Bet');
        console.error(failedToDelete);
      }
    );
  }

  hideBet(): void {
    this.selectedBet = null;
  }

  displayBet(bet: Bet): void {
    this.selectedBet = bet;
  }

  getNumOfBets(): number {
    return this.bets.length;
    // will need to update this once I make a pipe to check which bets are done
  }

  setBetToEdit(): void {
    this.betToEdit = Object.assign({}, this.selectedBet);
  }
}
