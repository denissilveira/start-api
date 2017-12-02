package tech.yotz.start.web.service.v1;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tech.yotz.start.auth.TokenHelper;
import tech.yotz.start.model.entity.User;
import tech.yotz.start.model.mapper.UserMapper;
import tech.yotz.start.model.resource.StartupResource;
import tech.yotz.start.model.resource.UserResource;
import tech.yotz.start.model.resource.UserTokenStateResource;
import tech.yotz.start.service.StartupService;

@RestController
@RequestMapping(value = "/v1/startups", produces = MediaType.APPLICATION_JSON_VALUE)
public class StartupController {

	
	@Autowired
	private TokenHelper tokenHelper;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private StartupService startupService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody final StartupResource startupResource, 
			final HttpServletResponse response, final Device device) throws Exception {
		
		final String pass = startupResource.getUser().getPassword();
		final StartupResource resource = startupService.save(startupResource);
		
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(resource.getUser().getUsername(), pass));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		User user = (User) authentication.getPrincipal();
		UserResource userResource = UserMapper.parse(user);
		String jws = tokenHelper.generateToken(user.getUsername(), device);
		int expiresIn = tokenHelper.getExpiredIn(device);
		return ResponseEntity.ok(new UserTokenStateResource(jws, expiresIn, userResource));
		
	}
	
}