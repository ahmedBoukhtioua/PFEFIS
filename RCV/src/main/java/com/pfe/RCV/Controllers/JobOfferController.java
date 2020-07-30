package com.pfe.RCV.Controllers;

import com.pfe.RCV.Models.JobOffer;
import com.pfe.RCV.Models.User;
import com.pfe.RCV.Security.Services.JobOfferServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/jobOffer")
public class JobOfferController {
    @Autowired
    private JobOfferServices  jobOfferService;

    @RequestMapping(method = RequestMethod.GET,value = "/findAll")
    public List<JobOffer> getAllJobOffer(){
        return jobOfferService.getAllJobOffer();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/findAllConnected")
    public List<JobOffer> getAllUser(User user){
        return jobOfferService.getAllByUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public JobOffer addJobOffer(@RequestBody JobOffer jobOffer){
         return jobOfferService.addJobOffer(jobOffer);
    }

            @RequestMapping(method = RequestMethod.PUT, value = "/update/{jobOffer")
    public void updateJobOffer(@PathVariable JobOffer jobOffer ){
        jobOfferService.modifierJobOffer(jobOffer);
    }


    @RequestMapping(method = RequestMethod.PUT,value = "/validate/{id}")
    public void validerJobOffer(@PathVariable String id){
        jobOfferService.validerJobOffer(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/archived/{id}")
    public void archiverJobOffer(@PathVariable String id){
        jobOfferService.archiverJobOffer(id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/supprimerJobOffer/{id}")
    public void deleteJobOffer(@PathVariable String id)
    {
        jobOfferService.deleteJobOffer(id);
    }

}
