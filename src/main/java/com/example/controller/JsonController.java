package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.User;

import net.minidev.json.JSONArray;



@Controller
public class JsonController {
	
//	@RequestMapping(value="jsonTest")
//	@ResponseBody
//	public User jsonTest() {
//		User user = new User();
//		user.setName("张三");
//		user.setNum("3");
//		user.setPwd("123");
//		return user;
//	}
	
	@RequestMapping(value="jsonTest")
	@ResponseBody
	public String jsonTest() {
			
		List<User> users = new ArrayList<>();
		User user = new User("yi", "1", "11");
		User user1 = new User("er", "2", "12");
		User user2 = new User("san", "3", "13");

		users.add(user);
		users.add(user1);
		users.add(user2);
		
		String json = JSONArray.toJSONString(users).toString();

		System.out.println(json);
		return json;
	}

		
	
	
	@RequestMapping(value="string2json")
	@ResponseBody
	public User string2json(User user) {
		return user;
	}
	
	
	
	

}
