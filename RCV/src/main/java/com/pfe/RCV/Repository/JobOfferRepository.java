package com.pfe.RCV.Repository;

import com.pfe.RCV.Models.JobOffer;
import com.pfe.RCV.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface JobOfferRepository extends MongoRepository<JobOffer,String> {

    List<JobOffer> findAllByArchiveAndValide(boolean archive,boolean valide);
   List<JobOffer> findAllJobOffersByManager(User user);

}
