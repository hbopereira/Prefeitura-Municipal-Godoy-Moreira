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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birth_date == null) ? 0 : birth_date.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nameFather == null) ? 0 : nameFather.hashCode());
		result = prime * result + ((nameMother == null) ? 0 : nameMother.hashCode());
		result = prime * result + ((regions == null) ? 0 : regions.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((sector == null) ? 0 : sector.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		if (birth_date == null) {
			if (other.birth_date != null)
				return false;
		} else if (!birth_date.equals(other.birth_date))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nameFather == null) {
			if (other.nameFather != null)
				return false;
		} else if (!nameFather.equals(other.nameFather))
			return false;
		if (nameMother == null) {
			if (other.nameMother != null)
				return false;
		} else if (!nameMother.equals(other.nameMother))
			return false;
		if (regions == null) {
			if (other.regions != null)
				return false;
		} else if (!regions.equals(other.regions))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (sector != other.sector)
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}
    
	
	

}
