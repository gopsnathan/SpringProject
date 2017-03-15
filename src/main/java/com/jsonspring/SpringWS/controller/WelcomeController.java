package com.jsonspring.SpringWS.controller;
import com.jsonspring.SpringWS.model.*;
import com.jsonspring.SpringWS.Dao.JdbcGopiDao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RestController
public class WelcomeController {
	private ApplicationContext context;

    @RequestMapping("/welcome")
    public Gopi welcome(@RequestParam(value="id", defaultValue="1") int name) {
    	context = new ClassPathXmlApplicationContext("Spring-Module.xml");

            //GopiDao gopiDAO = (GopiDao) context.getBean("gopiDAO");
            //Gopi customer = new Gopi(2, "gg", "nn", "g@g.g", "22-22-22");
            //GopiDao.insert(customer);

            Gopi customer1 = JdbcGopiDao.findByCustomerId(name);
        return customer1;
    }
}
