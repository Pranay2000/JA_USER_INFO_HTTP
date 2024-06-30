package com.assignment.serviceImpl;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private Properties userProperties;

	@Override
	public String getWorkstation(String username) {
		return userProperties.getProperty(username);
	}

	@Override
	public boolean userExists(String username) {
		return userProperties.containsKey(username);
	}
}