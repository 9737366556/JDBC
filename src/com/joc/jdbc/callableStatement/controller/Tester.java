package com.joc.jdbc.callableStatement.controller;


import com.joc.jdbc.callableStatement.dao.DetailsDAO;
import com.joc.jdbc.callableStatement.dao.DetailsDAOImpl;
import com.joc.jdbc.utility.Utilities;

public class Tester {
	public static void main(String[] args) {
try {
			
			DetailsDAO dao = new DetailsDAOImpl();
			System.out.println("Crude using callableStatement");
			int choise = 0;
			do {
				System.out.println("Enter choise from following  ");
				System.out.println("1.addDetails \t2.showTable \t3.getById \t4.deletDetails \t5.updateDetails ");
				choise = Utilities.integerInput();
				if (choise < 6 & choise > 0) {
					switch (choise) {
					case 1:
						// function for add details into table
						dao.addDetails();	
						break;
					case 2:
						// function for show all data from table
						dao.showAllData();
						break;
					case 3:
						// function for get data by id 
						dao.getById();
						break;
						
					case 4:
						// function for delete details base on name
						dao.deletById();
						break;
						
					case 5 :
						// function for update details base on id
						dao.update();
						break;
					}
				} else
					System.out.println("enter valid chose");
			} while (choise < 6 && choise > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
