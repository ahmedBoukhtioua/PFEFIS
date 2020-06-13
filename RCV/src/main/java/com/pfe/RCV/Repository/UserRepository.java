package com.pfe.RCV.Repository;

import com.pfe.RCV.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository <User,String> {
    Optional<User> findByeNumber(String eNumber);

    Boolean existsByeNumber(String eNumber);

    Boolean existsByEmail(String email);
}
