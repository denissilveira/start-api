package tech.yotz.start.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tech.yotz.start.exceptions.RegistredUserException;
import tech.yotz.start.model.entity.User;
import tech.yotz.start.model.enums.RolesEnum;
import tech.yotz.start.model.mapper.UserMapper;
import tech.yotz.start.model.resource.UserResource;
import tech.yotz.start.repository.UserRepository;
import tech.yotz.start.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
    private UserDetailsService userDetailsService;
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByUsername(email);
	}

	@Override
	public UserResource registration(final UserResource userModel) throws RegistredUserException, Exception {
		
		try {
			
			userModel.setActive(true);
			userModel.setCreated(new Date());
			userModel.setLastPasswordResetDate(new Date());
			userModel.setRoles(Collections.singletonList(RolesEnum.USER.name()));
			userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
			final User user = userRepository.save(UserMapper.parse(userModel));
			if(user == null)
				throw new Exception("Erro ao cadastrar usuario");
			
			return UserMapper.parse(user);
		} catch(Exception e) {
			throw new Exception(e);
		}
	}

	@Override
    public void autologin(final String username, final String password) {
		
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }
	
	@Override
	public void changePassword(String oldPassword, String newPassword) {

		final Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		final String username = currentUser.getName();

		if (authenticationManager != null) {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
		} else {
			return;
		}

		final User user = (User) loadUserByUsername(username);
		user.setLastPasswordResetDate(new Date());
		user.setPassword(bCryptPasswordEncoder.encode(newPassword));
		userRepository.save(user);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	public UserResource findByUsernameAndRoles(final String username, final List<String> roles) {
		return UserMapper.parse(userRepository.findByUsernameAndRoles(username, roles));
	}
}