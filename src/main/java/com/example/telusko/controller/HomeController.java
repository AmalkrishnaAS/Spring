package com.example.telusko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.telusko.dao.AlienRepo;
import com.example.telusko.model.Alien;


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
	Alien alien=repo.findById(aid).orElse(new Alien());
	ModelAndView mv=new ModelAndView("show");
	mv.addObject("alien", alien);
	return mv;
}
@RequestMapping("DeleteAlien")
public String DeleteAlien(int aid) {
	repo.deleteById(aid);
	return "Delete";
}
}
