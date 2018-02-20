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
import org.techforumist.jwt.domain.AttendanceAgricultureMachine;
import org.techforumist.jwt.domain.AttendanceAgricultureTechnicalAssistance;
import org.techforumist.jwt.repository.AttendanceAgricultureTechnicalAssistanceRepository;
import org.techforumist.jwt.service.AttendanceAgricultureTechnicalAssistanceService;

@RestController
@RequestMapping("/AttendanceAgricultureTechnical")
public class AttendanceAgricultureTechnicalAssistanceController {
	
	@Autowired
	private AttendanceAgricultureTechnicalAssistanceRepository attRepo;
	
	@Autowired
	private AttendanceAgricultureTechnicalAssistanceService attService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> saveAttendance(@RequestBody AttendanceAgricultureTechnicalAssistance att){
	   try{	
	       return ResponseEntity
	    		   .status(HttpStatus.OK)
	    		   .body(this.attService.saveAttendance(att));		   
	   }catch(RuntimeException e){    
		   return ResponseEntity
				   .status(HttpStatus.BAD_REQUEST)
				   .body(e.getMessage());
	   }
	}
	

	@PreAuthorize("hasRole('ADMIN') AND hasRole('AGRICULTURA')")
	@RequestMapping(value = "/getAttAll", method=RequestMethod.GET)
	public List<AttendanceAgricultureTechnicalAssistance> getAllAttendancies(){
		return new ArrayList<AttendanceAgricultureTechnicalAssistance>(attRepo.findAll());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('AGRICULTURA')")
	@RequestMapping(value = "/getAttActive", method=RequestMethod.GET)
	public List<AttendanceAgricultureTechnicalAssistance> getAttendanciesActive(){
		return new ArrayList<AttendanceAgricultureTechnicalAssistance>(attRepo.findAttActive());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('AGRICULTURA')")
	@RequestMapping(value = "/getAttNot", method=RequestMethod.GET)
	public List<AttendanceAgricultureTechnicalAssistance> getAttendanciesNot(){
		return new ArrayList<AttendanceAgricultureTechnicalAssistance>(attRepo.findAttNot());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('AGRICULTURA')")
	@RequestMapping(value = "/getAttFinally", method=RequestMethod.GET)
	public List<AttendanceAgricultureTechnicalAssistance> getAttendanciesFinally(){
		return new ArrayList<AttendanceAgricultureTechnicalAssistance>(attRepo.findAttFinally());
	}
	
	@RequestMapping(value = "/drop/{id}", method = RequestMethod.DELETE)
	public void  deleteAttendance(@PathVariable Long id) {
		AttendanceAgricultureTechnicalAssistance att = attRepo.findOne(id);
		attRepo.delete(att);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public AttendanceAgricultureTechnicalAssistance updateAttendance(@RequestBody AttendanceAgricultureTechnicalAssistance act) {
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
	
	@RequestMapping(value="/totFinally", method=RequestMethod.GET)
	public Integer countTotFinally(){
		Integer tot = attRepo.countAttFinally();
		return tot;
	}
	
	@RequestMapping(value="/totNot", method=RequestMethod.GET)
	public Integer countTotNot(){
		Integer tot = attRepo.countAttNot();
		return tot;
	}
	
	
	
	
	
}
