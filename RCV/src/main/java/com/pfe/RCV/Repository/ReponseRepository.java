package com.pfe.RCV.Repository;

import com.pfe.RCV.Models.Quiz;
import com.pfe.RCV.Models.Reponse;
import com.pfe.RCV.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReponseRepository  extends MongoRepository<Reponse,String> {


    List<Reponse> findAllByIdUser(User idUser);

}
