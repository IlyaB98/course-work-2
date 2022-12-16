package com.example.coursework2.controller;

import com.example.coursework2.model.Question;
import com.example.coursework2.service.QuestionService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@PathParam("question") String question, @PathParam("answer") String answer) {
        return this.questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@PathParam("question") String question, @PathParam("answer") String answer) {
        Question question1 = new Question(question, answer);
        return this.questionService.remove(question1);
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return this.questionService.getAll();
    }
}
