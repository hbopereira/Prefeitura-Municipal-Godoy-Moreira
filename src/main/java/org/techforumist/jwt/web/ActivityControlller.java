package org.techforumist.jwt.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.techforumist.jwt.domain.Activity;
import org.techforumist.jwt.repository.ActivityRepository;

@RestController
@RequestMapping("/Activity")
public class ActivityControlller {
	
	@Autowired
	private ActivityRepository actRepo;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> saveProducer(@RequestBody Activity act){
	   try{	
	       return ResponseEntity
	    		   .status(HttpStatus.OK)
	    		   .body(this.actRepo.save(act));		   
	   }catch(RuntimeException e){    
		   return ResponseEntity
				   .status(HttpStatus.BAD_REQUEST)
				   .body(e.getMessage());
	   }
	}
	
	@RequestMapping(value="/findActivities", method=RequestMethod.GET)
	public List<Activity> getActivities(){
		return new ArrayList<Activity>(actRepo.findAll());
		
	}
	
	@RequestMapping(value = "/drop/{id}", method = RequestMethod.DELETE)
	public void  deleteActivity(@PathVariable Long id) {
		Activity act = actRepo.findOne(id);
		actRepo.delete(act);

	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Activity updateActivity(@RequestBody Activity act) {
		if (actRepo.findOneByDescription(act.getDescription()) != null
				&& actRepo.findOneByDescription(act.getDescription()).getId() != act.getId()) {
			throw new RuntimeException("Description already exist");
		}
		return actRepo.save(act);
	}
}
