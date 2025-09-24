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
        quiz5();
        quiz6();
        quiz7();
        quiz8();
        quiz9();
        quiz10();
        quiz11();
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

    private void quiz5() {
        var quiz2 = new Quiz();
        quiz2.setTitle("History Quiz");
        quiz2.setNumOfQuestions(0);
        quiz2.setQuestions(new ArrayList<>());

        addQuestion(
                quiz2,
                "Who was the first President of the United States?",
                List.of("George Washington", "Abraham Lincoln", "John Adams", "Thomas Jefferson"),
                "George Washington"
        );
        addQuestion(
                quiz2,
                "In which year did World War II end?",
                List.of("1945", "1939", "1950", "1942"),
                "1945"
        );
        addQuestion(
                quiz2,
                "Which ancient civilization built the pyramids?",
                List.of("Romans", "Greeks", "Egyptians", "Mayans"),
                "Egyptians"
        );
        addQuestion(
                quiz2,
                "What was the name of the ship on which the Pilgrims traveled to North America in 1620?",
                List.of("Santa Maria", "Mayflower", "Endeavour", "Discovery"),
                "Mayflower"
        );
        addQuestion(
                quiz2,
                "Who discovered penicillin?",
                List.of("Alexander Fleming", "Marie Curie", "Isaac Newton", "Albert Einstein"),
                "Alexander Fleming"
        );

        quizRepository.save(quiz2);
    }

    private void quiz6() {
        var quiz3 = new Quiz();
        quiz3.setTitle("Science Quiz");
        quiz3.setNumOfQuestions(0);
        quiz3.setQuestions(new ArrayList<>());

        addQuestion(
                quiz3,
                "What planet is known as the Red Planet?",
                List.of("Mars", "Venus", "Jupiter", "Saturn"),
                "Mars"
        );
        addQuestion(
                quiz3,
                "What is the chemical symbol for water?",
                List.of("H2O", "O2", "CO2", "NaCl"),
                "H2O"
        );
        addQuestion(
                quiz3,
                "How many bones are in the adult human body?",
                List.of("206", "201", "196", "210"),
                "206"
        );
        addQuestion(
                quiz3,
                "What gas do plants absorb from the atmosphere?",
                List.of("Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"),
                "Carbon Dioxide"
        );
        addQuestion(
                quiz3,
                "What part of the cell contains DNA?",
                List.of("Nucleus", "Ribosome", "Cytoplasm", "Mitochondria"),
                "Nucleus"
        );

        quizRepository.save(quiz3);
    }

    private void quiz7() {
        var quiz = new Quiz();
        quiz.setTitle("Movie Quiz");
        quiz.setNumOfQuestions(0);
        quiz.setQuestions(new ArrayList<>());

        addQuestion(
                quiz,
                "Who directed the movie 'Inception'?",
                List.of("Christopher Nolan", "James Cameron", "Steven Spielberg"),
                "Christopher Nolan"
        );
        addQuestion(
                quiz,
                "Which movie features a talking snowman named Olaf?",
                List.of("Frozen", "Moana", "Tangled"),
                "Frozen"
        );
        addQuestion(
                quiz,
                "What color pill does Neo take in 'The Matrix'?",
                List.of("Red", "Blue", "Green"),
                "Red"
        );

        quizRepository.save(quiz);
    }

    private void quiz8() {
        var quiz = new Quiz();
        quiz.setTitle("Sports Quiz");
        quiz.setNumOfQuestions(0);
        quiz.setQuestions(new ArrayList<>());

        addQuestion(
                quiz,
                "How many players are on a soccer team on the field?",
                List.of("11", "10", "9"),
                "11"
        );
        addQuestion(
                quiz,
                "Which country hosts the Wimbledon tennis tournament?",
                List.of("USA", "UK", "Australia"),
                "UK"
        );
        addQuestion(
                quiz,
                "In which sport can you get a 'hole in one'?",
                List.of("Golf", "Cricket", "Baseball"),
                "Golf"
        );
        addQuestion(
                quiz,
                "What sport uses a pommel horse?",
                List.of("Gymnastics", "Equestrian", "Pole vaulting"),
                "Gymnastics"
        );

        quizRepository.save(quiz);
    }

    private void quiz9() {
        var quiz = new Quiz();
        quiz.setTitle("Music Quiz");
        quiz.setNumOfQuestions(0);
        quiz.setQuestions(new ArrayList<>());

        addQuestion(
                quiz,
                "Which instrument has 88 keys?",
                List.of("Piano", "Organ", "Guitar"),
                "Piano"
        );
        addQuestion(
                quiz,
                "Who is known as the 'King of Pop'?",
                List.of("Michael Jackson", "Elvis Presley", "Prince"),
                "Michael Jackson"
        );

        quizRepository.save(quiz);
    }

    private void quiz10() {
        var quiz = new Quiz();
        quiz.setTitle("Technology Quiz");
        quiz.setNumOfQuestions(0);
        quiz.setQuestions(new ArrayList<>());

        addQuestion(quiz, "What does CPU stand for?", List.of("Central Processing Unit", "Computer Personal Unit", "Central Performance Unit"), "Central Processing Unit");
        addQuestion(quiz, "What is the name of the first programmable computer?", List.of("ENIAC", "UNIVAC", "Z3"), "Z3");
        addQuestion(quiz, "Which company created the Java programming language?", List.of("Sun Microsystems", "Microsoft", "Apple"), "Sun Microsystems");
        addQuestion(quiz, "What does HTML stand for?", List.of("HyperText Markup Language", "Hyperlink Text Mark Language", "Hyper Transfer Markup Language"), "HyperText Markup Language");
        addQuestion(quiz, "What year was the first iPhone released?", List.of("2007", "2005", "2008"), "2007");
        addQuestion(quiz, "Which technology is used to make phone calls over the Internet?", List.of("VoIP", "VPN", "HTTP"), "VoIP");
        addQuestion(quiz, "What does RAM stand for?", List.of("Random Access Memory", "Readily Available Memory", "Run Access Memory"), "Random Access Memory");
        addQuestion(quiz, "Which programming language is known for its snake logo?", List.of("Python", "Java", "Ruby"), "Python");
        addQuestion(quiz, "What does USB stand for?", List.of("Universal Serial Bus", "Universal System Board", "Unified Serial Bus"), "Universal Serial Bus");
        addQuestion(quiz, "What is the name of the AI assistant developed by Amazon?", List.of("Alexa", "Siri", "Cortana"), "Alexa");

        quizRepository.save(quiz);
    }

    private void quiz11() {
        var quiz = new Quiz();
        quiz.setTitle("Technology Quiz");
        quiz.setNumOfQuestions(0);
        quiz.setQuestions(new ArrayList<>());

        addQuestion(quiz, "What does CPU stand for?", List.of("Central Processing Unit", "Computer Personal Unit", "Central Performance Unit"), "Central Processing Unit");
        addQuestion(quiz, "What is the name of the first programmable computer?", List.of("ENIAC", "UNIVAC", "Z3"), "Z3");
        addQuestion(quiz, "Which company created the Java programming language?", List.of("Sun Microsystems", "Microsoft", "Apple"), "Sun Microsystems");
        addQuestion(quiz, "What does HTML stand for?", List.of("HyperText Markup Language", "Hyperlink Text Mark Language", "Hyper Transfer Markup Language"), "HyperText Markup Language");
        addQuestion(quiz, "What year was the first iPhone released?", List.of("2007", "2005", "2008"), "2007");
        addQuestion(quiz, "Which technology is used to make phone calls over the Internet?", List.of("VoIP", "VPN", "HTTP"), "VoIP");
        addQuestion(quiz, "What does RAM stand for?", List.of("Random Access Memory", "Readily Available Memory", "Run Access Memory"), "Random Access Memory");
        addQuestion(quiz, "Which programming language is known for its snake logo?", List.of("Python", "Java", "Ruby"), "Python");
        addQuestion(quiz, "What does USB stand for?", List.of("Universal Serial Bus", "Universal System Board", "Unified Serial Bus"), "Universal Serial Bus");
        addQuestion(quiz, "What is the name of the AI assistant developed by Amazon?", List.of("Alexa", "Siri", "Cortana"), "Alexa");

        quizRepository.save(quiz);
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
