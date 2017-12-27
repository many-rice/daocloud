package com.daocloud.test2.repository;


import com.daocloud.test2.entity.People;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepsoitory extends CrudRepository<People,Integer>{
    People findById(Integer id);
}
