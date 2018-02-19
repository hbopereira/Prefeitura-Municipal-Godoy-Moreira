package org.techforumist.jwt.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn
	private Producer producer;
	
	@OneToOne
    @JoinColumn
	private People people;	
	
	@OneToOne
    @JoinColumn
	private Machine machine;
	
	@ElementCollection
	private List<String> status = new ArrayList<String>();
	
	@ElementCollection
	private List<String> typeService = new ArrayList<String>();
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name="order_details")
    @NotNull
	private String details;
	
	@Column(name="order_number")
    @NotNull
	private String numberOrder;
	
	@Column(name="order_hours")
    @NotNull
	private String numberHoursWorked;
	
	@Column(name="order_date")
    @NotNull
	private Date dateOrder;
	
	@Column(name="order_time")
    @NotNull
	private String timeOrder;

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	public List<String> getTypeService() {
		return typeService;
	}

	public void setTypeService(List<String> typeService) {
		this.typeService = typeService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getTimeOrder() {
		return timeOrder;
	}

	public void setTimeOrder(String timeOrder) {
		//GregorianCalendar cg = new GregorianCalendar();
	//Date dateTime = new Date(timeOrder.getTime());
		this.timeOrder = timeOrder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNumberOrder() {
		return numberOrder;
	}

	public void setNumberOrder(String numberOrder) {
		this.numberOrder = numberOrder;
	}

	public String getNumberHoursWorked() {
		return numberHoursWorked;
	}

	public void setNumberHoursWorked(String numberHoursWorked) {
		this.numberHoursWorked = numberHoursWorked;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	
	
	
	
	
	
	
	

}
