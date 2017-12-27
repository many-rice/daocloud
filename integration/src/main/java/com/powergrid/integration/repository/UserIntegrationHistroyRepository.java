package com.powergrid.integration.repository;

import com.powergrid.integration.entity.UserIntegrationHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIntegrationHistroyRepository extends CrudRepository<UserIntegrationHistory,Integer>{
    Iterable<UserIntegrationHistory> findByUserId(Integer userId);
}
