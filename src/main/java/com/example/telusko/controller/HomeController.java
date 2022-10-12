package com.example.telusko.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NotFound;
import org.hibernate.query.criteria.internal.expression.function.LengthFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.telusko.dao.AlienRepo;
import com.example.telusko.model.Alien;
import com.example.telusko.model.Message;


@RestController
public class HomeController {
	@Autowired
	AlienRepo repo;
@RequestMapping("/")
public String homeString () {
	return "home";
}
@PostMapping(path = "/alien",consumes= {"application/json"})
public Alien addAlien(@RequestBody Alien alien) {
	System.out.println(alien);
	repo.save(alien);
	return alien;
}
@RequestMapping("/getAlien")
public ModelAndView getAlien(int aid) {
	Alien alien=repo.findById(aid).orElse(null);
	if(alien==null) {
		ModelAndView modelAndView=new ModelAndView("NotFoundjsp");
		return modelAndView;
	}
	ModelAndView mv=new ModelAndView("show");
	mv.addObject("alien", alien);
	return mv;
}
@DeleteMapping("/alien/{aid}")
public Message  DeleteAlien(@PathVariable Integer  aid) {
	Message message=new Message();
	Alien alien=repo.findById(aid).orElse(null);
	if(alien==null) {
		
		message.setMsg("Not Found");
		return message;
		
		
	}
	else {
		repo.delete(alien);
		
		
		message.setMsg("Record Deleted");
		return message;
	}
//	ModelAndView mView=new ModelAndView("Delete");
//	mView.addObject(message);
//	return message;
}

@PutMapping("/alien")
public Message updateAlien(@RequestBody Alien alien) {
	Message message=new Message();
	Alien a=repo.findById(alien.getAid()).orElse(null);
	if(a==null) {
		
		message.setMsg("Not Found");
		return message;
		
		
	}
	else {
		repo.delete(a);
		repo.save(alien);
		
		
		
		message.setMsg("Record Updated");
		return message;
	}
//	ModelAndView mView=new ModelAndView("Delete");
//	mView.addObject(message);
//	return mView;
	
}

@RequestMapping("getTech")
public ModelAndView getTech(String tech) {
	ModelAndView mv=new ModelAndView("ShowList");
	List<Alien> aliens=repo.findByTech(tech);
	System.out.println(aliens);
	System.out.println(repo.findByAidGreaterThan(101));
	System.out.println(repo.findByTechSorted(tech));
	if(aliens.isEmpty()) {
		Message message=new Message();
		message.setMsg("No Recrds found");
		mv.addObject(message);
		return mv;
	}
	mv.addObject("listAlien",aliens.toString());
	
	return mv;
	
}
@RequestMapping(path="/aliens",produces = {"application/json"})
//@ResponseBody
public List<Alien> getAliens() {
	return repo.findAll();
}

@RequestMapping("/alien/{aid}")
//@ResponseBody
public Optional<Alien> getAlienById(@PathVariable("aid") int aid) {
	return repo.findById(aid);
}
}
