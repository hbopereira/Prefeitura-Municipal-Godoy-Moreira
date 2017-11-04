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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.techforumist.jwt.enums.Sector;
import org.techforumist.jwt.enums.Sexo;

@Entity
@Table(name="tbl_people")
public class People implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="people_sexo")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(name="people_sector")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sector sector;
	
	@ElementCollection
	private List<String> regions = new ArrayList<>();

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name="people_name")
	@NotNull
	private String name;
	
	@Column(name="people_name_father")
	@NotNull
	private String nameFather;
	
	@Column(name="people_name_mother")
	@NotNull
	private String nameMother;
	
	@Column(name="people_rg")
	@NotNull
	private Long rg;
	
	@Column(name="people_cpf")
	@NotNull
	private String cpf;
	
	@Column(name="people_birth_date")
    @NotNull
	private Date birth_date;
	

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<String> getRegions() {
		return regions;
	}

	public void setRegions(List<String> regions) {
		this.regions = regions;
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

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	

}
