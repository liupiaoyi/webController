package com.example.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Person;

@Controller
public class ThymeleafController {
	
	@RequestMapping("/controllerValue")
	public String controllerValue(HttpServletRequest request) {
		request.setAttribute("keurqe", "keurqe");
		request.getSession().setAttribute("key", "value");		
		return "test";
	}
	
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	List<Person> list = new ArrayList<Person>();
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,Model model) {
		//获取 person 表中所有数据
		list = entityManager.createQuery("select p from Person p",Person.class).getResultList();
		model.addAttribute("list", list);
		//list.forEach(System.out::println);
		return "test";
	}
	
	
	//转到添加的 HTML
	@RequestMapping(value="/toAdd")
	public String toAdd() {
		return "addHtml";
	}
	
	//添加
	@Transactional
	@RequestMapping(value="/addMethod",method=RequestMethod.POST)
	public String add(@ModelAttribute("person") Person person,Model model) {
		//System.out.println(person);
		//向数据库添加
		entityManager.persist(person);
		
		list.add(person);
		model.addAttribute("list", list);
		return "test";
	}
	
	
	//跳到更新页面
	@RequestMapping("toupdate")
	public String toupdate(Model model,@RequestParam("name") String name,@RequestParam("age") String age,@RequestParam("pid") String pid) {
		Person person = new Person(Integer.parseInt(pid),Integer.parseInt(age),name);
		
		//数据传到更新页面
		model.addAttribute("person", person);
		return "updateHtml";
	}
	
	//更新
	@Transactional
	@RequestMapping(value="update",method=RequestMethod.POST)	
	public String update(@ModelAttribute("person")Person person,Model model) {
		
		//System.out.println("person=="+person);
		//操作数据库，更新数据		
		entityManager.createQuery("UPDATE Person p SET p.age=?1,p.name=?2 WHERE p.pid=?3")
		.setParameter(1, person.getAge())
		.setParameter(2, person.getName())
		.setParameter(3, person.getPid()).executeUpdate();
		
		list = entityManager.createQuery("select p from Person p",Person.class).getResultList();
		model.addAttribute("list", list);
		return "test";
	}
	
	

}
