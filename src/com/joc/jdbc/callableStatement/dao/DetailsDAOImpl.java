package com.joc.jdbc.callableStatement.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.joc.jdbc.callableStatement.dto.DetailsDTO;
import com.joc.jdbc.utility.Utilities;

/**
 * Purpose : For implementation of abstract method
 * 
 * @author Nikunj balar
 *
 */
public class DetailsDAOImpl implements DetailsDAO {

	// static function for getting connection
	// return connection object
	Connection con = Utilities.getConnection();
	DetailsDTO dto = new DetailsDTO();

	@Override
	// function for add details into table
	public void addDetails() throws ClassNotFoundException, SQLException {
		CallableStatement cst = null;
		try {
			System.out.println("Enter full Name");
			dto.setFullName(Utilities.stringInput());
			System.out.println("Enter state Name");
			dto.setState(Utilities.stringInput());
			System.out.println("Enter Mobile Number");
			dto.setNumber(Utilities.longInput());
			cst = con.prepareCall("call addDetails(?,?,?)");
			cst.setString(1, dto.getFullName());
			cst.setString(2, dto.getState());
			cst.setLong(3, dto.getNumber());
			cst.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cst != null)
				cst.close();
		}
	}

	@Override
	// function to delete details base on id
	public void deletById() throws SQLException {
		CallableStatement cst = null;
		try {
			System.out.println("Enter id that you want to delet");
			int id = Utilities.integerInput();
			cst = con.prepareCall("call deleteById(?)");
			cst.setInt(1, id);
			cst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(cst != null)
				cst.close();
		}
	}

	@Override
	// function to show all the data of the table  
	public void showAllData() throws SQLException {
		CallableStatement cst = null;
		try {
			cst = con.prepareCall("call showAllData()");
			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				System.out.println("id =" + rs.getString(1) + "\t name=" + rs.getString(2) + "\t state="
						+ rs.getString(3) + "\t number=" + rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cst != null)
				cst.close();
		}
	}

	@Override
	// function to get details base on on
	public void getById() throws SQLException {
		CallableStatement cst = null;
		try {
			System.out.println("Enter id that you want to get");
			int id = Utilities.integerInput();
			cst = con.prepareCall("call getById(?)");
			cst.setInt(1, id);
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				System.out.println("id =" + rs.getString(1) + "\t name=" + rs.getString(2) + "\t state="
						+ rs.getString(3) + "\t number=" + rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cst != null)
				cst.close();
		}
	}

	@Override
	// function for update details base on id
	public void update() throws SQLException {
		CallableStatement cst = null;
		try {
			System.out.println("Enter id that you want to update");
			int id = Utilities.integerInput();
			System.out.println("Enter full name ");
			String name = Utilities.stringInput();
			System.out.println("Enter state name ");
			String state = Utilities.stringInput();
			System.out.println("Enter number ");
			long number = Utilities.longInput();
			cst = con.prepareCall("call updateById(?,?,?,?)");
			cst.setInt(1, id);
			cst.setString(2,name);
			cst.setString(3, state);
			cst.setLong(4, number);
			cst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cst != null)
				cst.close();
		}
	}
}