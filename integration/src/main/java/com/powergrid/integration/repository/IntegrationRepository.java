package com.powergrid.integration.repository;

import com.powergrid.integration.entity.Integration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntegrationRepository extends CrudRepository<Integration,Integer>{
    Integration findByAction(String action);
}
