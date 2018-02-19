package org.techforumist.jwt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_machine")
public class Machine implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
    
    @NotNull
    @Column(name="machi_description")
    private String description;
    
    @NotNull
    @Column(name="machi_year")
    private int yearMachine;
    
    @NotNull
    @Column(name="machi_board")
    private String board;

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

	public int getYearMachine() {
		return yearMachine;
	}

	public void setYearMachine(int yearMachine) {
		this.yearMachine = yearMachine;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    

}
