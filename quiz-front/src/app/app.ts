import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from "./shared/header/header";
import { Quizes } from "./quizes/quizes";
import { Quiz } from "./quiz/quiz";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header, Quizes, Quiz],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('quiz-front');
}
