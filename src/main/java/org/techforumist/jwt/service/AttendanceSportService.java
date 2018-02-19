package org.techforumist.jwt.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techforumist.jwt.domain.AttendanceSport;
import org.techforumist.jwt.repository.AttendanceSportRepository;

@Service
public class AttendanceSportService {
	
	@Autowired
	private AttendanceSportRepository attRepo;
	
	public AttendanceSport saveAttendanceSport(AttendanceSport att) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date timeAttendance = Calendar.getInstance().getTime();
		String dateFormated = sdf.format(timeAttendance);
		att.setTime_attendance(dateFormated);
		
		return attRepo.save(att);
		
	}

}
