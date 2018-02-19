package org.techforumist.jwt.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.techforumist.jwt.domain.Order;
import org.techforumist.jwt.domain.People;
import org.techforumist.jwt.domain.Producer;
import org.techforumist.jwt.repository.OrderRepository;
import org.techforumist.jwt.service.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderService serviceOrder;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> saveOrder(@RequestBody Order order){
	   try{	
	       return ResponseEntity
	    		   .status(HttpStatus.OK)
	    		   .body(this.serviceOrder.saveOrder(order));		   
	   }catch(RuntimeException e){    
		   return ResponseEntity
				   .status(HttpStatus.BAD_REQUEST)
				   .body(e.getMessage());
	   }
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Order> findAllOrders(){
		return new ArrayList<Order>(orderRepo.findAll());
	}
	
	@RequestMapping(value = "/ordersOK", method=RequestMethod.GET)
	public List<Order> findAllOrdersStatusOk(){
		return new ArrayList<Order>(orderRepo.findOrdersOK());
	}
	
	@RequestMapping(value = "/drop/{id}", method = RequestMethod.DELETE)
	public void  deleteOrder(@PathVariable Long id) {
		Order order = orderRepo.findOne(id);
		orderRepo.delete(order);

	}
    
	@RequestMapping(value="/updateOrder", method = RequestMethod.PUT)
	public Order updateOrder(@RequestBody Order order) {
		if (orderRepo.findOneByNumberOrder(order.getNumberOrder()) != null
				&& orderRepo.findOneByNumberOrder(order.getNumberOrder()).getId() != order.getId()) {
			throw new RuntimeException("Name already exist");
		}
		return orderRepo.save(order);
	}
	
	@RequestMapping(value="/totOrdersOK", method=RequestMethod.GET)
	public Integer getTotOK(){
		Integer tot = orderRepo.getCountOrdersOK();
		return tot;
	}
	
	@RequestMapping(value="/totOrdersLib", method=RequestMethod.GET)
	public Integer getTotLib(){
		Integer tot = orderRepo.getCountOrdersLib();
		return tot;
	}
	
	@RequestMapping(value="/totOrdersPend", method=RequestMethod.GET)
	public Integer getTotPend(){
		Integer tot = orderRepo.getCountOrdersPend();
		return tot;
	}

}
