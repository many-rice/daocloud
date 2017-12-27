package com.daocloud.test2;

import com.daocloud.test2.repository.PeopleRepsoitory;
import com.daocloud.test2.service.PeopleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2ApplicationTests {

	@Autowired
	private PeopleService peopleService;

	@Test
	public void contextLoads() {
		peopleService.find(new Integer(1));
		peopleService.find(new Integer(1));
	}

}
