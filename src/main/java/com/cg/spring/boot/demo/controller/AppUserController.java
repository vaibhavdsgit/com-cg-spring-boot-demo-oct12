package com.cg.spring.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.service.AppUserService;

@RestController
public class AppUserController {

	private static final Logger LOG = LoggerFactory.getLogger(AppUserController.class);
	
	@Autowired
	private AppUserService appUserService;
	
	
	@PostMapping("/register")
	public ResponseEntity<AppUser> register(@RequestBody AppUser appUser){
		LOG.info("Registering user");
		AppUser au = appUserService.register(appUser);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The user is added to the database");
		ResponseEntity<AppUser> response = new ResponseEntity<AppUser>(au, headers, HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/login")
	public ResponseEntity<AppUser> login(@RequestBody AppUser appUser){
		LOG.info("Logging user");
		AppUser au = appUserService.login(appUser);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Login successful");
		ResponseEntity<AppUser> response = new ResponseEntity<AppUser>(au, headers, HttpStatus.OK);
		return response;
	}
	
//	@PostMapping("/addemp")
//	public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
//		LOG.info("Controller addEmp");
//		Employee emp = empService.addEmployee(employee);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "The employee is added to the database");
//		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
//		return response;
//	}
	
	
	
	
	
}
