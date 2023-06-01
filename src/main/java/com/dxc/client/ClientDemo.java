package com.dxc.client;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import com.dxc.dao.EmployeeDao;
import com.dxc.dao.EmployeeDaoImpl;
import com.dxc.model.Employee;
public class ClientDemo {
	public static void main(String[] args)
	{
		EmployeeDao dao = new EmployeeDaoImpl();
		Scanner input = new Scanner(System.in);
		List<Integer> arr =  new ArrayList<Integer>();
		int empid = 0;
		String name;
		int age;
		int id;
		long salary;
		
		char c = 'y';
		while(c=='y' || c=='Y') {
			System.out.println("----------- OPTIONS ----------------");
			System.out.println("1. Save Employee");
			System.out.println("2. Show Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.println("Enter your choice");
			int choice = input.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Employee name ");
				name = input.next();
				System.out.println("Enter age");
				age = input.nextInt();
				System.out.println("Enter salary");
				salary = input.nextLong();
				empid = dao.saveEmployee(name, age, salary);
				arr.add(empid);
				System.out.println("Employee record added successfully");
				List<Employee> emps = dao.getEmployee();
				for(Employee e : emps) {
					System.out.println(e);
				}
				break;
			
			case 2:
				System.out.println("EMPLOYEE RECORD");
				List<Employee> emps1 = dao.getEmployee();
				for(Employee e : emps1) {
					System.out.println(e);
				}
				break;
			
			case 3:
				for(int j:arr) {
					System.out.println(j);
				}
				System.out.println("Enter the Employee ID");
				empid = input.nextInt();
				System.out.println("Enter the updated salary details");
				salary = input.nextLong();
				dao.updateEmployee(empid, salary);
				System.out.println("The record got updated successfully");
				List<Employee> emps2 = dao.getEmployee();
				for(Employee e : emps2) {
					System.out.println(e);
				}
				break;
				
			case 4:
				for(int i:arr) {
					System.out.println(i + " ");
				}
				System.out.println("Enter the Id of the employee from above which must be deleted");
				id = input.nextInt();
				dao.deleteEmployee(id);
				arr.remove(id);
				System.out.println(id+ " - Record got deleted successfully");
				List<Employee> emps3 = dao.getEmployee();
				for(Employee e : emps3) {
					System.out.println(e);
				}
				break;
				
			case 5:
				System.out.println("Exited!!!");
				break;
				
			default:
				System.out.println("Wrong option selected");
				
			}
			System.out.println("Do you want to continue?? Y/N");
			c = input.next().charAt(0);
		}
		

	}
}
