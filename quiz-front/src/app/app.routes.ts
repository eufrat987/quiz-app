import { Routes } from '@angular/router';
import { Username } from './username/username';
import { Quiz } from './quiz/quiz';
import { Quizes } from './quizes/quizes';

export const routes: Routes = [
    { path: '', component: Username },
    { path: 'random', component: Quiz },
    { path: 'quizes', component: Quizes }
];
