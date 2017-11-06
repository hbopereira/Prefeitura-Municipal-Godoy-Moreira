package org.techforumist.jwt.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techforumist.jwt.domain.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer,Long> {

	public Producer findOneByName(String name);
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer", nativeQuery = true)
	public Integer getRegisters();
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer tp"
			   + " INNER JOIN producer_status ps ON tp.id = ps.producer_id"
			   + " WHERE ps.status = 'Expirado' ", nativeQuery = true)
	public Integer getProducerExpiredDap();
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer tp"
			   + " INNER JOIN producer_status ps ON tp.id = ps.producer_id"
			   + " WHERE ps.status = 'Ativo' ", nativeQuery = true)
	public Integer getProducerAtiveDap();
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer tp"
			   + " INNER JOIN producer_status ps ON tp.id = ps.producer_id"
			   + " WHERE ps.status = 'Cancelado' ", nativeQuery = true)
	public Integer getProducerCanceledDap();
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer tp "
			   + " INNER JOIN producer_status ps ON ps.producer_id = tp.id "
			   + " WHERE ps.status = 'Ativo' OR ps.status = 'Cancelado' OR ps.status = 'Expirado' ", nativeQuery = true)
	public Integer getProdWithAgriFamily();
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer tp "
			   + " INNER JOIN producer_status ps ON ps.producer_id = tp.id "
			   + " WHERE ps.status = 'Não Possui' ", nativeQuery = true)
	public Integer getProdNotAgriFamily();
    
	@Query(value=" SELECT tp.*, ps.* FROM tbl_producer tp "
			   + " INNER JOIN producer_status ps ON ps.producer_id = tp.id "
			   + " WHERE ps.status = 'Ativo' OR ps.status = 'Cancelado' OR ps.status = 'Expirado'"
			   + " ORDER BY ps.status ASC ", nativeQuery = true)
	public List<Producer> getProducersAgrFamily();
	
	@Query(value=" SELECT tp.*, ps.* FROM tbl_producer tp "
			   + " INNER JOIN producer_status ps ON ps.producer_id = tp.id "
			   + " WHERE ps.status = 'Não Possui' ", nativeQuery = true)
	public List<Producer> getProducersNotAgrFamily();
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer tp "
			   + " INNER JOIN producer_activity pa ON pa.producer_id = tp.id "
			   + " INNER JOIN tbl_activity ta ON ta.id = pa.activity_id"
			   + " WHERE ta.acti_description = 'Mandioca' ", nativeQuery = true)
	public Integer countActFromProducer1();
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer tp "
			   + " INNER JOIN producer_activity pa ON pa.producer_id = tp.id "
			   + " INNER JOIN tbl_activity ta ON ta.id = pa.activity_id"
			   + " WHERE ta.acti_description = 'Maracuja' ", nativeQuery = true)
	public Integer countActFromProducer2();
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer tp "
			   + " INNER JOIN producer_activity pa ON pa.producer_id = tp.id "
			   + " INNER JOIN tbl_activity ta ON ta.id = pa.activity_id"
			   + " WHERE ta.acti_description = 'Morango' ", nativeQuery = true)
	public Integer countActFromProducer3();
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer tp "
			   + " INNER JOIN producer_activity pa ON pa.producer_id = tp.id "
			   + " INNER JOIN tbl_activity ta ON ta.id = pa.activity_id"
			   + " WHERE ta.acti_description = 'Gado Corte' ", nativeQuery = true)
	public Integer countActFromProducer4();
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer tp "
			   + " INNER JOIN producer_activity pa ON pa.producer_id = tp.id "
			   + " INNER JOIN tbl_activity ta ON ta.id = pa.activity_id"
			   + " WHERE ta.acti_description = 'Gado Leite' ", nativeQuery = true)
	public Integer countActFromProducer5();
	
	@Query(value=" SELECT COUNT(*) FROM tbl_producer tp "
			   + " INNER JOIN producer_activity pa ON pa.producer_id = tp.id "
			   + " INNER JOIN tbl_activity ta ON ta.id = pa.activity_id"
			   + " WHERE ta.acti_description = 'Gado Recrio' ", nativeQuery = true)
	public Integer countActFromProducer6();
	
	
}
