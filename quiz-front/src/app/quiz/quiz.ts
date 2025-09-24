import { Component, computed, effect, inject, resource, Signal, signal } from '@angular/core';
import { QuestionDto } from '../../models/QuestionDto';
import { Question } from "../question/question";
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { toSignal } from '@angular/core/rxjs-interop';
import { QuizDto } from '../../models/QuizDto';
import { Styles } from '../services/styles';
import { User } from '../services/user';
import { firstValueFrom, lastValueFrom } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-quiz',
  imports: [Question, ReactiveFormsModule],
  templateUrl: './quiz.html',
  styleUrl: './quiz.css'
})
export class Quiz {
  id: number

  http = inject(HttpClient)
  fb = inject(FormBuilder)
  form = this.fb.group({})
  score = signal<number>(0)
  showScore = signal<boolean>(false)
  route = inject(ActivatedRoute)

  title = signal<string>("")
  
  // quiz: Signal<QuizDto | undefined> 
  questions = signal<QuestionDto[]>([])
  styles = inject(Styles)
  user = inject(User)
  quiz = resource({
    params: () => ({ id : this.id }),
    loader: (params) => firstValueFrom(this.http.get<QuizDto>("http://localhost:8080/api/quiz/"+ params.params.id))
  })

  constructor() {
    this.id = +this.route.snapshot.paramMap.get("id")!;

    this.user.redirectIfNeeded()
    // this.quiz = toSignal(this.http.get<QuizDto>("http://localhost:8080/api/quiz/random");

    effect(() => {
      this.title.set(this.quiz.value()?.title ?? "")
      this.questions.set(this.quiz.value()?.questions ?? [])
      for (let question of this.questions()) {
        this.form.addControl(
          this.questionGroupId(question),
          this.fb.group({
            [question.id]: [null, Validators.required]
          })
        )
      }
    })
  }
  
  questionGroupForm(question : QuestionDto) : FormGroup {
    return this.form.get(this.questionGroupId(question)) as FormGroup
  }
  
  questionGroupId(question : QuestionDto) : string {
    return "question_" + question.id;
  }
  
  submit() {
    if (this.form.valid) {
      const data = this.form.value
      console.log(data)
      console.log("data")
      
      this.http.post(this.url, data)
      .subscribe({
        next: (response) => {
          this.score.set(response as number)
          this.showScore.set(true)
          console.log(response)
        },
        error: (error) => console.log(error)
      });
    }
  }
  
  get url() : string {
    return "http://localhost:8080/api/quiz/" + this.quiz.value()?.id;
  }
  
  get buttonDisabled() : boolean {
    return !this.form.valid;
  }

}
