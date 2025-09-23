import { Component, inject, model, signal } from '@angular/core';
import { Styles } from '../services/styles';
import { FormsModule } from "@angular/forms";
import { User } from '../services/user';
import { single } from 'rxjs';

@Component({
  selector: 'app-username',
  imports: [FormsModule],
  templateUrl: './username.html',
  styleUrl: './username.css'
})
export class Username {
  styles = inject(Styles)
  user = inject(User)
  
  click() {
    this.user.redirectIfNeeded()
  }
}
