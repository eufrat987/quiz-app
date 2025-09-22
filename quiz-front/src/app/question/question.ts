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
  dto = input.required<QuestionDto>()
  formGroup = input.required<FormGroup>()
}
