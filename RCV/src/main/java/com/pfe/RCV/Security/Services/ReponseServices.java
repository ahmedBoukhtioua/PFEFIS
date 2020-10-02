package com.pfe.RCV.Security.Services;

import com.pfe.RCV.Controllers.AuthController;
import com.pfe.RCV.Models.Option;
import com.pfe.RCV.Models.Question;
import com.pfe.RCV.Models.Reponse;
import com.pfe.RCV.Models.User;
import com.pfe.RCV.Repository.ReponseRepository;
import com.pfe.RCV.Repository.ReponseRepository;
import com.pfe.RCV.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ReponseServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReponseRepository reponseRepository;
    @Autowired
    private AuthController authController;

    public Reponse addReponse(Reponse reponse){


        User user = authController.user(reponse.getIdUser().getId());
        LocalDateTime date = LocalDateTime.now();
        reponse.setDate(date);
        reponse.setIdUser(user);
        int score = 0;
        int i = 0;
        for (String rep: reponse.getReponses()
             ) {
            for (Option opt:reponse.getIdQuiz().getQuestions().get(i).getOptionList()
                 ) {
                if(opt.getCorrect()!= null && opt.getCorrect())
                {
                    if(opt.getOptionName().equals(rep))
                    {
                        score++;
                    }
                    break;
                }
            }
            i++;
        }
        reponse.setScore(score);
        reponseRepository.save(reponse);
        return reponse;
    }



    public Reponse getReponse(String id)
    {
        return reponseRepository.findById(id).orElse(null);
    }

    public void deleteReponse(String id)
    {
        reponseRepository.deleteById(id);
    }

    public List<Reponse> getReponseByUser(String idUser){
        User user = userRepository.findById(idUser).get();
        return  reponseRepository.findAllByIdUser(user);
    }
    public List<Reponse> getAllReponse(){

        return  reponseRepository.findAll();
    }


}
