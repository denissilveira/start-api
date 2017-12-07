package tech.yotz.start.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import tech.yotz.start.exceptions.RegistredUserException;
import tech.yotz.start.model.resource.UserResource;

public interface UserService extends UserDetailsService {
	
	UserResource registration(final UserResource userModel) throws RegistredUserException, Exception;
	
	void autologin(final String username, final String password);
	
	void changePassword(final String oldPassword, final String newPassword);
	
	UserResource findByUsernameAndRoles(final String username, final List<String> roles);
	
}