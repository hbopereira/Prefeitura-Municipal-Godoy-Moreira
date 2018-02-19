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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_attendance_sport")
public class AttendanceSport implements Serializable {

	private static final long serialVersionUID = 1L;
	
	  @OneToOne
	  @JoinColumn
	  private People people;	
	  
	  @OneToOne
	  @JoinColumn
      private Athlete athlete;
	  
	  @ElementCollection
	  private List<String> status = new ArrayList<String>();
	  
	  @ElementCollection
	  private List<String> timeofDay = new ArrayList<String>();
	  
	  @ElementCollection
	  private List<String> typeService = new ArrayList<String>();
		
	  @ElementCollection
	  private List<String> descTypeService = new ArrayList<String>();
	  
	  @Id
	  @GeneratedValue(strategy= GenerationType.AUTO)
	  private Long Id;
	  
	  @Column(name="at_day_time")
	  private Date dayTime;
		
	  @Column(name="at_details")
	  @NotNull
	  private String details;
		
	  @Column(name="at_dayattendance")
	  private Date day_attendance;
		
	  @Column(name="at_timeattendance")
	  private String time_attendance;
		
	  @Column(name="at_datefinally")
	  private Date dateFinally;
	  
	  @Column(name="at_cancellation_reason")
	  private String cancelattionReason;

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
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

	public List<String> getDescTypeService() {
		return descTypeService;
	}

	public void setDescTypeService(List<String> descTypeService) {
		this.descTypeService = descTypeService;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDayTime() {
		return dayTime;
	}

	public void setDayTime(Date dayTime) {
		this.dayTime = dayTime;
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

	public String getCancelattionReason() {
		return cancelattionReason;
	}

	public void setCancelattionReason(String cancelattionReason) {
		this.cancelattionReason = cancelattionReason;
	}

	public List<String> getTimeofDay() {
		return timeofDay;
	}

	public void setTimeofDay(List<String> timeofDay) {
		this.timeofDay = timeofDay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	  
	  

}
