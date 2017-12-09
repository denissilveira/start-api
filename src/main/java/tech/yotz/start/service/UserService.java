package tech.yotz.start.service;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetailsService;

import tech.yotz.start.model.resource.UserResource;

public interface UserService extends UserDetailsService {
	
	UserResource registration(final UserResource userModel) throws DuplicateKeyException, Exception;
	
	void autologin(final String username, final String password);
	
	void changePassword(final String oldPassword, final String newPassword);
	
	UserResource findByUsernameAndRoles(final String username, final List<String> roles);
	
	UserResource findById(final String id);
	
}