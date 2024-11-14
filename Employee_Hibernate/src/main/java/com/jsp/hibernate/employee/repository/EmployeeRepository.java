package com.jsp.hibernate.employee.repository;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.employee.entity.Employee;



public class EmployeeRepository {
	Configuration cfg=new Configuration() .configure().addAnnotatedClass(Employee.class);

	SessionFactory sf=cfg.buildSessionFactory();


	public void add() {

		Session s=sf.openSession();
		Transaction tran=s.getTransaction();
		tran.begin();

		Employee e=new Employee();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter EmployeeeID: ");
		int id=sc.nextInt();
		e.setEmployeeId(id);

		System.out.println("Enter EmployeeName: ");
		sc.nextLine();
		String name=sc.nextLine();
		e.setEmployeeName(name);

		System.out.println("Enter EmployeeEmail: ");
//		sc.nextLine();
		String email=sc.nextLine();
		e.setEmployeeEmail(email);

		System.out.println("Enter Designation :");
		//sc.nextLine();
		String designation=sc.nextLine();
		e.setDesignation(designation);

		System.out.println("Enter Salary:");
		int salary=sc.nextInt();
		e.setSalary(salary);

		s.save(e);
		
		System.out.println("Data Inserted Successfully 😊");

		tran.commit();
		s.close();
		sf.close();

	}

	public void findById() {
		Session s=sf.openSession();
		Transaction tran=s.getTransaction();
		tran.begin();

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter EmployeeId : ");
		int id=sc.nextInt();
		
		Employee e1=s.load(Employee.class,id);
        System.out.println(e1);
        
		System.out.println("Data Displayed Successfully 😊");

		tran.commit();
		s.close();
		sf.close();

	}

	public void update() {

		Session s=sf.openSession();
		Transaction tran=s.getTransaction();
		tran.begin();

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter EmployeeId : ");
		int id=sc.nextInt();
		Employee e1=s.get(Employee.class,id);
		
		System.out.println("Enter EmployeeName : ");
		sc.nextLine();
		String name=sc.nextLine();
		e1.setEmployeeName(name);
//		s.update(e1);
		
		System.out.println("Enter EmployeeEmail ");
//		sc.nextLine();
		String Email=sc.nextLine();
		e1.setEmployeeEmail(Email);
//		s.update(e1);
		
		System.out.println("Enter Designation :");
//		sc.nextLine();
		String designation=sc.nextLine();
		e1.setDesignation(designation);
//		s.update(e1);
		
		System.out.println("Enter salary: ");
		int salary=sc.nextInt();
		e1.setSalary(salary);
		s.update(e1);
		
		System.out.println("Data Updated Successfully 😊");


		tran.commit();
		s.close();
		sf.close();

	}
	
	public void delete() {
		Session s=sf.openSession();
		Transaction tran=s.getTransaction();
		tran.begin();

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter EmployeeId : ");
		int id=sc.nextInt();
		Employee e1=s.get(Employee.class,id);
		
		System.out.println("Data Deleted Successfully 😊");
		
		s.delete(e1);
		
		tran.commit();
		s.close();
		sf.close();
	}
	
	
}
