package com.cg.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.DepartmentNotFoundException;
import com.cg.spring.boot.demo.exception.EmployeeNotFoundException;
import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.DepartmentRepository;
import com.cg.spring.boot.demo.repository.EmployeeRepository;

//@Component --> Annotation for the object class

@Service	// Sub annotation of @ComponentS
public class EmployeeService {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);
	
//	private List<Employee> empList = new ArrayList<>();
//
//	{
//		empList.add(new Employee(101, "Sonu", 10.5));
//		empList.add(new Employee(102, "Monu", 15.5));
//		empList.add(new Employee(103, "Tonu", 12.5));
//	}
	
	@Autowired
	private EmployeeRepository empRepository;
	
	@Autowired
	private DepartmentRepository depRepository;

	public List<Employee> getAllEmployees() {
		LOG.info("Service getAllEmployees");
		return empRepository.findAll();
	}

//	public Employee getEmployeeById(int eid) {
//		System.out.println("Service getEmployeeById");
//		return empRepository.findById(eid).get();
//	}
	
//	public Employee getEmployeeById(int eid) {
//		Optional<Employee> empOpt = empRepository.findById(eid);
//		if (empOpt.isPresent())
//			return empOpt.get();
//		return null;
//	}

	public Employee getEmployeeById(int eid) {
		LOG.info("getEmployeeById");
		Optional<Employee> empOpt = empRepository.findById(eid);
		if (empOpt.isPresent()) {
			LOG.info("Employee is available.");
			return empOpt.get();
		} else {
			LOG.info("Employee is NOT available.");
			throw new EmployeeNotFoundException(eid + " this employee is not found.");
		}
	}
	
//	public Employee addEmployee(Employee employee) {
//		System.out.println("Service addEmployee");
//		if (!empRepository.existsById(employee.getEid())) {
//			return empRepository.save(employee);
//		}
//		else {
//			LOG.error("Employee already exist");
//			throw new EmployeeAlreadyExists("This employee already exist in database")
//		}
//		System.out.println(employee.getEid() + " already exists.");
//		return null;
//	}
	
//	public Employee addEmployee(Employee employee) {
//		LOG.info("Service addEmployee");
//		if (!empRepository.existsById(employee.getEid())) {
//			return empRepository.save(employee);
//		}
//		else {
//			LOG.error("Employee already exist");
//			throw new EmployeeAlreadyExists("This employee already exist in database");
//		}	
//	}
	
	public Employee addEmployee(Employee employee) {
		LOG.info("Service addEmployee");
		if (depRepository.existsById(employee.getDepartment().getDid())) {
			LOG.info("emp added");
			return empRepository.save(employee);
		}
		else {
			LOG.info("dep dosent exist");
			throw new DepartmentNotFoundException(employee.getDepartment().getDid() + " this department is not found.");
		}
	}

	public Employee updateEmployee(Employee employee) {
		LOG.info("Service updateEmployee");
		if (empRepository.existsById(employee.getEid())) {
			return empRepository.save(employee);
		}
		else {
			throw new EmployeeNotFoundException("Employee does not exist");
		}
//		System.out.println(employee.getEid() + " does not exist.");
//		return null;
	}

//	public int deleteEmployeeById(int eid) {
//		System.out.println("Service deleteEmployeeById");
//		if (empRepository.existsById(eid)) {
//			empRepository.deleteById(eid);
//			return eid;
//		}
//		System.out.println(eid + " does not exist.");
//		return 0;
//	}
	public Employee deleteEmployeeById(int eid) {
		LOG.info("deleteEmployeeById");
		Optional<Employee> empOpt = empRepository.findById(eid);
		if (empOpt.isPresent()) {
			empRepository.deleteById(eid);
			return empOpt.get();
		} else {
			throw new EmployeeNotFoundException(eid + " this employee does not exist.");
		}
	}
	
	public List<Employee> getEmployeeByName(String name) {
		LOG.info("getEmployeeByName");
		return empRepository.findByName(name);
	}

	public List<Employee> getEmpBySalaryInBetween(double salary1, double salary2) {
		LOG.info("getEmployeeBySalaryInBetween");
		return empRepository.findBySalaryBetween(salary1, salary2);
	}
	
	public List<Employee> getEmployeeBySalaryGreaterThan(double salary) {
		LOG.info("getEmployeeBySalaryGreaterThan");
		return empRepository.findBySalaryGreaterThan(salary);
	}
	
	public List<Employee> getEmployeeBySalaryLessThan(double salary) {
		LOG.info("getEmployeeBySalarylessThan");
		return empRepository.findBySalaryLessThan(salary);
	}
}
