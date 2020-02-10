package com.joc.jdbc.statement.dao;

import java.sql.SQLException;

/**
 * Purpose : For connection with dataBase using Statement
 * 
 * @author Nikunj Balar
 *
 */
public interface DetailsDAO {

	// function for add details into table
	public void addDetails() throws ClassNotFoundException, SQLException;

	// function for delete details base on name
	public void deletDetails() throws SQLException;

	// function for show all data from table
	public void showAllData() throws SQLException;

	// function for update details base on id
	public void update();
}
