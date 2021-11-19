package com.cg.spring.boot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.AppUserAlreadyExistsException;
import com.cg.spring.boot.demo.exception.AppUserNotFoundException;
import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.repository.AppUserRepository;

@Service
public class AppUserService {

	// please check the logic 
	
	
	private static final Logger LOG = LoggerFactory.getLogger(AppUserService.class);

	@Autowired
	AppUserRepository appUserRepository;

	public AppUser register(AppUser appUser) {
		LOG.info("register");
		if (appUserRepository.findByUserName(appUser.getUserName()) != null) {
			LOG.info("Already exist");
			throw new AppUserAlreadyExistsException("Username already exist");
		}
		return appUserRepository.save(appUser);
	}
	
//	public AppUser register(AppUser appUser) {
//		LOG.info("register");
//		if (appUserRepository.findById(appUser.getUid()).get().equals(appUser.getUid()) || appUserRepository.findById(appUser.getUid()).get() == null) {
//			throw new AppUserAlreadyExistsException();
//		}
//		return appUserRepository.save(appUser);
//		
//	}
	
	public AppUser login(AppUser appUser) {
		LOG.info("login");
		AppUser temp = appUserRepository.findByUserName(appUser.getUserName());
		System.out.println(temp);
		System.out.println(temp.getUserName());
		System.out.println(appUser.getUserName());
		System.out.println(appUser.getPassword());
		if (appUser.getUserName().equals(temp.getUserName())) {
			System.out.println("Inside first if");
			if(appUser.getPassword().equals(temp.getPassword())) {
				System.out.println("Indside second if");
				return appUserRepository.findByUserName(appUser.getUserName());
			}else {
				throw new AppUserNotFoundException("Wrong Password");
			}
		}
			
		throw new AppUserNotFoundException("User does not exist");
	}
	
	
}
