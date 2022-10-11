package com.example.telusko.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.telusko.model.Alien;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien, Integer> 
{
	List<Alien> findByTech(String tech);
	List<Alien> findByAidGreaterThan(int aid);
	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findByTechSorted(String tech);
}
