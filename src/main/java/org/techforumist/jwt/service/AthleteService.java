package org.techforumist.jwt.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techforumist.jwt.domain.Athlete;
import org.techforumist.jwt.repository.AthleteRepository;

@Service
public class AthleteService {
	
	@Autowired
	private AthleteRepository athRepo;
	
	public Athlete saveAthlete(Athlete ath) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date timeOrder = Calendar.getInstance().getTime();
		String dateFormated = sdf.format(timeOrder);
		return athRepo.save(ath);
		
	}

}
