package com.joc.jdbc.callableStatement.dao;

import java.sql.SQLException;

/**
 * Purpose : For connection with dataBase using prepareStatement
 * 
 * @author Nikunj Balar
 *
 */
public interface DetailsDAO {

	// function for add details into table
	public void addDetails() throws ClassNotFoundException, SQLException;

	// function for delete details base on name
	public void deletById() throws SQLException;

	// function for show all data from table
	public void showAllData() throws SQLException;
	
	// function to get data by id 
	public void getById() throws SQLException ;

	// function for update details base on id
	public void update() throws SQLException;
}
