package com.powergrid.integration.repository;

import com.powergrid.integration.entity.UserIntegration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserIntegrationRepository extends CrudRepository<UserIntegration,Integer>{
    Optional<UserIntegration> findByUserId(Integer userId);
}
