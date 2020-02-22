package com.joc.jdbc.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Utilities {

	static Scanner s = new Scanner(System.in);

	// method for reading standerd input of type short
	public static short shortInput() throws NumberFormatException {
		return s.nextShort();// method for tasking short input from user
	}

	// method for reading standerd input of type integer
	public static int integerInput() throws NumberFormatException {
		return s.nextInt();// method for tasking integer input from user
	}

	// method for reading standerd input of type float
	public static float floatInput() throws NumberFormatException {
		return s.nextFloat();// method for taking float input from user
	}

	// method for reading standerd input of type double
	public static double doubleInput() throws NumberFormatException {
		return s.nextDouble();// method for taking double input from user
	}

	// method for reading standerd input of type boolean
	public static boolean booleanInput() throws NumberFormatException {
		return s.nextBoolean();// method for taking boolean input from user
	}

	// method for reading standerd input of type String
	public static String stringInput() throws NumberFormatException {
		return s.next();// method for taking String input from user
	}

	// method for reading standerd input of type character
	public static char characterInput() throws NumberFormatException {
		return s.next().charAt(0); // method for taking character input from user
	}
	
	// method for reading standerd input of type Long
	public static Long longInput() throws NumberFormatException {
			return s.nextLong(); // method for taking Long input from user
		}
	
	// function for connection with dataBase
	// return connection object
	public static Connection getConnection() {
		Connection con = null;
		try {
			// load and register driver
			Class.forName("com.mysql.jdbc.Driver");
			// Establishing connection with dataBAse
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nikunj?user=root&password=password");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

}
