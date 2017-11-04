package org.techforumist.jwt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techforumist.jwt.domain.Producer;
import org.techforumist.jwt.repository.ProducerRepository;

@Service
public class ProducerService {
	
	@Autowired
	private ProducerRepository prodRepo;
	
	@Transactional
	public Producer saveProducer(Producer prod){
		List<Producer> producers = prodRepo.findAll();
		for(Producer producer: producers){
			String cpfProducer = producer.getCpf();
			long codIncra = producer.getCod_incra();
			long rgProducer = producer.getRg();
			long cadPro = producer.getCadPro();
			
		    if(cpfProducer.equals(prod.getCpf())){
			   throw new RuntimeException("cpf ja esta cadastrado !!");
		    }
		    else if(rgProducer == (prod.getRg())){
			   throw new RuntimeException("rg ja esta cadastrado !!");
		    }
		    else if(codIncra == (prod.getCod_incra())){
			   throw new RuntimeException("codIncra ja esta cadastrado !!");
			}
		    else if(cadPro == (prod.getCadPro())){
			   throw new RuntimeException("cadProp ja esta cadastrado !!");
			}
	    }
		    return prodRepo.save(prod);
	}
  
}
