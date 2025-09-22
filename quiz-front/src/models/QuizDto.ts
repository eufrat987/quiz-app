import { QuestionDto } from "./QuestionDto";

export interface QuizDto {
    id: Number
    title: String,
    questions: QuestionDto[]
}