package com.quiz.app.service;

import com.quiz.app.dao.QuestionDAO;
import com.quiz.app.dao.QuizDAO;
import com.quiz.app.model.Javaquestions;
import com.quiz.app.model.QuestionWrapper;
import com.quiz.app.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        
        Optional<Quiz> quiz = quizDAO.findById(id);
        
        List<Javaquestions> quesFromDB = quiz.get().getQuestions();
        
        List<QuestionWrapper> quesForUser = new ArrayList<>();

        for (Javaquestions q:
             quesFromDB) {
            QuestionWrapper  qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            quesForUser.add(qw);
        }
        
        return new ResponseEntity<>(quesForUser, HttpStatus.OK);
        
    }
}
