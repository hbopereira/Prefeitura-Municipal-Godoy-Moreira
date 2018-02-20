package org.techforumist.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.techforumist.jwt.domain.AttendanceAgricultureMachine;
import org.techforumist.jwt.domain.AttendanceAgricultureTechnicalAssistance;

public interface AttendanceAgricultureTechnicalAssistanceRepository
    extends JpaRepository<AttendanceAgricultureTechnicalAssistance, Long> {

	public AttendanceAgricultureTechnicalAssistance findOneByDetails(String details);
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_agriculture_technical_assistance ta "
		    + "INNER JOIN attendance_agriculture_technical_assistance_status ts ON ta.id = ts.attendance_agriculture_technical_assistance_id "
		    + "WHERE ts.status = 'Andamento' ", nativeQuery=true)
public List<AttendanceAgricultureTechnicalAssistance> findAttActive();

@Query(value="SELECT COUNT(*) FROM tbl_attendance_agriculture_technical_assistance ta "
	    + "INNER JOIN attendance_agriculture_technical_assistance_status ts ON ta.id = ts.attendance_agriculture_technical_assistance_id "
	    + "WHERE ts.status = 'Andamento' ", nativeQuery=true)
public Integer countAttActive();

@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_agriculture_technical_assistance ta "
	    + "INNER JOIN attendance_agriculture_technical_assistance_status ts ON ta.id = ts.attendance_agriculture_technical_assistance_id "
	    + "WHERE ts.status = 'Não Concluido' ", nativeQuery=true)
public List<AttendanceAgricultureTechnicalAssistance> findAttNot();

@Query(value="SELECT COUNT(*) FROM tbl_attendance_agriculture_technical_assistance ta "
	    + "INNER JOIN attendance_agriculture_technical_assistance_status ts ON ta.id = ts.attendance_agriculture_technical_assistance_id "
	    + "WHERE ts.status = 'Não Concluido' ", nativeQuery=true)
public Integer countAttNot();

@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_agriculture_technical_assistance ta "
	    + "INNER JOIN attendance_agriculture_technical_assistance_status ts ON ta.id = ts.attendance_agriculture_technical_assistance_id "
	    + "WHERE ts.status = 'finalizado' ", nativeQuery=true)
public List<AttendanceAgricultureTechnicalAssistance> findAttFinally();

@Query(value="SELECT COUNT(*) FROM tbl_attendance_agriculture_technical_assistance ta "
	    + "INNER JOIN attendance_agriculture_technical_assistance_status ts ON ta.id = ts.attendance_agriculture_technical_assistance_id "
	    + "WHERE ts.status = 'finalizado' ", nativeQuery=true)
public Integer countAttFinally();


}
