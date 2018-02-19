package org.techforumist.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techforumist.jwt.domain.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine,Long> {

}
