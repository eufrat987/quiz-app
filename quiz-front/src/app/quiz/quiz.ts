import { Component, signal } from '@angular/core';
import { QuestionDto } from '../../models/QuestionDto';
import { Question } from "../question/question";
import { FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-quiz',
  imports: [Question, ReactiveFormsModule],
  templateUrl: './quiz.html',
  styleUrl: './quiz.css'
})
export class Quiz {
  title = signal<string>("")
  questions = signal<QuestionDto[]>([
    {
      id: 1,
      question: "Capi?",
      answers: [
        {id: 1, content: 'Warsaw'}, 
        {id: 2, content: 'Cracow'},
        {id: 3, content: 'Opole'}
      ]
    }
  ])
  
  form: FormGroup
  
  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({})
    
    for (let question of this.questions()) {
      this.form.addControl(
        "question" + question.id,
        this.fb.group({
          answer: [null, Validators.required]
        })
      )
    }
  }

  questionGroupForm(id : Number) : FormGroup {
    return this.form.get("question" + id) as FormGroup
  }
  
}
