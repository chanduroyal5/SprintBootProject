package com.olive.springboot.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import com.olive.springboot.builder.EmployeeBuilder;
import com.olive.springboot.entity.Employee;
import com.olive.springboot.entity.Mandates;
import com.olive.springboot.repo.EmployeeRepository;
import com.olive.springboot.repo.MandateRepository;
import com.olive.springboot.vo.EmployeeVo;
import com.olive.springboot.vo.Result;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	MandateRepository mandateRepository;
	
	public String saveEmployee(EmployeeVo empVo) {
		Employee employee = employeeRepository.save(EmployeeBuilder.create().convertToEmployee(empVo));
		return "Successfully Onboarded Employee..... ID :: " + employee.getId();
	}
	
	public void getEmployeeById(DeferredResult<Result<Object>> dr, int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			sendResponse("00", "SUCCESS", EmployeeBuilder.create().convertToEmployeeVo(emp.get()), dr);
			return;
		}
		sendResponse("11", "NO DATA AVAILABLE", null, dr);
	}
	
	void sendResponse(String code, String desc, Object data, DeferredResult<Result<Object>> dr) {
		Result<Object> result = new Result<>();
		result.setCode(code);
		result.setResult(desc);
		result.setData(data);
		dr.setResult(result);
	}
	
	public long saveMandate() {
		Mandates m = new Mandates();
		m.createdDate = new Date();
		m.payerMobile = "917799223344";
		m.setRemitterStatus("S");
		m.setMandateType("CREATE");
		m.setPayeeCode("6211");
		m.setPurposeCode("76");
		m.setAmount("499999.00");
		return mandateRepository.save(m).getId();
	}
	
	public List<Mandates> getMandatesByDate(String payerMobile){
		System.out.println(" getMandatesByDate :: {} "+ payerMobile);
		System.out.println("payerMobile :: {} "+payerMobile +"   getStartOfTheDay() :: {} "+ getStartOfTheDay() +" new Date() :: {} " + new Date());
		String purposeCodes = "76";
		String [] sbmdPurposeCodes = purposeCodes.split("\\,");
		List<Mandates> mandates = mandateRepository.findByPayerMobileAndCreatedDateBetweenAndPurposeCodeIn(payerMobile, getStartOfTheDay(), new Date(), sbmdPurposeCodes);
		System.out.println(" mandates.size() :: {} "+ mandates.size());
		System.out.println(" mandates :: {} "+ mandates);
		return mandates;
	}
	
	public String getLimitCheck(String mobile, String amount) {
		String perDayLimit =  "150000000";
		List<Mandates> mandateList = mandateRepository.findByPayerMobileAndCreatedDateBetween(mobile, getStartOfTheDay(), new Date());
		BigDecimal bigDecimal = new BigDecimal("0");
		System.err.println(" mandateList.size() :: {} " + mandateList.size());
		for (Mandates mandates : mandateList) {
			if("S".equalsIgnoreCase(mandates.getRemitterStatus()) && "CREATE".equals(mandates.getMandateType()) && "6211".equals(mandates.getPayeeCode())) {
				bigDecimal = bigDecimal.add(new BigDecimal(mandates.getAmount()));
			}
		}
		bigDecimal = bigDecimal.add(new BigDecimal(amount));

		BigDecimal velocityAmount = new BigDecimal(convertPaisasToRs(perDayLimit));
		
		System.err.println(" velocityAmount :: {} " + velocityAmount +" bigDecimal :: {} " + bigDecimal);
		if (bigDecimal.compareTo(velocityAmount) == 1) {
			System.err.println(" MANDATES DECLINING WITH Z8");
			return "Z8";
		}
		
		return "ALLOWING.....";
	}
	
	public static String convertPaisasToRs(String paisas) {
		String displayAmount = new BigDecimal(paisas).movePointLeft(2).toPlainString();
		return displayAmount;
	}
	
	public static Date getStartOfTheDay() {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(new Date());
		startCal.set(Calendar.HOUR_OF_DAY, 0);
		startCal.set(Calendar.MINUTE, 0);
		startCal.set(Calendar.SECOND, 0);
		startCal.set(Calendar.MILLISECOND, 0);
		return startCal.getTime();
	}

	public static Date getEndOfTheDay() {
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(new Date());
		endCal.set(Calendar.HOUR_OF_DAY, 23);
		endCal.set(Calendar.MINUTE, 59);
		endCal.set(Calendar.SECOND, 59);
		endCal.set(Calendar.MILLISECOND, 999);
		return endCal.getTime();
	}
	
}
