package com.quiz.app.controller;

import com.quiz.app.model.Javaquestions;
import com.quiz.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Javaquestions>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Javaquestions>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsBasedOnCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Javaquestions javaquestions) {
        return questionService.addQuestion(javaquestions);
    }

}
