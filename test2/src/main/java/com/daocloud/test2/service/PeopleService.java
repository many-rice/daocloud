package com.daocloud.test2.service;

import com.daocloud.test2.entity.People;
import com.daocloud.test2.repository.PeopleRepsoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "users")
public class PeopleService {
    @Autowired
    private PeopleRepsoitory peopleRepsoitory;

    @Cacheable
    public People find(Integer id){
        People people= peopleRepsoitory.findById(id);
        System.out.println(people);
        return people;
    }
}
