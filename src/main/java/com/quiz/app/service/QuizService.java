package com.quiz.app.service;

import com.quiz.app.dao.QuestionDAO;
import com.quiz.app.dao.QuizDAO;
import com.quiz.app.model.Javaquestions;
import com.quiz.app.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String category, int numQues, String title) {

        List<Javaquestions> javaquestions = questionDAO.findRandomQuestionsByCategory(category, numQues);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(javaquestions);
        quizDAO.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.OK);

    }
}
