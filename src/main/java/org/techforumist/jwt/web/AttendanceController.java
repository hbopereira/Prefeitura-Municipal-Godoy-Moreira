package org.techforumist.jwt.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.techforumist.jwt.domain.Activity;
import org.techforumist.jwt.domain.Attendance;
import org.techforumist.jwt.domain.Producer;
import org.techforumist.jwt.repository.AttendanceRepository;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceRepository attRepo;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> saveAttendance(@RequestBody Attendance att){
	   try{	
	       return ResponseEntity
	    		   .status(HttpStatus.OK)
	    		   .body(this.attRepo.save(att));		   
	   }catch(RuntimeException e){    
		   return ResponseEntity
				   .status(HttpStatus.BAD_REQUEST)
				   .body(e.getMessage());
	   }
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('AGRICULTURA')")
	@RequestMapping(value = "/getAttActive", method=RequestMethod.GET)
	public List<Attendance> getAttendanciesActive(){
		return new ArrayList<Attendance>(attRepo.findAttActive());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('ESPORTE')")
	@RequestMapping(value = "/getAttActiveSport", method=RequestMethod.GET)
	public List<Attendance> getAttendanciesActiveSport(){
		return new ArrayList<Attendance>(attRepo.findAttActiveSport());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('AGRICULTURA')")
	@RequestMapping(value = "/getAttNot", method=RequestMethod.GET)
	public List<Attendance> getAttendanciesNot(){
		return new ArrayList<Attendance>(attRepo.findAttNot());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('ESPORTE')")
	@RequestMapping(value = "/getAttNotSport", method=RequestMethod.GET)
	public List<Attendance> getAttendanciesNotSport(){
		return new ArrayList<Attendance>(attRepo.findAttNotSport());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('AGRICULTURA')")
	@RequestMapping(value = "/getAttFinally", method=RequestMethod.GET)
	public List<Attendance> getAttendanciesFinally(){
		return new ArrayList<Attendance>(attRepo.findAttFinally());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('ESPORTE')")
	@RequestMapping(value = "/getAttFinallySport", method=RequestMethod.GET)
	public List<Attendance> getAttendanciesFinallySport(){
		return new ArrayList<Attendance>(attRepo.findAttFinallySport());
	}
	
	@RequestMapping(value = "/drop/{id}", method = RequestMethod.DELETE)
	public void  deleteAttendance(@PathVariable Long id) {
		Attendance att = attRepo.findOne(id);
		attRepo.delete(att);

	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Attendance updateActivity(@RequestBody Attendance act) {
		if (attRepo.findOneByDetails(act.getDetails()) != null
				&& attRepo.findOneByDetails(act.getDetails()).getId() != act.getId()) {
			throw new RuntimeException("Description already exist");
		}
		return attRepo.save(act);
	}
	
	@RequestMapping(value="/totActive", method=RequestMethod.GET)
	public Integer countTot(){
		Integer tot = attRepo.countAttActive();
		return tot;
	}
	
	@RequestMapping(value="/totActiveSport", method=RequestMethod.GET)
	public Integer countTotSport(){
		Integer tot = attRepo.countAttActiveSport();
		return tot;
	}
	
	@RequestMapping(value="/totFinally", method=RequestMethod.GET)
	public Integer countTotFinally(){
		Integer tot = attRepo.countAttFinally();
		return tot;
	}
	
	@RequestMapping(value="/totFinallySport", method=RequestMethod.GET)
	public Integer countTotFinallySport(){
		Integer tot = attRepo.countAttFinallySport();
		return tot;
	}
	
	@RequestMapping(value="/totNot", method=RequestMethod.GET)
	public Integer countTotNot(){
		Integer tot = attRepo.countAttNot();
		return tot;
	}
	
	@RequestMapping(value="/totNotSport", method=RequestMethod.GET)
	public Integer countTotNotSport(){
		Integer tot = attRepo.countAttNotSport();
		return tot;
	}

}
