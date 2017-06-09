package com.safee.service;

import java.sql.Date;

import com.safee.implementations.DepartmentDao;
import com.safee.implementations.EmployeeDao;
import com.safee.implementations.SalariesDao;
import com.safee.servicesBeans.EmployeeInformations;

public class EmployeeServices {

	private DepartmentDao departmentDao = new DepartmentDao();
	private EmployeeDao employeeDao = new EmployeeDao();
	private SalariesDao salariesDao = new SalariesDao();

	public EmployeeInformations getEmployeeInformation(int empID)
	{
		
		EmployeeInformations employeeInformations= new EmployeeInformations();
		/*employeeInformations.setEmpName(employeeDao.getEmployee(empID).getFirstName()+" "+employeeDao.getEmployee(empID).getLastName());
		employeeInformations.setEmpNo(employeeDao.getEmployee(empID).getEmployeeNo());
		employeeInformations.setJoinDate(employeeDao.getEmployee(empID).getHireDate());
		employeeInformations.setDeptartmentName(departmentDao.getDepartment(empID).getDepName());
		employeeInformations.setSalary(salariesDao.getSalaries(empID).getSalary());*/
		employeeInformations.setEmpName("Bala Shubramanaiam");
		employeeInformations.setEmpNo(empID);
		employeeInformations.setJoinDate(new Date(654629849));
		employeeInformations.setDeptartmentName("Sales");
		employeeInformations.setSalary(68000);
	
		return employeeInformations;
	}
}
