import { Component, inject, model, signal } from '@angular/core';
import { Styles } from '../utils/styles';
import { FormsModule } from "@angular/forms";
import { Router } from '@angular/router';

@Component({
  selector: 'app-username',
  imports: [FormsModule],
  templateUrl: './username.html',
  styleUrl: './username.css'
})
export class Username {
  styles = inject(Styles)
  username = localStorage.getItem("username")
  router = inject(Router)

  constructor() {
    console.log(this.username)
    if (this.username !== null) {
      this.router.navigate(["random"])
    }
  }
  
  click(username: string) {
    console.log(username)
    localStorage.setItem("username", username);
  }
}
