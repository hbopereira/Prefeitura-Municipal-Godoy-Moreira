package org.techforumist.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techforumist.jwt.domain.AttendanceSport;

@Repository
public interface AttendanceSportRepository extends JpaRepository<AttendanceSport,Long> {

	public AttendanceSport findOneByDetails(String details);
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_sport ta "
		    + "INNER JOIN attendance_sport_status ts ON ta.id = ts.attendance_sport_id "
		    + "WHERE ts.status = 'Andamento' ", nativeQuery=true)
    public List<AttendanceSport> findAttActiveSport();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance_sport ta "
		    + "INNER JOIN attendance_sport_status ts ON ta.id = ts.attendance_sport_id "
	        + "WHERE ts.status = 'Andamento' ", nativeQuery=true)
    public Integer countAttActiveSport();
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_sport ta "
		    + "INNER JOIN attendance_sport_status ts ON ta.id = ts.attendance_sport_id "
		    + "WHERE ts.status = 'Não Concluido' ", nativeQuery=true)
    public List<AttendanceSport> findAttNotSport();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance_sport ta "
		    + "INNER JOIN attendance_sport_status ts ON ta.id = ts.attendance_sport_id "
		    + "WHERE ts.status = 'Não Concluido' ", nativeQuery=true)
    public Integer countAttNotSport();
	
	@Query(value="SELECT ta.*, ts.* FROM tbl_attendance_sport ta "
			    + "INNER JOIN attendance_sport_status ts ON ta.id = ts.attendance_sport_id "
			    + "WHERE ts.status = 'finalizado'  ", nativeQuery=true)
	public List<AttendanceSport> findAttFinallySport();
	
	@Query(value="SELECT COUNT(*) FROM tbl_attendance_sport ta "
		    + "INNER JOIN attendance_sport_status ts ON ta.id = ts.attendance_sport_id "
		    + "WHERE ts.status = 'finalizado' ", nativeQuery=true)
    public Integer countAttFinallySport();

	
	
	
	
}
