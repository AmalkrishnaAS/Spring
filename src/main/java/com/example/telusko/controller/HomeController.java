package com.example.telusko.controller;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.telusko.dao.AlienRepo;
import com.example.telusko.model.Alien;
import com.example.telusko.model.Message;


@Controller
public class HomeController {
	@Autowired
	AlienRepo repo;
@RequestMapping("/")
public String homeString () {
	return "home";
}
@RequestMapping("/addAlien")
public String addAlien(Alien alien) {
	repo.save(alien);
	return "home";
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
@RequestMapping("DeleteAlien")
public ModelAndView  DeleteAlien(int aid) {
	Message message=new Message();
	Alien alien=repo.findById(aid).orElse(null);
	if(alien==null) {
		
		message.setMsg("Not Found");
		
		
	}
	else {
		repo.delete(alien);
		
		
		message.setMsg("Record Deleted");
	}
	ModelAndView mView=new ModelAndView("Delete");
	mView.addObject(message);
	return mView;
}

@RequestMapping("UpdateAlien")
public ModelAndView UpdateAlien(Alien alien) {
	Message message=new Message();
	Alien a=repo.findById(alien.getAid()).orElse(null);
	if(a==null) {
		
		message.setMsg("Not Found");
		
		
	}
	else {
		repo.delete(a);
		repo.save(alien);
		
		
		
		message.setMsg("Record Updated");
	}
	ModelAndView mView=new ModelAndView("Delete");
	mView.addObject(message);
	return mView;
	
}
}
