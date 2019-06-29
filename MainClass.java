package com.employ.jdbc;

import java.io.BufferedReader;
import java.util.*;
import java.io.InputStreamReader;

import com.employee.jdbc.controller.employeedetails;

public class MainClass {
		
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
	 
			employeedetails employeeController = new employeedetails();
			int choice, choice1;
			boolean choice0 = true;
			Scanner sc=new Scanner(System.in);
			while (choice0) {
				System.out.println("Choose Operation : \n 1. Add an Employee \n 2. Get an Employee" + "\n 3. Exit");
				System.out.println("Select a option");
				choice=sc.nextInt();
				switch (choice) {
				case 1:
					employeeController.create();
					break;
				case 2:
					employeeController.get();
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid input");
				}
				System.out.println("Do you still wanna operate? Press 0 to exit.");
				choice1=sc.nextInt();
				choice0 = choice1==0 ? false : true ; 
			}
		}

}
