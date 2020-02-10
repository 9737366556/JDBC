package com.joc.jdbc.preperedstatement.dto;


/**
 * Purpose : For Data transfer base on properties Map with the dataBase
 *  
 * @author Nikunj balar
 *
 */
public class DetailsDTO {

	private int id;
	private String fullName;
	private String state;
	private long number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "id=" + id + ", fullName=" + fullName + ", state=" + state + ", number=" + number ;
	}

}