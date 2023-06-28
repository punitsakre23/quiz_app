package com.quiz.app.controller;

import com.quiz.app.model.QuestionWrapper;
import com.quiz.app.model.Response;
import com.quiz.app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQues, @RequestParam String title) {

        return quizService.createQuiz(category, numQues, title);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {

        return quizService.getQuizQuestions(id);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {

        return quizService.calculateResult(id, responses);

    }

}
