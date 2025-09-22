import { Component, inject, signal } from '@angular/core';
import { QuestionDto } from '../../models/QuestionDto';
import { Question } from "../question/question";
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

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
  questions = signal<QuestionDto[]>([
    {
      id: 1,
      question: "Capital?",
      answers: [
        {id: 1, content: 'Warsaw'}, 
        {id: 2, content: 'Cracow'},
        {id: 3, content: 'Opole'}
      ]
    },
    {
      id: 1,
      question: "Capital?",
      answers: [
        {id: 1, content: 'Warsaw'}, 
        {id: 2, content: 'Cracow'},
        {id: 3, content: 'Opole'}
      ]
    },
    {
      id: 1,
      question: "Capital?",
      answers: [
        {id: 1, content: 'Warsaw'}, 
        {id: 2, content: 'Cracow'},
        {id: 3, content: 'Opole'}
      ]
    },
    {
      id: 1,
      question: "Capital?",
      answers: [
        {id: 1, content: 'Warsaw'}, 
        {id: 2, content: 'Cracow'},
        {id: 3, content: 'Opole'}
      ]
    },
    {
      id: 1,
      question: "Capital?",
      answers: [
        {id: 1, content: 'Warsaw'}, 
        {id: 2, content: 'Cracow'},
        {id: 3, content: 'Opole'}
      ]
    },
    {
      id: 1,
      question: "Capital?",
      answers: [
        {id: 1, content: 'Warsaw'}, 
        {id: 2, content: 'Cracow'},
        {id: 3, content: 'Opole'}
      ]
    },
    {
      id: 1,
      question: "Capital?",
      answers: [
        {id: 1, content: 'Warsaw'}, 
        {id: 2, content: 'Cracow'},
        {id: 3, content: 'Opole'}
      ]
    },
    {
      id: 1,
      question: "Capital?",
      answers: [
        {id: 1, content: 'Warsaw'}, 
        {id: 2, content: 'Cracow'},
        {id: 3, content: 'Opole'}
      ]
    },
  ])
  
  
  constructor() {
    for (let question of this.questions()) {
      this.form.addControl(
        this.questionGroupId(question),
        this.fb.group({
          answer: [null, Validators.required]
        })
      )
    }
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
