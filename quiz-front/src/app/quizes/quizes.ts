import { Component, inject, resource, signal } from '@angular/core';
import { QuizDto } from '../../models/QuizDto';
import { Styles } from '../services/styles';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-quizes',
  imports: [],
  templateUrl: './quizes.html',
  styleUrl: './quizes.css'
})
export class Quizes {
  styles = inject(Styles)
  http = inject(HttpClient)

  quizes = resource({
    loader: () => firstValueFrom(this.http.get<QuizDto[]>("http://localhost:8080/api/quiz"))
  })


  
}
