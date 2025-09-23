import { Component, input, signal } from '@angular/core';
import { AnswerDto } from '../../models/AnswersDto';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { QuestionDto } from '../../models/QuestionDto';

@Component({
  selector: 'app-question',
  imports: [ReactiveFormsModule],
  templateUrl: './question.html',
  styleUrl: './question.css'
})
export class Question {
  index = input.required<number>()
  questionDto = input.required<QuestionDto>()
  formGroup = input.required<FormGroup>()


  getColor() : string {
    if (this.index()%3 === 0) {
      return "bg-blue-100 dark:bg-blue-800";
    } else if (this.index()%3 === 1) {
      return "bg-blue-200  dark:bg-blue-700";
    } else {
      return "bg-blue-300  dark:bg-blue-600";
    }
  }
}
