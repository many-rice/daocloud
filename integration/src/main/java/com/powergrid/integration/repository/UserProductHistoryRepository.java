package com.powergrid.integration.repository;

import com.powergrid.integration.entity.Integration;
import com.powergrid.integration.entity.UserProductHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProductHistoryRepository extends CrudRepository<UserProductHistory,Integer>{
    Iterable<UserProductHistory> findByUserId(Integer userId);
}
