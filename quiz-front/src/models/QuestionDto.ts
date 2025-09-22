import { AnswerDto } from "./AnswersDto"

export interface QuestionDto {
    id: Number
    question: String
    answers: AnswerDto[]
}