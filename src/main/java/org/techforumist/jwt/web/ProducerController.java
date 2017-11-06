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
import org.techforumist.jwt.domain.Producer;
import org.techforumist.jwt.repository.ActivityRepository;
import org.techforumist.jwt.repository.ProducerRepository;
import org.techforumist.jwt.service.ProducerService;


@RestController
@RequestMapping("/Producer")
public class ProducerController {
	
	@Autowired
	private ProducerRepository prodRepo;
	
	@Autowired
	private ActivityRepository actRepo;
	
	@Autowired
	private ProducerService prodService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> saveProducer(@RequestBody Producer prod){
	   try{	
	       return ResponseEntity
	    		   .status(HttpStatus.OK)
	    		   .body(this.prodService.saveProducer(prod));		   
	   }catch(RuntimeException e){    
		   return ResponseEntity
				   .status(HttpStatus.BAD_REQUEST)
				   .body(e.getMessage());
	   }
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Producer> getProducers(){
	    return new ArrayList<Producer>(prodRepo.findAll());   
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/familyAgr")
	public List<Producer> getProducersFamily(){
	    return new ArrayList<Producer>(prodRepo.getProducersAgrFamily());   
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/familyNotAgr")
	public List<Producer> getProducersNotFamily(){
	    return new ArrayList<Producer>(prodRepo.getProducersNotAgrFamily());   
	}
	
	@RequestMapping(value = "/drop/{id}", method = RequestMethod.DELETE)
	public void  deleteProducer(@PathVariable Long id) {
		Producer producer = prodRepo.findOne(id);
		prodRepo.delete(producer);

	}
    
	@RequestMapping(value="/updateProd", method = RequestMethod.PUT)
	public Producer updateProducer(@RequestBody Producer producer) {
		if (prodRepo.findOneByName(producer.getName()) != null
				&& prodRepo.findOneByName(producer.getName()).getId() != producer.getId()) {
			throw new RuntimeException("Name already exist");
		}
		return prodRepo.save(producer);
	}
	
	@RequestMapping(value="/findActivities", method=RequestMethod.GET)
	public List<Activity> getActivities(){
		return new ArrayList<Activity>(actRepo.findAll());
		
	}
	
	@RequestMapping(value="/tot", method=RequestMethod.GET)
	public Integer getTot(){
		Integer tot = prodRepo.getRegisters();
		return tot;
	}
	
	@RequestMapping(value="/totProdFamily", method=RequestMethod.GET)
	public Integer getTotProdFamily(){
		Integer tot = prodRepo.getProdWithAgriFamily();
		return tot;
	}
	
	@RequestMapping(value="/totProdNotFamily", method=RequestMethod.GET)
	public Integer getTotProdNotFamily(){
		Integer tot = prodRepo.getProdNotAgriFamily();
		return tot;
	}
	
	@RequestMapping(value="/totProdExpiredDAP", method=RequestMethod.GET)
	public Integer getProdDapExpired(){
		Integer tot = prodRepo.getProducerExpiredDap();
		return tot;
	}
	
	@RequestMapping(value="/totProdAtiveDAP", method=RequestMethod.GET)
	public Integer getProdDapAtive(){
		Integer tot = prodRepo.getProducerAtiveDap();
		return tot;
	}
	
	@RequestMapping(value="/totProdCanceledDAP", method=RequestMethod.GET)
	public Integer getProdDapCanceled(){
		Integer tot = prodRepo.getProducerCanceledDap();
		return tot;
	}
	
	@RequestMapping(value="/totProdAct1", method=RequestMethod.GET)
	public Integer getProdAct1(){
		Integer tot = prodRepo.countActFromProducer1();
		return tot;
	}
	
	@RequestMapping(value="/totProdAct2", method=RequestMethod.GET)
	public Integer getProdAct2(){
		Integer tot = prodRepo.countActFromProducer2();
		return tot;
	}
	
	@RequestMapping(value="/totProdAct3", method=RequestMethod.GET)
	public Integer getProdAct3(){
		Integer tot = prodRepo.countActFromProducer3();
		return tot;
	}
	
	@RequestMapping(value="/totProdAct4", method=RequestMethod.GET)
	public Integer getProdAct4(){
		Integer tot = prodRepo.countActFromProducer4();
		return tot;
	}
	
	@RequestMapping(value="/totProdAct5", method=RequestMethod.GET)
	public Integer getProdAct5(){
		Integer tot = prodRepo.countActFromProducer5();
		return tot;
	}
	
	@RequestMapping(value="/totProdAct6", method=RequestMethod.GET)
	public Integer getProdAct6(){
		Integer tot = prodRepo.countActFromProducer6();
		return tot;
	}
	
	
	
	
	
	
}
