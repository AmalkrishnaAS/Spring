package com.example.telusko.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.telusko.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> 
{

}
