package com.pfe.RCV.Repository;

import com.pfe.RCV.Models.Question;
import com.pfe.RCV.Models.Quiz;
import com.pfe.RCV.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizRepository extends MongoRepository<Quiz,String> {

    List<Question> findAllByQuestions();
    List<Quiz> findAllByVisible(boolean visible);
    List<Quiz> findAllByIdRh(User rh);
}
