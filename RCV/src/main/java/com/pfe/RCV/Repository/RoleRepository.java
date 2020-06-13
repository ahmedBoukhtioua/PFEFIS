package com.pfe.RCV.Repository;

import com.pfe.RCV.Models.ERole;
import com.pfe.RCV.Models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}