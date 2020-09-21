package com.pfe.RCV.Repository;

import com.pfe.RCV.Models.CV;
import com.pfe.RCV.Models.ERole;
import com.pfe.RCV.Models.Role;
import com.pfe.RCV.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public interface UserRepository extends MongoRepository <User,String> {
    Optional<User> findByeNumber(String eNumber);
    Optional<User> findByEmail(String email);


    Boolean existsByeNumber(String eNumber);



    Boolean existsByEmail(String email);

    Optional<User>  findByCv(CV cv);

    User  findByRoles(ERole role);

    boolean existsByRoles(Role role);

    int countByRoles(ERole role);
}
