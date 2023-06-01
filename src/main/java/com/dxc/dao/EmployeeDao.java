package com.dxc.dao;

import java.util.*;

import com.dxc.model.Employee;



public interface EmployeeDao {
	public int saveEmployee(String employeeName,int employeeAge, long employeeSalary);
	public List<Employee> getEmployee();
	public void updateEmployee(int empoyeeId, long employeeSalary);
	public void deleteEmployee(int employeeId);

}
