package org.techforumist.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techforumist.jwt.domain.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

	public Attendance findOneByDetails(String details);
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance ta "
			    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
			    + "WHERE ts.status = 'Andamento'"
			    + "AND att_sector = 'AGRICULTURA' ", nativeQuery=true)
    public List<Attendance> findAttActive();
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance ta "
		    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
		    + "WHERE ts.status = 'Andamento'"
		    + "AND att_sector = 'ESPORTE' ", nativeQuery=true)
   public List<Attendance> findAttActiveSport();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance ta "
		    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
		    + "WHERE ts.status = 'Andamento' "
		    + "AND att_sector = 'AGRICULTURA' ", nativeQuery=true)
    public Integer countAttActive();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance ta "
		    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
		    + "WHERE ts.status = 'Andamento' "
		    + "AND att_sector = 'ESPORTE' ", nativeQuery=true)
    public Integer countAttActiveSport();
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance ta "
		    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
		    + "WHERE ts.status = 'Não Concluido' "
		    + "AND att_sector = 'AGRICULTURA' ", nativeQuery=true)
    public List<Attendance> findAttNot();
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance ta "
		    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
		    + "WHERE ts.status = 'Não Concluido' "
		    + "AND att_sector = 'ESPORTE' ", nativeQuery=true)
    public List<Attendance> findAttNotSport();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance ta "
		    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
		    + "WHERE ts.status = 'Não Concluido' "
		    + "AND att_sector = 'AGRICULTURA' ", nativeQuery=true)
    public Integer countAttNot();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance ta "
		    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
		    + "WHERE ts.status = 'Não Concluido' "
		    + "AND att_sector = 'ESPORTE' ", nativeQuery=true)
    public Integer countAttNotSport();
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance ta "
		    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
		    + "WHERE ts.status = 'finalizado' "
		    + "AND att_sector = 'AGRICULTURA' ", nativeQuery=true)
    public List<Attendance> findAttFinally();
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance ta "
		    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
		    + "WHERE ts.status = 'finalizado' "
		    + "AND att_sector = 'ESPORTE' ", nativeQuery=true)
    public List<Attendance> findAttFinallySport();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance ta "
		    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
		    + "WHERE ts.status = 'finalizado' "
		    + "AND att_sector = 'AGRICULTURA' ", nativeQuery=true)
    public Integer countAttFinally();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance ta "
		    + "INNER JOIN attendance_status ts ON ta.id = ts.attendance_id "
		    + "WHERE ts.status = 'finalizado' "
		    + "AND att_sector = 'ESPORTE' ", nativeQuery=true)
    public Integer countAttFinallySport();
   
	
}
