import { Component, inject, resource, signal } from '@angular/core';
import { QuizDto } from '../../models/QuizDto';
import { Styles } from '../services/styles';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-quizes',
  imports: [],
  templateUrl: './quizes.html',
  styleUrl: './quizes.css'
})
export class Quizes {
  styles = inject(Styles)
  http = inject(HttpClient)
  router = inject(Router)

  quizes = resource({
    loader: () => firstValueFrom(this.http.get<QuizDto[]>("http://localhost:8080/api/quiz"))
  })

  quizClick(id : number) {
    console.log("cc")
    this.router.navigate(["quiz/" + id])
  }

  createQuizClick() {

  }
  
}
