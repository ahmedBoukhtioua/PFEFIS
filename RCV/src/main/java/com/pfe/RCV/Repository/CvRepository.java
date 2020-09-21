package com.pfe.RCV.Repository;

import com.pfe.RCV.Models.CV;
import com.pfe.RCV.Models.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface CvRepository extends MongoRepository<CV,String> {

    CV findByUser(User user);
    int countByArchived(Boolean archived);

}
