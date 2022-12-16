package com.example.coursework2;

import com.example.coursework2.model.Question;
import com.example.coursework2.service.ExaminerServiceImpl;
import com.example.coursework2.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTests {
    @Mock
    private QuestionService questionService;

    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setUp() {
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    public void getQuestions() {
        Question question = new Question("Вопрос1", "Ответ1");
        Set<Question> questions = new HashSet<>();
        questions.add(question);

        Mockito.when(questionService.getAll())
                .thenReturn(questions);
        Mockito.when(questionService.getRandomQuestion(1))
                .thenReturn(question);

        Assertions.assertEquals(examinerService.getQuestions(1), questions);
    }
}
