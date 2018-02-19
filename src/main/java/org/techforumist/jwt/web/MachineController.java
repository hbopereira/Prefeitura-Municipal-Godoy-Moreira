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
import org.techforumist.jwt.domain.AttendanceSport;
import org.techforumist.jwt.domain.Machine;
import org.techforumist.jwt.repository.MachineRepository;

@RestController
@RequestMapping("/Machine")
public class MachineController {
	
	@Autowired
	private MachineRepository machRepo;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> saveAttendance(@RequestBody Machine machi){
	   try{	
	       return ResponseEntity
	    		   .status(HttpStatus.OK)
	    		   .body(this.machRepo.save(machi));		   
	   }catch(RuntimeException e){    
		   return ResponseEntity
				   .status(HttpStatus.BAD_REQUEST)
				   .body(e.getMessage());
	   }
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Machine> findAllMachines(){
		return new ArrayList<Machine>(machRepo.findAll());
	}

}
