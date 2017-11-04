package org.techforumist.jwt.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.techforumist.jwt.enums.Sexo;

@Entity
@Table(name="tbl_athlete")
public class Athlete implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="prod_sexo")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@ElementCollection
	private List<String> categories = new ArrayList<>();
	
	@ElementCollection
	private List<String> regions = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name="ath_name")
	@NotNull
	private String name;
	
	@Column(name="ath_name_father")
	@NotNull
	private String nameFather;
	
	@Column(name="ath_name_mother")
	@NotNull
	private String nameMother;
	
	@Column(name="ath_birthDate")
	@NotNull
	private Date birthDate;
	
	@Column(name="ath_rg")
	@NotNull
	private Long rg;
	
	@Column(name="ath_cpf")
	@NotNull
	private Long cpf;

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
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

	public List<String> getRegions() {
		return regions;
	}

	public void setRegions(List<String> regions) {
		this.regions = regions;
	}
	
	
	
	
	

}
