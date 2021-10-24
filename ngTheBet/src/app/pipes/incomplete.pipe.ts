import { Pipe, PipeTransform } from '@angular/core';
import { Bet } from '../models/bet';

@Pipe({
  name: 'incomplete',
})
export class IncompletePipe implements PipeTransform {
  transform(bets: Bet[], showComplete = false): Bet[] {
    let results: Bet[] = [];

    if (showComplete) {
      results = bets;
    } else {
      for (let bet of bets) {
        if (!bet.completed) {
          results.push(bet);
        }
      }
    }
    return results;
  }
}
