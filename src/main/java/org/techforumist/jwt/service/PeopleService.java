package org.techforumist.jwt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techforumist.jwt.domain.People;
import org.techforumist.jwt.repository.PeopleRepository;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepo;
	
	@Transactional
	public People savePeople(People people){
		List<People> peoples = peopleRepo.findAll();
		for(People peo: peoples){
			String cpfPeople = peo.getCpf();
			long rgProducer = peo.getRg();
			
		    if(cpfPeople.equals(people.getCpf())){
			   throw new RuntimeException("cpf ja esta cadastrado !!");
		    }
		    else if(rgProducer == (people.getRg())){
			   throw new RuntimeException("rg ja esta cadastrado !!");
		    }
	    }
		    return peopleRepo.save(people);
	}

}
