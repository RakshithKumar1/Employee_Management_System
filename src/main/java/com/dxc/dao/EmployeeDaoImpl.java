package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;

import com.dxc.model.Employee;
import com.dxc.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public int saveEmployee(String employeeName, int employeeAge, long employeeSalary) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setEmployeeName(employeeName);
		emp.setEmployeeAge(employeeAge);
		emp.setEmployeeSalary(employeeSalary);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int employeeId = (Integer) session.save(emp);
		session.getTransaction().commit();
		session.close();
		return employeeId;
		
	}

	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Employee> emps = (List<Employee>)session.createQuery("FROM Employee e ORDER BY e.employeeName ASC").list();
		session.getTransaction().commit();
		session.close();
		return emps;
	}

	public void updateEmployee(int employeeId, long employeeSalary) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee emp = (Employee)session.get(Employee.class, employeeId);
		emp.setEmployeeSalary(employeeSalary);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee emp = (Employee)session.get(Employee.class,employeeId);
		session.delete(emp);
		session.getTransaction().commit();
		session.close();
		
	}

}
