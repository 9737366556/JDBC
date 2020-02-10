package com.joc.jdbc.statement.controller;

import com.joc.jdbc.statement.dao.DetailsDAO;
import com.joc.jdbc.statement.dao.DetailsDAOImpl;
import com.joc.jdbc.utility.Utilities;

/**
 * Purpose : To do CRUD operation with database using Statement
 * 
 * @author Nikunj balar
 *
 */
public class TesterClass {
	public static void main(String[] args) {
		try {
			DetailsDAO dao = new DetailsDAOImpl();
			System.out.println("Crude using Statement");
			int choise = 0;
			do {
				System.out.println("Enter choise from following ");
				System.out.println("1.addDetails \t2.showTable \t3.deletDetails \t4.updateDetails");
				choise = Utilities.integerInput();
				if (choise < 5 & choise > 0) {
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
						// function for delete details base on name
						dao.deletDetails();
						break;
					case 4:
						// function for update details base on id
						dao.update();
						break;
					}

				} else
					System.out.println("enter valid chose");
			} while (choise < 5 && choise > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
