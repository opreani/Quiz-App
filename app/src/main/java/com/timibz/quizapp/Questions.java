package com.timibz.quizapp;

/**
 * Created by DanO on 21.12.2017.
 */

public class Questions {
    private String Questions[] = {
            "Which is the fastest bird in the world?",
            "Where can we find the heart of a shrimp?",
            "Where did the chess game appear for the first time?",
            "Who drew the first helicopter concept?",
            "What is the tomato?",
            "Which is the fastest animal in the world?",
            "Where is Romania located?",
            "When do dolphins sleep?",
            "What does the name \"Sahara\" mean in Arabic?",
            "What is the most used vegetable in the world?"
    };

    private String Choices[][] = {
            {"The Falcon","The Eagle","The Pigeon"},
            {"In the tail","In the chest","In the head"},
            {"North America","Persia","Europe"},
            {"Leonardo da Vinci", "Mihail Lomonosov", "Heinrich Focke"},
            {"A Fruit", "A Vegetable", "Meat"},
            {"The Panther","The Leopard","The Rabbit"},
            {"South America","Asia","Europe" },
            {"At night", "Never", "At day" },
            {"Desert", "Food", "Sand"},
            {"The Potato", "The Onion", "The Tomato"}
    };

    private String CorrectAnswers[] = {"The Falcon","In the head","Persia","Leonardo da Vinci", "A Fruit","The Leopard",
            "Europe","Never","Desert","The Onion"};

    public String getQuestion(int n){
        String question = Questions[n];
        return question;
    }

    public String getChoice1(int n){
        String choice0 = Choices[n][0];
        return choice0;
    }

    public String getChoice2(int n){
        String choice1 = Choices[n][1];
        return choice1;
    }

    public String getChoice3(int n){
        String choice2 = Choices[n][2];
        return choice2;
    }

    public String getCorrectanswer(int n){
        String answer = CorrectAnswers[n];
        return answer;
    }
}


