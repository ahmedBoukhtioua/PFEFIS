package com.pfe.RCV.Security.Services;

import com.pfe.RCV.Controllers.AuthController;
import com.pfe.RCV.Models.JobOffer;
import com.pfe.RCV.Models.Question;
import com.pfe.RCV.Models.Quiz;
import com.pfe.RCV.Models.User;
import com.pfe.RCV.Repository.JobOfferRepository;
import com.pfe.RCV.Repository.QuizRepository;
import com.pfe.RCV.Repository.UserRepository;
import com.pfe.RCV.payload.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired

    private AuthController authController;



    public Quiz addQuiz(Quiz quiz){


        LocalDateTime date = LocalDateTime.now();
        quiz.setDate(date);
        quiz.setVisible(true);
        quizRepository.save(quiz);
        return quiz;
    }

    public List<Quiz> getAllQuizVisible()
    {
        return quizRepository.findAllByVisible(true);

    }
    public List<Quiz> getAll()
    {
        return quizRepository.findAll();

    }

    public List<Quiz> getAllQuizNotVisible(){
        return quizRepository.findAllByVisible(false);
    }
    public Quiz getQuiz(String id)
    {
        return quizRepository.findById(id).orElse(null);
    }

    public List<Question> getAllQuestion()
    {
        return  quizRepository.findAllByQuestions();
    }
    public Quiz updateQuiz(String id,Quiz quiz)
    {
       Quiz quiz1 =  quizRepository.findById(id).orElse(null);
        System.out.println(quiz1);
       quiz1.setQuizName(quiz.getQuizName());
       quiz1.setQuestions(quiz.getQuestions());
      return  quizRepository.save(quiz1);
    }
    public void visibleQuiz(String id)
    {
        Quiz quiz= quizRepository.findById(id).orElse(null);
        quiz.setVisible(true);
        quizRepository.save(quiz);
    }
    public void notVisibleQuiz(String id)
    {
        Quiz quiz= quizRepository.findById(id).orElse(null);
        quiz.setVisible(false);
        quizRepository.save(quiz);
    }
    public void deleteQuiz(String id)
    {
        quizRepository.deleteById(id);
    }





}
