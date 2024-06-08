import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmailServiceService {
  private emailSource = new BehaviorSubject<string>('');
  public currentEmail = this.emailSource.asObservable();

  public changeEmail(email: string): void {
    this.emailSource.next(email);
  }
}
