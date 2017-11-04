package org.techforumist.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techforumist.jwt.domain.AppUser;

/**
 * @author Sarath Muraleedharan
 *
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findOneByUsername(String username);
	
	@Query(value="SELECT COUNT(*) FROM app_user", nativeQuery=true)
	public Integer getRegisters();
}
