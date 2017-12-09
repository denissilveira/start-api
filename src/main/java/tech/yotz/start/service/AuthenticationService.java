package tech.yotz.start.service;

import org.springframework.mobile.device.Device;

import tech.yotz.start.model.resource.UserTokenStateResource;

public interface AuthenticationService {
	
	UserTokenStateResource authenticate(final String username, final String password, final Device device) throws Exception;

}