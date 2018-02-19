package org.techforumist.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techforumist.jwt.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {


	public Order findOneByNumberOrder(String numberOrder);
	
	@Query(value="SELECT o.*, os.* FROM tbl_order o "
			   + "INNER JOIN order_status os ON o.id = os.order_id "
			   + "WHERE os.status = 'OK' ",nativeQuery=true)
	public List<Order> findOrdersOK();
    
	@Query(value="SELECT COUNT(*) FROM tbl_order o "
			   + "INNER JOIN order_status os ON o.id = os.order_id "
			   + "WHERE os.status = 'OK' ",nativeQuery=true)
	public Integer getCountOrdersOK();
	
	@Query(value="SELECT COUNT(*) FROM tbl_order o "
			   + "INNER JOIN order_status os ON o.id = os.order_id "
			   + "WHERE os.status = 'Liberado' ",nativeQuery=true)
	public Integer getCountOrdersLib();
	
	@Query(value="SELECT COUNT(*) FROM tbl_order o "
			   + "INNER JOIN order_status os ON o.id = os.order_id "
			   + "WHERE os.status = 'Pendente' ",nativeQuery=true)
	public Integer getCountOrdersPend();
}
