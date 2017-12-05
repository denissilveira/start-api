package tech.yotz.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import tech.yotz.start.auth.TokenHelper;
import tech.yotz.start.model.entity.User;
import tech.yotz.start.model.mapper.UserMapper;
import tech.yotz.start.model.resource.UserResource;
import tech.yotz.start.model.resource.UserTokenStateResource;
import tech.yotz.start.service.AuthenticationService;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private TokenHelper tokenHelper;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public UserTokenStateResource authenticate(final String username, final String password, final Device device) {
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		User user = (User) authentication.getPrincipal();
		UserResource userResource = UserMapper.parse(user);
		String jws = tokenHelper.generateToken(user.getUsername(), device);
		int expiresIn = tokenHelper.getExpiredIn(device);
		return new UserTokenStateResource(jws, expiresIn, userResource);
	}

}
