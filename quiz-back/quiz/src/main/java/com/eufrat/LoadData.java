package com.eufrat;

import com.eufrat.model.Question;
import com.eufrat.model.Quiz;
import com.eufrat.repository.QuizRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadData {
    @Autowired
    private QuizRepository quizRepository;

    @PostConstruct
    public void load() {
        quiz1();
        quiz2();
        quiz3();
        quiz4();
    }

    private void quiz1() {
        var quiz1 = new Quiz();
        quiz1.setTitle("Geography - capitals");
        quiz1.setNumOfQuestions(0);
        quiz1.setQuestions(new ArrayList<>());

        addQuestion(
                quiz1,
                "What is the capital of Poland?",
                List.of("Opole", "Gdańsk", "Warszawa", "Gniezno"),
                "Warszawa"
        );
        addQuestion(
                quiz1,
                "What is the capital of France?",
                List.of("Haguenau", "Ribeauvillé", "Paris", "Mont-de-Marsan"),
                "Paris"
        );
        addQuestion(
                quiz1,
                "What is the capital of Germany?",
                List.of("Hamburg", "Dortmund", "Dresden", "Berlin"),
                "Berlin"
        );
        addQuestion(
                quiz1,
                "What is the capital of Spain?",
                List.of("Barcelona", "Seville", "Valencia", "Bilbao"),
                "Barcelona"
        );
        addQuestion(
                quiz1,
                "What is the capital of Japan?",
                List.of("Osaka", "Tokyo", "Sapporo", "Kyoto"),
                "Tokyo"
        );
        addQuestion(
                quiz1,
                "What is the capital of Argentina?",
                List.of("Salta", "Rosario", "Pilar", "Buenos Aires"),
                "Buenos Aires"
        );
        quizRepository.save(quiz1);
    }

    private void quiz2() {
        var quiz1 = new Quiz();
        quiz1.setTitle("Funny quiz");
        quiz1.setNumOfQuestions(0);
        quiz1.setQuestions(new ArrayList<>());

        addQuestion(
                quiz1,
                "Why don’t skeletons ever go to parties?",
                List.of("3", "4", "22", "Depends on the mood of the calculator"),
                "4"
        );
        addQuestion(
                quiz1,
                "If you have 5 cookies and eat 3, what do you have?",
                List.of("A math problem", "2 cookies left", "Regret", "Crumbs and happiness"),
                "2 cookies left"
        );
        addQuestion(
                quiz1,
                "What is the square root of 81?",
                List.of("9", "8", "18", "A very square number"),
                "9"
        );
        addQuestion(
                quiz1,
                "Why was the equal sign so humble?",
                List.of("It had no value", "It couldn’t divide", "It knew it wasn’t greater than or less than anyone", "It was tired of all the math drama"),
                "It knew it wasn’t greater than or less than anyone"
        );

        quizRepository.save(quiz1);
    }

    private void quiz3() {
        var quiz1 = new Quiz();
        quiz1.setTitle("Math quiz");
        quiz1.setNumOfQuestions(0);
        quiz1.setQuestions(new ArrayList<>());

        addQuestion(
                quiz1,
                "What’s 2 + 2?",
                List.of("They don’t like loud music", "They don’t have the guts", "They’re bone-tired", "They always get picked apart"),
                "They don’t have the guts"
        );
        addQuestion(
                quiz1,
                "What’s a computer’s favorite snack?",
                List.of("Chips and salsa", "Cookies", "Micro-bytes", "Anything with RAM in it"),
                "Cookies"
        );
        addQuestion(
                quiz1,
                "What did the ocean say to the beach??",
                List.of("“Nice sand!”", "“Stop waving at me.”", "Nothing, it just waved", "“Tide's up, bro!”"),
                "Nothing, it just waved"
        );
        addQuestion(
                quiz1,
                "Why did the scarecrow win an award?",
                List.of("He was outstanding in his field", "He scared away all the crows", "He finally got a brain", "He pulled an all-nighter"),
                "He was outstanding in his field"
        );
        addQuestion(
                quiz1,
                "What do you call fake spaghetti?",
                List.of("Pasta la vista", "An impasta", "Faux-ghetti", "Noodle nonsense"),
                "An impasta"
        );

        quizRepository.save(quiz1);
    }

    private void quiz4() {
        var quiz1 = new Quiz();
        quiz1.setTitle("Yes/no quiz");
        quiz1.setNumOfQuestions(0);
        quiz1.setQuestions(new ArrayList<>());

        addQuestion(
                quiz1,
                "Can you watch movies on Netflix without the internet?",
                List.of("Yes", "No"),
                "Yes"
        );
        addQuestion(
                quiz1,
                "Is Batman part of the Marvel Universe?",
                List.of("Yes", "No"),
                "No"
        );
        addQuestion(
                quiz1,
                "Can smartphones be used to toast bread?",
                List.of("Yes", "No"),
                "No"
        );
        addQuestion(
                quiz1,
                "Was there ever a purple Teletubby?",
                List.of("Yes", "No"),
                "Yes"
        );
        addQuestion(
                quiz1,
                "Is \"YOLO\" short for “You Obviously Love Oranges”?",
                List.of("Yes", "No"),
                "No"
        );


        quizRepository.save(quiz1);
    }

    private void addQuestion(Quiz quiz, String question, List<String> choices, String ans) {
        var q = new Question();
        quiz.getQuestions().add(q);
        quiz.setNumOfQuestions(quiz.getNumOfQuestions() + 1);
        q.setChoices(choices);
        q.setQuestion(question);
        q.setAnswer(ans);
        q.setQuiz(quiz);
    }
}
