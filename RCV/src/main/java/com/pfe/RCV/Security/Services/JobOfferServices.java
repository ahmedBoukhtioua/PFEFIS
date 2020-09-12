package com.pfe.RCV.Security.Services;

import com.pfe.RCV.Models.ERole;
import com.pfe.RCV.Models.JobOffer;
import com.pfe.RCV.Models.Role;
import com.pfe.RCV.Models.User;
import com.pfe.RCV.Repository.JobOfferRepository;
import com.pfe.RCV.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobOfferServices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobOfferRepository jobOfferRepository;

    public JobOffer addJobOffer(JobOffer jobOffer){

        Date startDate = new Date();
        Date endDate = new Date();
        LocalDateTime addDate = LocalDateTime.now();
        jobOffer.setStartDate(startDate);
        jobOffer.setEndDate(endDate);
        jobOffer.setAddDate(addDate);
        jobOffer.setValide(true);
        jobOfferRepository.save(jobOffer);
        return jobOffer;
    }

    public List<JobOffer> getAllJobOfferArchived(){
        return jobOfferRepository.findAllByValide(false);
    }
    public List<JobOffer> getAllJobOfferValide(){
        return jobOfferRepository.findAllByValide(true);
    }
    public List<JobOffer> getAllJobOffer(){
        return jobOfferRepository.findAll();
    }


    public void modifierJobOffer(String id,JobOffer jobOffer){
        System.out.println("=====================================");
        System.out.println(id);
        JobOffer jobOffer1=jobOfferRepository.findById(id).orElse(null);
        jobOffer1.setEndDate(jobOffer.getEndDate());
        jobOffer1.setStartDate(jobOffer.getStartDate());
        jobOffer1.setProjectDescription(jobOffer.getProjectDescription());
        jobOffer1.setProjectName(jobOffer.getProjectName());
        jobOffer1.setManager(jobOffer.getManager());
        jobOfferRepository.save(jobOffer1);
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
        jobOffer.setValide(false);
        jobOfferRepository.save(jobOffer);
    }
         public List<JobOffer> getAllByUser(User u) {
        return jobOfferRepository.findAllJobOffersByManager(u);
    }
    public void deleteJobOffer(String id){jobOfferRepository.deleteById(id);}
    public User getManager(){
        return userRepository.findByRoles(ERole.ROLE_MANAGER);
    }
    public int getNombreOffre()
    {

       int w=  jobOfferRepository.countByValide(true);
        System.out.println(w);
       return w;
    }

}
