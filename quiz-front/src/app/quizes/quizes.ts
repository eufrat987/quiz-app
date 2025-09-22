import { Component, signal } from '@angular/core';
import { QuizDto } from '../../models/QuizDto';

@Component({
  selector: 'app-quizes',
  imports: [],
  templateUrl: './quizes.html',
  styleUrl: './quizes.css'
})
export class Quizes {
  quizes = signal<QuizDto[]>([
    {
      id: 1,
      title: "Geography",
      questions: [ 
        
      ]
    }
  ])
  
}
