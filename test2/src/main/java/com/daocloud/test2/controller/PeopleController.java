package com.daocloud.test2.controller;

import com.daocloud.test2.entity.People;
import com.daocloud.test2.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @GetMapping("/hello/{id}")
    public People find(@PathVariable("id") Integer id)
    {
        People people=peopleService.find(id);
        People people2=peopleService.find(id);
        People people3=peopleService.find(id);
        return people2;
    }
    @GetMapping("/hellos/{id}")
    public People finds(@PathVariable("id") Integer id)
    {
        People people=peopleService.find(id);
        return people;
    }
}
