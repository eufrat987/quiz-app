import { Component, inject } from '@angular/core';
import { User } from '../../services/user';
import { Router, RouterLink } from '@angular/router';
import { routes } from '../../app.routes';
import { Username } from '../../username/username';

@Component({
  selector: 'app-header',
  imports: [RouterLink],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {
  user = inject(User)
  router = inject(Router)
  

  get showUsername() : boolean {
    return this.router.url !== ("/" + routes.filter(route => route.component === Username)[0].path)
  }

}
