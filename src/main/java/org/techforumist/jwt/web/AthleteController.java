package org.techforumist.jwt.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.techforumist.jwt.domain.Activity;
import org.techforumist.jwt.domain.Athlete;
import org.techforumist.jwt.domain.Attendance;
import org.techforumist.jwt.domain.Producer;
import org.techforumist.jwt.repository.AthleteRepository;

@RequestMapping("/Athlete")
@RestController
public class AthleteController {
	
	@Autowired
	private AthleteRepository athRepo;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> saveAthlete(@RequestBody Athlete ath){
	   try{	
	       return ResponseEntity
	    		   .status(HttpStatus.OK)
	    		   .body(this.athRepo.save(ath));		   
	   }catch(RuntimeException e){    
		   return ResponseEntity
				   .status(HttpStatus.BAD_REQUEST)
				   .body(e.getMessage());
	   }
	}
	
	@RequestMapping(value = "/findAthletes", method=RequestMethod.GET)
	public Set<Athlete> getAthletes(){
		return new HashSet<Athlete>(athRepo.findAll());
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Athlete updateActivity(@RequestBody Athlete ath) {
		if (athRepo.findOneByName(ath.getName()) != null
				&& athRepo.findOneByName(ath.getName()).getId() != ath.getId()) {
			throw new RuntimeException("Name already exist");
		}
		return athRepo.save(ath);
	}
	
	@RequestMapping(value = "/drop/{id}", method = RequestMethod.DELETE)
	public void  deleteActivity(@PathVariable Long id) {
		Athlete ath = athRepo.findOne(id);
		athRepo.delete(ath);

	}
	
	@RequestMapping(value="/tot", method=RequestMethod.GET)
	public Integer countTot(){
		Integer tot = athRepo.getRegisters();
		return tot;
	}
}
