import { Component, computed, effect, inject, signal } from '@angular/core';
import { QuestionDto } from '../../models/QuestionDto';
import { Question } from "../question/question";
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { toSignal } from '@angular/core/rxjs-interop';
import { QuizDto } from '../../models/QuizDto';

@Component({
  selector: 'app-quiz',
  imports: [Question, ReactiveFormsModule],
  templateUrl: './quiz.html',
  styleUrl: './quiz.css'
})
export class Quiz {
  http = inject(HttpClient)
  fb = inject(FormBuilder)
  form = this.fb.group({})
  
  id = 1
  title = signal<string>("")
  
  quiz = toSignal(this.http.get<QuizDto>("http://localhost:8080/api/quiz/random"));
  
  questions = signal<QuestionDto[]>([
    {
      id: 1,
      question: "Capital?",
      choices: [ "Warsaw", "Warsaw", "Warsaw", "Warsaw"]
    },
  ])
  
  
  constructor() {
    effect(() => {
      this.questions.set(this.quiz()?.questions ?? [])
      for (let question of this.questions()) {
        this.form.addControl(
          this.questionGroupId(question),
          this.fb.group({
            answer: [null, Validators.required]
          })
        )
      }
      
    })
    
    
  }
  
  questionGroupForm(question : QuestionDto) : FormGroup {
    return this.form.get(this.questionGroupId(question)) as FormGroup
  }
  
  questionGroupId(question : QuestionDto) : string {
    return "question" + question.id;
  }
  
  submit() {
    if (this.form.valid) {
      const data = this.form.value
      console.log(data)
      
      this.http.post(this.url, data)
      .subscribe({
        next: (response) => console.log(response),
        error: (error) => console.log(error)
      });
    } else {
      console.log("t")
      this.form.markAllAsTouched()
    }
  }
  
  get url() : string {
    return "http://localhost:8080/quiz" + this.id + "/answer";
  }
  
}
