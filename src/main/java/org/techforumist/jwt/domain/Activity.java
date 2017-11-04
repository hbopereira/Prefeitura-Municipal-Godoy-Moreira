package org.techforumist.jwt.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_activity")
public class Activity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ElementCollection
	private List<String> period = new ArrayList<>();

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name="acti_description")
	@NotNull
	private String description;
	
	@Column(name="acti_details")
	@NotNull
	private String details;
	
	@Column(name="acti_type_prague")
	@NotNull
	private String typePrague;
	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getPeriod() {
		return period;
	}

	public void setPeriod(List<String> period) {
		this.period = period;
	}

	public String getTypePrague() {
		return typePrague;
	}

	public void setTypePrague(String typePrague) {
		this.typePrague = typePrague;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

    

}
