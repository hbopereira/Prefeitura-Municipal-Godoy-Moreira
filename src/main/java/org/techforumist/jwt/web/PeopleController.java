package org.techforumist.jwt.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.techforumist.jwt.domain.People;
import org.techforumist.jwt.repository.PeopleRepository;
import org.techforumist.jwt.service.PeopleService;

@RestController
@RequestMapping("/People")
public class PeopleController {
	
	@Autowired
	private PeopleRepository peopleRepo;
	
	@Autowired
	private PeopleService peopleService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> savePeople(@RequestBody People peo){
	   try{	
	       return ResponseEntity
	    		   .status(HttpStatus.OK)
	    		   .body(this.peopleService.savePeople(peo));		   
	   }catch(RuntimeException e){    
		   return ResponseEntity
				   .status(HttpStatus.BAD_REQUEST)
				   .body(e.getMessage());
	   }
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<People> getPeoples(){
	    return new ArrayList<People>(peopleRepo.findAll());   
	}
	
	@RequestMapping(value="/getPeopleFromAgriculture", method=RequestMethod.GET)
	public List<People> getPeoplesAgriculture(){
		return new ArrayList<People>(peopleRepo.getPeoplesFromAgriculture());
	}
	
	@RequestMapping(value="/getPeopleFromSport", method=RequestMethod.GET)
	public List<People> getPeoplesSport(){
		return new ArrayList<People>(peopleRepo.getPeoplesFromSport());
	}
	

}
