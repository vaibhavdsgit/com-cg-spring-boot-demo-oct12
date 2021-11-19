package com.cg.spring.boot.demo.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService empService;

	// http://localhost:8082/getallemps
	@GetMapping("/getallemps")
	public List<Employee> getAllEmps() {
		LOG.info("Controller getAllEmps");
		return empService.getAllEmployees();
	}

	// http://localhost:8082/getempbyid/101
//	@GetMapping("/getempbyid/{eid}")
//	public Employee getEmpById(@PathVariable(name = "eid") int eid) {
//		System.out.println("Controller getEmpById");
//		return empService.getEmployeeById(eid);
//	}
	
	// http://localhost:8082/getempbyid/101
//	@GetMapping("/getempbyid/{eid}")
//	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
//		LOG.info("getEmpById");
//		Employee emp = empService.getEmployeeById(eid);
//		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, HttpStatus.OK);
//		return response;
//	}
	
////// returns ResponseEntity object including employee object (body)
//// http://localhost:8082/getempbyid/101
//@GetMapping("/getempbyid/{eid}")
//public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
//	LOG.info("getEmpById");
//	Employee emp = empService.getEmployeeById(eid);
//	ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, HttpStatus.OK);
//	return response;
//}
	
	// returns ResponseEntity object including employee object (body)
	// http://localhost:8082/getempbyid/101
//	@GetMapping("/getempbyid/{eid}")
//	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
//		LOG.info("getEmpById");
//		Employee emp = empService.getEmployeeById(eid);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "This employee is available in the database.");
//		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
//		return response;
//	}
	
	//http://localhost:8082/getempbyid/101
//	@GetMapping("/getempbyid/{eid}")
//	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
//		LOG.info("getEmpById");
//		Employee emp = empService.getEmployeeById(eid);
//		HttpHeaders headers = new HttpHeaders();
//		if (null != emp) {
//			headers.add("message", "This employee is available in the database.");
//			ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
//			return response;
//		}
//		else {
//			headers.add("message", "This employee is NOT available in the database.");
//			ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.NOT_FOUND);
//			return response;			
//		}
//
//	}
	
	// http://localhost:8082/getempbyid/101
	@GetMapping("/getempbyid/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
		LOG.info("getEmpById");
		Employee emp = empService.getEmployeeById(eid); // line 
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
		return response;
	}

	// http://localhost:8082/addemp
	@PostMapping("/addemp")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
		LOG.info("Controller addEmp");
		Employee emp = empService.addEmployee(employee);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The employee is added to the database");
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
		return response;
	}

//	@PostMapping("/updateemp")
//	public Employee updateEmp(@RequestBody Employee employee) {
//		LOG.info("Controller updateEmp");
//		return empService.updateEmployee(employee);
//	}
	@PostMapping("/updateemp")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee) {
		LOG.info("Controller updateEmp");
		Employee emp =  empService.updateEmployee(employee);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The employee data is updated");
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
		return response;
	}

//	@DeleteMapping("/deleteempbyid/{eid}")
//	public int deleteEmpById(@PathVariable int eid) {
//		LOG.info("Controller deleteEmpById");
//		return empService.deleteEmployeeById(eid);
//	}
	@DeleteMapping("/deleteempbyid/{eid}")
	public ResponseEntity<Employee> deleteEmpById(@PathVariable int eid) {
		LOG.info("Controller deleteEmpById");
		Employee emp = empService.deleteEmployeeById(eid);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The employee data is deleted");
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getbyname/{name}")
	public List<Employee> getEmpByFirstName(@PathVariable String name) {
		LOG.info("getEmpByName");
		return empService.getEmployeeByName(name);
	}

	@GetMapping("/getbysalbet/{salary1}/{salary2}")
	public List<Employee> getEmpBySalaryInBetween(@PathVariable double salary1,@PathVariable double salary2) {
		LOG.info("getEmployeeBySalaryInBetween");
		return empService.getEmpBySalaryInBetween(salary1, salary2);
	}
	
	@GetMapping("/getbysalgreaterthan/{salary}")
	public List<Employee> getEmployeeBySalaryGreaterThan(@PathVariable double salary) {
		LOG.info("findBySalaryGreaterThan");
		return empService.getEmployeeBySalaryGreaterThan(salary);
	}
	
	@GetMapping("/getbysallessthan/{salary}")
	public List<Employee> getEmployeeBySalaryLessThan(@PathVariable double salary) {
		LOG.info("getEmployeeBySalaryLessThan");
		return empService.getEmployeeBySalaryLessThan(salary);
	}
	
	
	
//	@GetMapping("/getEmp")
//	public Employee getEmployee() {
//		System.out.println("getEmployee");
//		return new Employee(101, "Sonu", 100);
//	}
//	
//	@GetMapping("/getAllEmp")
//	public List<Employee> getAllEmployee(){
//		List<Employee> empList = new ArrayList<>();
//		empList.add(new Employee(101, "Sonu", 100));
//		empList.add(new Employee(102, "Tonu", 200));
//		empList.add(new Employee(103, "Monu", 300));
//		
//		return empList;
//	}
//	
//	@GetMapping("/getDoubleValue")
//	public double getDoubleValue() {
//		System.out.println("Double Value");
//		return 10.67;
//	}

}
