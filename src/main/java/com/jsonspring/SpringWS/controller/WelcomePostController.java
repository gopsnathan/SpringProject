package com.jsonspring.SpringWS.controller;
import com.jsonspring.SpringWS.model.*;
import com.jsonspring.SpringWS.Dao.JdbcGopiDao;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RestController
public class WelcomePostController {
	private ApplicationContext context;
	@CrossOrigin
    @RequestMapping(value = "/welcomepost", method = RequestMethod.POST, consumes ="application/json", produces = "application/json")
    @ResponseBody
    public Gopi welcome(@RequestBody GopiPostRequest gopiRequest) {
    	context = new ClassPathXmlApplicationContext("Spring-Module.xml");

            //GopiDao gopiDAO = (GopiDao) context.getBean("gopiDAO");
            //Gopi customer = new Gopi(2, "gg", "nn", "g@g.g", "22-22-22");
            //GopiDao.insert(customer);

            Gopi customer1 = JdbcGopiDao.findByCustomerId(gopiRequest.getId());
        return customer1;
    }
}
