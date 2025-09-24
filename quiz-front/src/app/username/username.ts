import { Component, inject, model, signal } from '@angular/core';
import { Styles } from '../services/styles';
import { FormsModule } from "@angular/forms";
import { User } from '../services/user';
import { single } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-username',
  imports: [FormsModule],
  templateUrl: './username.html',
  styleUrl: './username.css'
})
export class Username {
  styles = inject(Styles)
  user = inject(User)
  router = inject(Router)
  
  click() {
    if (this.user.validUsername()) {
      this.router.navigate(["quizes"])
    }
  }
}
