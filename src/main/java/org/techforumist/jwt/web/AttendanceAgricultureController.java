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
import org.techforumist.jwt.domain.AttendanceAgriculture;
import org.techforumist.jwt.domain.Producer;
import org.techforumist.jwt.repository.AttendanceAgricultureRepository;
import org.techforumist.jwt.repository.OrderRepository;
import org.techforumist.jwt.service.AttendanceAgricultureService;

@RestController
@RequestMapping("/AttendanceAgriculture")
public class AttendanceAgricultureController {
	
	@Autowired
	private AttendanceAgricultureRepository attRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private AttendanceAgricultureService attService;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> saveAttendance(@RequestBody AttendanceAgriculture att){
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
	public List<AttendanceAgriculture> getAllAttendancies(){
		return new ArrayList<AttendanceAgriculture>(attRepo.findAll());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('AGRICULTURA')")
	@RequestMapping(value = "/getAttActive", method=RequestMethod.GET)
	public List<AttendanceAgriculture> getAttendanciesActive(){
		return new ArrayList<AttendanceAgriculture>(attRepo.findAttActive());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('AGRICULTURA')")
	@RequestMapping(value = "/getAttNot", method=RequestMethod.GET)
	public List<AttendanceAgriculture> getAttendanciesNot(){
		return new ArrayList<AttendanceAgriculture>(attRepo.findAttNot());
	}
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('AGRICULTURA')")
	@RequestMapping(value = "/getAttFinally", method=RequestMethod.GET)
	public List<AttendanceAgriculture> getAttendanciesFinally(){
		return new ArrayList<AttendanceAgriculture>(attRepo.findAttFinally());
	}
	
	@RequestMapping(value = "/drop/{id}", method = RequestMethod.DELETE)
	public void  deleteAttendance(@PathVariable Long id) {
		AttendanceAgriculture att = attRepo.findOne(id);
		attRepo.delete(att);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public AttendanceAgriculture updateActivity(@RequestBody AttendanceAgriculture act) {
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
