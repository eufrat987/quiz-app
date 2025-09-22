import { QuestionDto } from "./QuestionDto";

export interface QuizDto {
    id: number
    title: string,
    questions: QuestionDto[]
}