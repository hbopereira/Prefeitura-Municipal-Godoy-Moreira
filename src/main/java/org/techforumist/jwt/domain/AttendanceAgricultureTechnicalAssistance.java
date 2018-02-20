package org.techforumist.jwt.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

@Entity
@Table(name="tbl_Attendance_Agriculture_Technical_Assistance")
public class AttendanceAgricultureTechnicalAssistance implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn
	private Producer producer;
	
	@OneToOne
	@JoinColumn
	private People people;
	
	@ElementCollection
	private List<String> status = new ArrayList<String>();
	
	@ElementCollection
	private List<String> nameEmployee = new ArrayList<String>();
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long Id;

	@Column(name="at_cancellation_reason")
	private String cancelattionReason;
	
	@Column(name="at_details")
	private String details;
	
	@Column(name="at_dayattendance")
	private Date day_attendance;
	
	@Column(name="at_plannedDay")
	private Date plannedDay;
	
	@Column(name="at_timeattendance")
	private String time_attendance;
	
	@Column(name="at_datefinally")
	private Date dateFinally;

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

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	public List<String> getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(List<String> nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCancelattionReason() {
		return cancelattionReason;
	}

	public void setCancelattionReason(String cancelattionReason) {
		this.cancelattionReason = cancelattionReason;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getDay_attendance() {
		return day_attendance;
	}

	public void setDay_attendance(Date day_attendance) {
		this.day_attendance = day_attendance;
	}

	public Date getPlannedDay() {
		return plannedDay;
	}

	public void setPlannedDay(Date plannedDay) {
		this.plannedDay = plannedDay;
	}

	public String getTime_attendance() {
		return time_attendance;
	}

	public void setTime_attendance(String time_attendance) {
		this.time_attendance = time_attendance;
	}

	public Date getDateFinally() {
		return dateFinally;
	}

	public void setDateFinally(Date dateFinally) {
		this.dateFinally = dateFinally;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
