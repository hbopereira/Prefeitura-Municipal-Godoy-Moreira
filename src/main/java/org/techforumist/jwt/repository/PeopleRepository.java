package org.techforumist.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.techforumist.jwt.domain.People;

public interface PeopleRepository extends JpaRepository<People,Long> {
	
	@Query(value="SELECT tp.* FROM tbl_people tp "
			   + "WHERE tp.people_sector = 'AGRICULTURA' ", nativeQuery=true)
	public List<People> getPeoplesFromAgriculture();
	
	@Query(value="SELECT tp.* FROM tbl_people tp "
			   + "WHERE tp.people_sector = 'ESPORTE' ", nativeQuery=true)
	public List<People> getPeoplesFromSport();

}
