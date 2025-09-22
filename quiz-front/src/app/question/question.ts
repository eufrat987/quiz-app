import { Component, input, signal } from '@angular/core';
import { AnswerDto } from '../../models/AnswersDto';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-question',
  imports: [ReactiveFormsModule],
  templateUrl: './question.html',
  styleUrl: './question.css'
})
export class Question {

  questionId = input.required<number>()
  question = input.required<string>()
  answers = input.required<AnswerDto[]>()
  form = input.required<FormGroup>()

}
