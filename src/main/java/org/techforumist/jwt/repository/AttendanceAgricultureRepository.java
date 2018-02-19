package org.techforumist.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techforumist.jwt.domain.AttendanceAgriculture;

@Repository
public interface AttendanceAgricultureRepository extends JpaRepository<AttendanceAgriculture,Long> {

	public AttendanceAgriculture findOneByDetails(String details);
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_agriculture ta "
			    + "INNER JOIN attendance_agriculture_status ts ON ta.id = ts.attendance_agriculture_id "
			    + "WHERE ts.status = 'Andamento' ", nativeQuery=true)
    public List<AttendanceAgriculture> findAttActive();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance_agriculture ta "
		    + "INNER JOIN attendance_agriculture_status ts ON ta.id = ts.attendance_agriculture_id "
		    + "WHERE ts.status = 'Andamento' ", nativeQuery=true)
    public Integer countAttActive();
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_agriculture ta "
		    + "INNER JOIN attendance_agriculture_status ts ON ta.id = ts.attendance_agriculture_id "
		    + "WHERE ts.status = 'Não Concluido' ", nativeQuery=true)
    public List<AttendanceAgriculture> findAttNot();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance_agriculture ta "
		    + "INNER JOIN attendance_agriculture_status ts ON ta.id = ts.attendance_agriculture_id "
		    + "WHERE ts.status = 'Não Concluido' ", nativeQuery=true)
    public Integer countAttNot();
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_agriculture ta "
		    + "INNER JOIN attendance_agriculture_status ts ON ta.id = ts.attendance_agriculture_id "
		    + "WHERE ts.status = 'finalizado' ", nativeQuery=true)
    public List<AttendanceAgriculture> findAttFinally();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance_agriculture ta "
		    + "INNER JOIN attendance_agriculture_status ts ON ta.id = ts.attendance_agriculture_id "
		    + "WHERE ts.status = 'finalizado' ", nativeQuery=true)
    public Integer countAttFinally();
   
	
}
