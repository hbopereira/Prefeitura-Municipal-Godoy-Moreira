package org.techforumist.jwt.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techforumist.jwt.domain.AttendanceAgricultureTechnicalAssistance;
import org.techforumist.jwt.repository.AttendanceAgricultureTechnicalAssistanceRepository;

@Service
public class AttendanceAgricultureTechnicalAssistanceService {
	
	@Autowired
	private AttendanceAgricultureTechnicalAssistanceRepository attRepo;
	
	public AttendanceAgricultureTechnicalAssistance saveAttendance(AttendanceAgricultureTechnicalAssistance att) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date timeOrder = Calendar.getInstance().getTime();
		String dateFormated = sdf.format(timeOrder);
		att.setTime_attendance(dateFormated);
		
		return attRepo.save(att);
	}

}
