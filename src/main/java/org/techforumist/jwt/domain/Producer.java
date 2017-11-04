package org.techforumist.jwt.domain;


import java.io.Serializable;
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
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import org.techforumist.jwt.enums.Sexo;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="tbl_producer")
public class Producer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(fetch=FetchType.EAGER)
	  @JoinTable(name="producer_activity",
	             joinColumns={@JoinColumn(name="producer_id")},
	             inverseJoinColumns={@JoinColumn(name="activity_id")})
    private List<Activity> activities = new ArrayList<>();
	
	@ElementCollection
	private List<String> regions = new ArrayList<>();
	
	@ElementCollection
	private List<String> status = new ArrayList<>();

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name="prod_number_dap")
	private String numberDap;
	
	@Column(name="prod_name")
	@NotNull
	private String name;
	
	@Column(name="prod_name_father")
	@NotNull
	private String nameFather;
	
	@Column(name="prod_name_mother")
	@NotNull
	private String nameMother;
	
	@Column(name="prod_rg")
	@NotNull
	private Long rg;
	
	@Column(name="prod_cep")
	@NotNull
	private Long cep;
	
	@Column(name="prod_cadPro")
	@NotNull
	private Long cadPro;
	
	@Column(name="prod_cpf")
	@NotNull
	private String cpf;
	
	@Column(name="prod_cod_incra")
	@NotNull
	private Long cod_incra;
	
	@Column(name="prod_wife_name")
	@NotNull
	private String wife_name;
	
	@Column(name="prod_property_name")
	@NotNull
	private String property_name;
	
	@Column(name="prod_property_area")
	@NotNull
	private String property_area;
	
	@Column(name="prod_birth_date")
    @NotNull
	private Date birth_date;
	
	@Column(name="prod_longitude")
	@NotNull
	private String longitude;
	
	@Column(name="prod_latitude")
	@NotNull
	private String latitude;
	
	@Column(name="prod_altitude")
	@NotNull
	private String altitude;
	
	@Column(name="prod_owner_name")
	private String ownerName;
	
	@Column(name="prod_owner_cpf")
	private Long cpfOwner;
	
	public String getNameFather() {
		return nameFather;
	}

	public void setNameFather(String nameFather) {
		this.nameFather = nameFather;
	}

	public String getNameMother() {
		return nameMother;
	}

	public void setNameMother(String nameMother) {
		this.nameMother = nameMother;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Long getCpfOwner() {
		return cpfOwner;
	}

	public void setCpfOwner(Long cpfOwner) {
		this.cpfOwner = cpfOwner;
	}

	public Long getCadPro() {
		return cadPro;
	}

	public void setCadPro(Long cadPro) {
		this.cadPro = cadPro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	public String getNumberDap() {
		return numberDap;
	}

	public void setNumberDap(String numberDap) {
		this.numberDap = numberDap;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Date getBirth_date() {
		return birth_date;
	}

    public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getCod_incra() {
		return cod_incra;
	}

	public void setCod_incra(Long cod_incra) {
		this.cod_incra = cod_incra;
	}

	public String getWife_name() {
		return wife_name;
	}

	public void setWife_name(String wife_name) {
		this.wife_name = wife_name;
	}

	public String getProperty_name() {
		return property_name;
	}

	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}

	public String getProperty_area() {
		return property_area;
	}

	public void setProperty_area(String property_area) {
		this.property_area = property_area;
	}

	public List<String> getRegions() {
		return regions;
	}

	public void setRegions(List<String> regions) {
		this.regions = regions;
	}

	

}
