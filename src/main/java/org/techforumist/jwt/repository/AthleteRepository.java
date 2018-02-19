package org.techforumist.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.techforumist.jwt.domain.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete,Long> {
	
	public Athlete findOneByName(String name);

	@Query(value="SELECT COUNT(*) FROM tbl_athlete ", nativeQuery = true)
	public Integer getRegisters();
	
	@Query(value="SELECT COUNT(*) FROM tbl_athlete ta "
			   + "INNER JOIN athlete_categories ac ON ta.id = ac.athlete_id "
			   + "WHERE ac.categories = 'Sub 20' ", nativeQuery = true)
	public Integer countCatFromAthlete1();
	
	@Query(value="SELECT COUNT(*) FROM tbl_athlete ta "
			   + "INNER JOIN athlete_categories ac ON ta.id = ac.athlete_id "
			   + "WHERE ac.categories = 'Veterano' ", nativeQuery = true)
	public Integer countCatFromAthlete2();
	
	@Query(value="SELECT COUNT(*) FROM tbl_athlete ta "
			   + "INNER JOIN athlete_categories ac ON ta.id = ac.athlete_id "
			   + "WHERE ac.categories = 'Fraldinha' ", nativeQuery = true)
	public Integer countCatFromAthlete3();
	
	@Query(value="SELECT COUNT(*) FROM tbl_athlete ta "
			   + "INNER JOIN athlete_categories ac ON ta.id = ac.athlete_id "
			   + "WHERE ac.categories = 'Sub 17' ", nativeQuery = true)
	public Integer countCatFromAthlete4();
	
	@Query(value="SELECT COUNT(*) FROM tbl_athlete ta "
			   + "INNER JOIN athlete_categories ac ON ta.id = ac.athlete_id "
			   + "WHERE ac.categories = 'Mirim' ", nativeQuery = true)
	public Integer countCatFromAthlete5();
	
	@Query(value="SELECT COUNT(*) FROM tbl_athlete ta "
			   + "INNER JOIN athlete_categories ac ON ta.id = ac.athlete_id "
			   + "WHERE ac.categories = 'Pré Mirim' ", nativeQuery = true)
	public Integer countCatFromAthlete6();

}
