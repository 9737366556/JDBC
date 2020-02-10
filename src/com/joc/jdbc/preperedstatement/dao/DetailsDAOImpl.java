package com.joc.jdbc.preperedstatement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		PreparedStatement pst = null;
		try {
			System.out.println("Enter full Name");
			dto.setFullName(Utilities.stringInput());
			System.out.println("Enter state Name");
			dto.setState(Utilities.stringInput());
			System.out.println("Enter Mobile Number");
			dto.setNumber(Utilities.longInput());

			// using function prepareStatement of connection for execute qurey 
			// query for insert data into table
			pst = con.prepareStatement("insert into details values (d_id = 1,?,?,?)");
			//setting value of place holder accordingly number of placeholder
			pst.setString(1, dto.getFullName());
			pst.setString(2, dto.getState());
			pst.setLong(3, dto.getNumber());

			// for update table
			pst.executeUpdate();
			System.out.println("data added sucees fully ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					// closing costly resources
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	// function for show all data from table
	public void showAllData() {
		PreparedStatement pst = null;
		try {
			// query for show table using placeholder
			pst = con.prepareStatement("select * from details");
			ResultSet rs = pst.executeQuery();
			// showing row one by one
			while (rs.next()) {
				System.out.println("id =" + rs.getString(1) + "\t name=" + rs.getString(2) + "\t state="
						+ rs.getString(3) + "\t number=" + rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					// closing costly resources
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	// function for delete details base on name
	public void deletDetails() {
		PreparedStatement pst = null;
		try {
			//query for delete details base on fullName using placeholder
			pst = con.prepareStatement("delete from details where fullName= (?)");
			System.out.println("Enter name that you want to delet");
			//setting value of place holder accordingly number of placeholder
			pst.setString(1, Utilities.stringInput());
			int n = pst.executeUpdate();
			if (n > 0)
				System.out.println("details deleted suceessfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					// closing costly resources
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	// function for update details base on id
	public void update() {
		PreparedStatement pst = null;
		try {
			//query for update detailse base on id using placeholder
			pst = con.prepareStatement("update details set fullName= ? , state =? , number = ? where d_id = ?");
			//setting value of place holder accordingly number of placeholder
			System.out.println("Enter id that you want to update");
			pst.setInt(4, Utilities.integerInput());
			System.out.println("Enter name ");
			pst.setString(1, Utilities.stringInput());
			System.out.println("Enter state");
			pst.setString(2, Utilities.stringInput());
			System.out.println("Enter number ");
			pst.setLong(3, Utilities.longInput());
			pst.executeUpdate();
			System.out.println("data update sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					// closing costly resources
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}