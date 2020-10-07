package com.pfe.RCV.Security.Services;

import com.pfe.RCV.Models.CV;
import com.pfe.RCV.Models.ERole;
import com.pfe.RCV.Models.JobOffer;
import com.pfe.RCV.Models.User;
import com.pfe.RCV.Repository.CvRepository;
import com.pfe.RCV.Repository.JobOfferRepository;
import com.pfe.RCV.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobOfferServices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CvRepository cvRepository;
    @Autowired
    private JobOfferRepository jobOfferRepository;

    public JobOffer addJobOffer(JobOffer jobOffer){


        LocalDateTime addDate = LocalDateTime.now();
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
         public List<JobOffer> getAllByUser(String idUser) {
             User user = userRepository.findById(idUser).get();
             return jobOfferRepository.findAllJobOffersByManager(user);
    }
    public void deleteJobOffer(String id){jobOfferRepository.deleteById(id);}
    public User getManager(){
        return userRepository.findByRoles(ERole.ROLE_MANAGER);
    }


    public ArrayList<Integer> getNombreOffre()
    {
       int v=  jobOfferRepository.countByValide(true);
        int a=  jobOfferRepository.countByValide(false);
        ArrayList<Integer> nb = new ArrayList<Integer>();
        nb.add(v);
        nb.add(a);

        return nb;
    }
    public long getNombreAll()
    {  long w=  jobOfferRepository.count();

        return w;

    }

    public List<CV> getMatchedCvs(String id )
    {
        JobOffer offer = jobOfferRepository.findById(id).orElse(null);
        List<CV> result = new ArrayList<>();
        for (CV cv : cvRepository.findAll()
             ) {
            boolean match = false;
            for (String division : cv.getDivisionList()
            ) {
                for (String langue : cv.getLanguesList()
                ) {
                if (offer.getProjectDescription().contains(division) && offer.getProjectDescription().contains(langue) && cv.getNote()>=5
                ) {
                    match = true;
                    break;
                }
            }
        }
            if(match)
            {
                result.add(cv);
            }
        }
        return result;
    }
}
