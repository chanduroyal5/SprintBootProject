package com.olive.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.olive.springboot.entity.Mandates;
import com.olive.springboot.service.EmployeeService;
import com.olive.springboot.vo.EmployeeVo;
import com.olive.springboot.vo.Result;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/test")
	public String test() {
		return "Working.....";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody EmployeeVo emp) {
		return employeeService.saveEmployee(emp);
	}
	
	@PostMapping("/searchEmployee/{txnid}/{id}")
	public DeferredResult<Result<Object>> getEmployee(@PathVariable("id") int id, @PathVariable("txnid") String txn) {
		System.out.println("calling :: /searchEmployee/{id}  - {}  "+ txn);
		
		Result<Object> timeout = new Result<Object>();
		timeout.setCode("91");
		timeout.setResult("TIMEOUT");

		DeferredResult<Result<Object>> dr = new DeferredResult<Result<Object>>(100l, timeout);
		employeeService.getEmployeeById(dr, id);
		return dr;
	}
	
	@PostMapping("/mandates/{mobile}")
	public List<Mandates> getMandates(@PathVariable("mobile") String mobile){
		System.out.println("calling :: /mandates/{mobile} :: {} " + mobile);
		return employeeService.getMandatesByDate(mobile);
	}
	
	@PostMapping("/saveMandates")
	public String saveMandate() {
		return "STORED SUCCESSFULLY >>>>>>> ID ::{} " + employeeService.saveMandate();
	}
	@PostMapping("/limitcheck/{mobile}/{amount}")
	public String getLimitCheck(@PathVariable("mobile") String mobile, @PathVariable("amount") String amount) {
		return employeeService.getLimitCheck(mobile, amount);
	}
	
}
