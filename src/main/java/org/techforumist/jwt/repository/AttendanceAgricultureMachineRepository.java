package org.techforumist.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techforumist.jwt.domain.AttendanceAgricultureMachine;

@Repository
public interface AttendanceAgricultureMachineRepository extends JpaRepository<AttendanceAgricultureMachine,Long> {

	public AttendanceAgricultureMachine findOneByDetails(String details);
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_agriculture_machine ta "
			    + "INNER JOIN attendance_agriculture_machine_status ts ON ta.id = ts.attendance_agriculture_machine_id "
			    + "WHERE ts.status = 'Andamento' ", nativeQuery=true)
    public List<AttendanceAgricultureMachine> findAttActive();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance_agriculture_machine ta "
		    + "INNER JOIN attendance_agriculture_machine_status ts ON ta.id = ts.attendance_agriculture_machine_id "
		    + "WHERE ts.status = 'Andamento' ", nativeQuery=true)
    public Integer countAttActive();
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_agriculture_machine ta "
		    + "INNER JOIN attendance_agriculture_machine_status ts ON ta.id = ts.attendance_agriculture_machine_id "
		    + "WHERE ts.status = 'Não Concluido' ", nativeQuery=true)
    public List<AttendanceAgricultureMachine> findAttNot();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance_agriculture_machine ta "
		    + "INNER JOIN attendance_agriculture_machine_status ts ON ta.id = ts.attendance_agriculture_machine_id "
		    + "WHERE ts.status = 'Não Concluido' ", nativeQuery=true)
    public Integer countAttNot();
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_agriculture_machine ta "
		    + "INNER JOIN attendance_agriculture_machine_status ts ON ta.id = ts.attendance_agriculture_machine_id "
		    + "WHERE ts.status = 'finalizado' ", nativeQuery=true)
    public List<AttendanceAgricultureMachine> findAttFinally();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance_agriculture_machine ta "
		    + "INNER JOIN attendance_agriculture_machine_status ts ON ta.id = ts.attendance_agriculture_machine_id "
		    + "WHERE ts.status = 'finalizado' ", nativeQuery=true)
    public Integer countAttFinally();
   
	
}
