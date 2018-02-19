package org.techforumist.jwt.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.techforumist.jwt.domain.AttendanceSport;
import org.techforumist.jwt.repository.AttendanceSportRepository;
import org.techforumist.jwt.service.AttendanceSportService;

@RestController
@RequestMapping("/AttendanceSport")
public class AttendanceSportController {
	
	@Autowired
	private AttendanceSportRepository attRepo;
	
	@Autowired
	private AttendanceSportService attService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> saveAttendance(@RequestBody AttendanceSport att){
	   try{	
	       return ResponseEntity
	    		   .status(HttpStatus.OK)
	    		   .body(this.attService.saveAttendanceSport(att));		   
	   }catch(RuntimeException e){    
		   return ResponseEntity
				   .status(HttpStatus.BAD_REQUEST)
				   .body(e.getMessage());
	   }
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('ESPORTE')")
	@RequestMapping(value = "/getAttAll", method=RequestMethod.GET)
	public List<AttendanceSport> getAttendanciesAll(){
		return new ArrayList<AttendanceSport>(attRepo.findAll());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('ESPORTE')")
	@RequestMapping(value = "/getAttActiveSport", method=RequestMethod.GET)
	public List<AttendanceSport> getAttendanciesActiveSport(){
		return new ArrayList<AttendanceSport>(attRepo.findAttActiveSport());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('ESPORTE')")
	@RequestMapping(value = "/getAttNotSport", method=RequestMethod.GET)
	public List<AttendanceSport> getAttendanciesNotSport(){
		return new ArrayList<AttendanceSport>(attRepo.findAttNotSport());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('ESPORTE')")
	@RequestMapping(value = "/getAttFinallySport", method=RequestMethod.GET)
	public List<AttendanceSport> getAttendanciesFinallySport(){
		return new ArrayList<AttendanceSport>(attRepo.findAttFinallySport());
	}
	
	@RequestMapping(value = "/drop/{id}", method = RequestMethod.DELETE)
	public void  deleteAttendance(@PathVariable Long id) {
		AttendanceSport att = attRepo.findOne(id);
		attRepo.delete(att);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public AttendanceSport updateActivity(@RequestBody AttendanceSport act) {
		if (attRepo.findOneByDetails(act.getDetails()) != null
				&& attRepo.findOneByDetails(act.getDetails()).getId() != act.getId()) {
			throw new RuntimeException("Description already exist");
		}
		return attRepo.save(act);
	}
	
	@RequestMapping(value="/totActiveSport", method=RequestMethod.GET)
	public Integer countTotSport(){
		Integer tot = attRepo.countAttActiveSport();
		return tot;
	}
	
	@RequestMapping(value="/totFinallySport", method=RequestMethod.GET)
	public Integer countTotFinallySport(){
		Integer tot = attRepo.countAttFinallySport();
		return tot;
	}
	
	@RequestMapping(value="/totNotSport", method=RequestMethod.GET)
	public Integer countTotNotSport(){
		Integer tot = attRepo.countAttNotSport();
		return tot;
	}
	
}
