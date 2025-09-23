import { Routes } from '@angular/router';
import { Username } from './username/username';
import { Quiz } from './quiz/quiz';

export const routes: Routes = [
    { path: '', component: Username },
    { path: 'random', component: Quiz },
];
