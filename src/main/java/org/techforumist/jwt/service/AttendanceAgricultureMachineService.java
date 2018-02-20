package org.techforumist.jwt.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techforumist.jwt.domain.AttendanceAgricultureMachine;
import org.techforumist.jwt.repository.AttendanceAgricultureMachineRepository;

@Service
public class AttendanceAgricultureMachineService {
	
	@Autowired
	private AttendanceAgricultureMachineRepository attRepo;
	
	@Transactional
	public AttendanceAgricultureMachine saveAttendance(AttendanceAgricultureMachine att) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date timeOrder = Calendar.getInstance().getTime();
		String dateFormated = sdf.format(timeOrder);
		att.setTime_attendance(dateFormated);
		
		return attRepo.save(att);
		
	}

}
