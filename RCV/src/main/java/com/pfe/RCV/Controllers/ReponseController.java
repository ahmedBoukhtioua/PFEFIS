package com.pfe.RCV.Controllers;

import com.pfe.RCV.Models.Question;
import com.pfe.RCV.Models.Quiz;
import com.pfe.RCV.Models.Reponse;
import com.pfe.RCV.Security.Services.QuizServices;
import com.pfe.RCV.Security.Services.ReponseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/reponse")

public class ReponseController {
    @Autowired
    private ReponseServices reponseServices;




    @RequestMapping(method = RequestMethod.POST, value = "/submit")
    public Reponse submitReponse(@RequestBody Reponse reponse){return reponseServices.addReponse(reponse); }
    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
    public void deleteReponse(@PathVariable String id)
    {
        reponseServices.deleteReponse(id);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/findReponse/{id}")
    public Reponse getReponse(@PathVariable String id){
        return reponseServices.getReponse(id);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/findReponseOfUser/{id}")
    public List<Reponse> getReponseByUser(@PathVariable String id){
        return reponseServices.getReponseByUser(id);
    }
}
