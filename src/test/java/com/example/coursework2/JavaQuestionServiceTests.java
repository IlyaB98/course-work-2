package com.example.coursework2;

import com.example.coursework2.model.Question;
import com.example.coursework2.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

public class JavaQuestionServiceTests {

    private final JavaQuestionService questionService = new JavaQuestionService();


    @Test
    public void addBySetQuestionParameters() {
        Assertions.assertEquals(questionService.add("question", "answer"),
                new Question("question", "answer"));
    }

    @Test
    public void addBySetQuestion() {
        Assertions.assertEquals(questionService.add(new Question("question", "answer")),
                new Question("question", "answer"));
    }

    @Test
    public void remove() {
        questionService.add("question", "answer");
        Assertions.assertEquals(questionService.remove(new Question("question", "answer")),
                new Question("question", "answer"));
    }

    @Test
    public void getAllQuestion() {
        Collection<Question> questions = new HashSet<>();
        questions.add(new Question("question", "answer"));
        questions.add(new Question("question2", "answer2"));

        questionService.add("question", "answer");
        questionService.add("question2", "answer2");
        Assertions.assertEquals(questionService.getAll(), questions);
    }

    @Test
    public void getRandomQuestion() {
        questionService.add("question", "answer");
        questionService.add("question2", "answer2");

        Assertions.assertEquals(questionService.getRandomQuestion(2),
                new Question("question", "answer"));
    }

}
