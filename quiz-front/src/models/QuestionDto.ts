import { AnswerDto } from "./AnswersDto"

export interface QuestionDto {
    id: number
    question: string
    choices: string[]
}