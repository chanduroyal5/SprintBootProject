package com.olive.springboot.builder;

import com.olive.springboot.entity.Employee;
import com.olive.springboot.vo.EmployeeVo;

public class EmployeeBuilder {
	
	Employee emp = null;
	EmployeeVo empVo = null;
	
	public static EmployeeBuilder create() {
		return new EmployeeBuilder();
	}
	
	public Employee convertToEmployee(EmployeeVo vo) {
		this.emp = new Employee();
		this.emp.setAddress(vo.getAddress());
		this.emp.setName(vo.getName());
		this.emp.setAge(vo.getAge());
		this.emp.setDesignation(vo.getDesignation());
		this.emp.setMobile(vo.getMobile());
		this.emp.setOfficeLocation(vo.getOfficeLocation());
		this.emp.setOfficeName(vo.getOfficeName());
		return this.emp;
	}
	
	public EmployeeVo convertToEmployeeVo(Employee emp) {
		this.empVo = new EmployeeVo();
		this.empVo.setAddress(emp.getAddress());
		this.empVo.setName(emp.getName());
		this.empVo.setAge(emp.getAge());
		this.empVo.setDesignation(emp.getDesignation());
		this.empVo.setMobile(emp.getMobile());
		this.empVo.setOfficeLocation(emp.getOfficeLocation());
		this.empVo.setOfficeName(emp.getOfficeName());
		return this.empVo;
	}
	
}
