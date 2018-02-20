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
@Table(name="tbl_attendance_Agriculture_machine")
public class AttendanceAgricultureMachine implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn
	private Order order;
	
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

	public String getTime_attendance() {
		return time_attendance;
	}

	public void setTime_attendance(String time_attendance) {
		//Date dateTime = new Date(time_attendance.getTime());
		this.time_attendance = time_attendance;
		
	}

	public String getCancelattionReason() {
		return cancelattionReason;
	}

	public void setCancelattionReason(String cancelattionReason) {
		this.cancelattionReason = cancelattionReason;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getPlannedDay() {
		return plannedDay;
	}

	public void setPlannedDay(Date plannedDay) {
		this.plannedDay = plannedDay;
	}
	
	
	
	
	
    
}
