package com.jdbc.hibernate.Employee_Hibernate;

import java.util.Scanner;

import com.jsp.hibernate.employee.repository.EmployeeRepository;

public class App 
{
	public static void main( String[] args )
	{       
		EmployeeRepository er=new EmployeeRepository();

		Scanner s=new Scanner(System.in);

		System.out.println(
				"\n Enter 1 for Insert The EmployyeDetails\n Enter 2 for Fetch the Details of Employee\n "
				+ "Enter 3 for Update the Employee Details\n Enter 4 for delete the Empoyee Details");
		int option=s.nextInt();

		switch(option){

		case 1:
			er.add();
			break;
		case 2:
			er.findById();
			break;
		case 3:
			er.update();
			break;
		case 4:
			er.delete();
			break;
			default:
				System.out.println("Please Enter Valid Choice 😊");
		}
	}
}
