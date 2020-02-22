package com.joc.jdbc.statement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.joc.jdbc.statement.dto.DetailsDTO;
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

	// function for add details into table
	public void addDetails() {
		Statement stm = null;
		try {
			System.out.println("Enter full name");
			dto.setFullName(Utilities.stringInput());
			System.out.println("Enter state Name");
			dto.setState(Utilities.stringInput());
			System.out.println("Enter Mobile Number");
			dto.setNumber(Utilities.longInput());

			// using function Statement of connection for execute qurey
			// query for insert data into table
			stm = con.createStatement();
			int n = stm.executeUpdate("insert into details values (d_id = 1,'" + dto.getFullName() + "' ,'"
					+ dto.getState() + "'," + dto.getNumber() + ")");
			System.out.println("data added sucees fully " + n);
			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stm != null)
				try {
					// closing costly resources
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	// function for show all data from table
	public void showAllData() {
		Statement stm = null;
		try {
			// creating statement object
			stm = con.createStatement();
			// query for show table
			ResultSet rs = stm.executeQuery("select * from details");
			// showing row one by one
			while (rs.next()) {
				System.out.println("id =" + rs.getString(1) + "\t name=" + rs.getString(2) + "\t state="
						+ rs.getString(3) + "\t number=" + rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stm != null)
				try {
					// closing costly resources
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	// function for delete details base on name
	public void deletDetails() {
		Statement stm = null;
		try {
			stm = con.createStatement();
			System.out.println("Enter name that you want to delet");
			String name = Utilities.stringInput();
			// query for delete details base on fullName
			int n = stm.executeUpdate("delete from details where fullName='" + name + "'");
			if (n > 0)
				System.out.println("details deleted suceessfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stm != null)
				try {
					// closing costly resources
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

// function for update details base on id
	public void update() {
		Statement stm = null;
		try {
			stm = con.createStatement();
			System.out.println("Enter id that you want to update");
			int id = Utilities.integerInput();
			System.out.println("Enter name ");
			String name = Utilities.stringInput();
			System.out.println("Enter state");
			String state = Utilities.stringInput();
			System.out.println("Enter number ");
			long number = Utilities.longInput();
			// query for update detailse base on id
			stm.executeUpdate("update details set fullName='" + name + "',state='" + state + "',number=" + number
					+ " where d_id =" + id);
			System.out.println("data update sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stm != null)
				try {
					// closing costly resources
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
