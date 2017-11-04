package org.techforumist.jwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techforumist.jwt.domain.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

	public Activity findOneByDescription(String description);
	
	@Query(value="SELECT COUNT(*) FROM tbl_activity", nativeQuery = true)
	public Integer getRegisters();

}
