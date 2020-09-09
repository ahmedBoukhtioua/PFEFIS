package com.pfe.RCV.Controllers;

import com.pfe.RCV.Models.JobOffer;
import com.pfe.RCV.Models.Question;
import com.pfe.RCV.Models.Quiz;
import com.pfe.RCV.Security.Services.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizServices quizServices;

    @RequestMapping(method = RequestMethod.GET,value = "/findAll")
    public List<Quiz> getAll(){
        return quizServices.getAll();
    }
    @RequestMapping(method = RequestMethod.GET,value = "/findAllVisible")
    public List<Quiz> getAllVisible(){
        return quizServices.getAllQuizVisible();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/findAllNotvisible")
    public List<Quiz> getAllNotVisible(){

        return quizServices.getAllQuizNotVisible();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/findQuestions")
    public List<Question> getAllQuestion(){
        return quizServices.getAllQuestion();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/findById/{id}")
    public Quiz getById(@PathVariable String id){
        return quizServices.getQuiz(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addQuiz")
    public Quiz addQuiz(@RequestBody Quiz quiz){

        return quizServices.addQuiz(quiz);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateQuiz/{id}")
    public void updateQuiz(@PathVariable String id,@RequestBody Quiz quiz ){

        quizServices.updateQuiz(id,quiz);
    }


    @RequestMapping(method = RequestMethod.PUT,value = "/visible/{id}")
    public void visibleQuiz(@PathVariable String id){
        quizServices.visibleQuiz(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/notVisible/{id}")
    public void notvisibleQuiz(@PathVariable String id){
        quizServices.notVisibleQuiz(id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteQuiz/{id}")
    public void deleteQuiz(@PathVariable String id)
    {
        quizServices.deleteQuiz(id);
    }
}
