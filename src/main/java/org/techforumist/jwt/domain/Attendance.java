package org.techforumist.jwt.domain;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.techforumist.jwt.enums.Deadline;
import org.techforumist.jwt.enums.Sector;
import org.techforumist.jwt.enums.Sexo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name="tbl_attendance")
public class Attendance implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn
	private Producer producer;
	
	@OneToOne
	@JoinColumn
	private Athlete athlete;
	
    @OneToOne
    @JoinColumn
    private People people;	
    
	@Column(name="att_sector")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sector sector;
	
	@Column(name="att_deadline")
	@Enumerated(EnumType.STRING)
	private Deadline deadline;
	
	@ElementCollection
	private List<String> status = new ArrayList<String>();
	
	@ElementCollection
	private List<String> nameEmployee = new ArrayList<String>();
	
	@ElementCollection
	private List<String> typeService = new ArrayList<String>();
	
	@ElementCollection
	private List<String> descTypeService = new ArrayList<String>();
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long Id;

	@Column(name="at_cancellation_reason")
	private String cancelattionReason;
	
    @Column(name="at_day_time")
	private Date dayTime;
	
    @Column(name="at_time_Day")
	private String timeOfDay;
	
	@Column(name="at_details")
	@NotNull
	private String details;
	
	@Column(name="at_dayattendance")
	private Date day_attendance;
	
	@Column(name="at_timeattendance")
	private Date time_attendance;
	
	@Column(name="at_datefinally")
	private Date dateFinally;
	
	public Date getDateFinally() {
		return dateFinally;
	}

	public void setDateFinally(Date dateFinally) {
		this.dateFinally = dateFinally;
	}
	
	public List<String> getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(List<String> nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
		//SimpleDateFormat formated = new SimpleDateFormat("dd/MM/yyyy");
		//String dateFormated = formated.format(day_attendance);
		
		this.day_attendance = day_attendance;
	}

	public Date getTime_attendance() {
		return time_attendance;
	}

	public void setTime_attendance(Date time_attendance) {
		Date dateTime = new Date(time_attendance.getTime());
		this.time_attendance = dateTime;
		
	}

	public String getCancelattionReason() {
		return cancelattionReason;
	}

	public void setCancelattionReason(String cancelattionReason) {
		this.cancelattionReason = cancelattionReason;
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

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Deadline getDeadline() {
		return deadline;
	}

	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Date getDayTime() {
		return dayTime;
	}

	public void setDayTime(Date dayTime) {
		this.dayTime = dayTime;
	}

	public String getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}
	
	
	
	
	
    
}
