package tech.yotz.start.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import tech.yotz.start.model.resource.UserResource;

public interface UserService extends UserDetailsService {
	
	UserResource registration(final UserResource userModel) throws Exception;
	
	void autologin(final String username, final String password);
	
	void changePassword(final String oldPassword, final String newPassword);
	
}
