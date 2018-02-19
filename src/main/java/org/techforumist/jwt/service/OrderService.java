package org.techforumist.jwt.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techforumist.jwt.domain.Order;
import org.techforumist.jwt.repository.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Transactional
	public Order saveOrder(Order order) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date timeOrder = Calendar.getInstance().getTime();
		String dateFormated = sdf.format(timeOrder);
		order.setTimeOrder(dateFormated);
		
		List<Order> orders = orderRepo.findAll();
		
		for(Order ord: orders) {
			String numberOrder = ord.getNumberOrder();
			
			if(numberOrder.equals(order.getNumberOrder())) {
				throw new RuntimeException("Dados ja Existentes !");
			}
		}
		return orderRepo.save(order);
		
	}

}
