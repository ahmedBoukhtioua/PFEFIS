package com.pfe.RCV.Security.Services;

import com.nimbusds.oauth2.sdk.Role;
import com.pfe.RCV.Controllers.AuthController;
import com.pfe.RCV.Models.ERole;
import com.pfe.RCV.Models.JobOffer;
import com.pfe.RCV.Models.User;
import com.pfe.RCV.Repository.JobOfferRepository;
import com.pfe.RCV.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class JobOfferServices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobOfferRepository jobOfferRepository;

    public JobOffer addJobOffer(JobOffer jobOffer){

        Date startDate = new Date();
        Date endDate = new Date();
        jobOffer.setStartDate(startDate);
        jobOffer.setEndDate(endDate);
        jobOfferRepository.save(jobOffer);
        return jobOffer;
    }

    public List<JobOffer> getAllJobOffer(){
        return jobOfferRepository.findAllByArchiveAndValide(false,false);
    }
    public void modifierJobOffer(JobOffer jobOffer){


        jobOffer.setEndDate(jobOffer.getEndDate());
        jobOffer.setStartDate(jobOffer.getStartDate());
        jobOffer.setProjectDescription(jobOffer.getProjectDescription());
        jobOffer.setProjectName(jobOffer.getProjectName());
        jobOfferRepository.save(jobOffer);
    }

    public JobOffer getJobOffer(String id){
        return jobOfferRepository.findById(id).orElse(null);
    }

    public void validerJobOffer(String id){
        JobOffer jobOffer= jobOfferRepository.findById(id).orElse(null);
        jobOffer.setValide(true);
        jobOfferRepository.save(jobOffer);
    }
    public void archiverJobOffer(String id) {
        JobOffer jobOffer = jobOfferRepository.findById(id).orElse(null);
        jobOffer.setArchive(true);
        jobOfferRepository.save(jobOffer);
    }
         public List<JobOffer> getAllByUser(User u) {
        return jobOfferRepository.findAllJobOffersByManager(u);
    }
    public void deleteJobOffer(String id){jobOfferRepository.deleteById(id);}

}
