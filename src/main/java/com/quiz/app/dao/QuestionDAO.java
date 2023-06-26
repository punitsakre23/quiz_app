package com.quiz.app.dao;

import com.quiz.app.model.Javaquestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Javaquestions, Integer> {

    List<Javaquestions> findByCategory(String category);

    @Query(value = "SELECT * FROM javaquestions jq WHERE jq.category=:category ORDER BY RANDOM() LIMIT :numQues", nativeQuery = true)
    List<Javaquestions> findRandomQuestionsByCategory(String category, int numQues);
}
