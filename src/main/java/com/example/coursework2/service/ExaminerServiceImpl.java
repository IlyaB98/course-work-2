package com.example.coursework2.service;

import com.example.coursework2.exceptions.BadRequestException;
import com.example.coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new BadRequestException();
        } else {
            Set<Question> questions = new HashSet<>();
            while (amount > 0) {
                questions.add(questionService.getRandomQuestion(amount));
                amount--;
            }
            return questions;
        }
    }
}
