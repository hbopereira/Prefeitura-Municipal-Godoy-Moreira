package org.techforumist.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.techforumist.jwt.domain.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete,Long> {
	
	public Athlete findOneByName(String name);

	@Query(value="SELECT COUNT(*) FROM tbl_athlete", nativeQuery = true)
	public Integer getRegisters();

}
