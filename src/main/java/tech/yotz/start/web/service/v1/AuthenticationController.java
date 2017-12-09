package tech.yotz.start.web.service.v1;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.yotz.start.auth.TokenHelper;
import tech.yotz.start.model.resource.AuthenticationResource;
import tech.yotz.start.model.resource.PasswordChangerResource;
import tech.yotz.start.model.resource.UserTokenStateResource;
import tech.yotz.start.provider.DeviceProvider;
import tech.yotz.start.service.AuthenticationService;
import tech.yotz.start.service.UserService;

@RestController
@RequestMapping(value = "/v1/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeviceProvider deviceProvider;
	@Autowired
	private TokenHelper tokenHelper;

	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 202, message = "Accepted", response = UserTokenStateResource.class)}) 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody final AuthenticationResource authenticationRequest,
			final Device device) {
		
		try {
			final UserTokenStateResource userTokenStateResource = authenticationService.authenticate(
					authenticationRequest.getUsername(), authenticationRequest.getPassword(), device);
			if(userTokenStateResource == null ) {
				return new ResponseEntity<UserTokenStateResource>(HttpStatus.EXPECTATION_FAILED);
			} else {
				return new ResponseEntity<UserTokenStateResource>(userTokenStateResource, HttpStatus.ACCEPTED);
			}
		} catch (BadCredentialsException | InternalAuthenticationServiceException e) {
			return new ResponseEntity<UserTokenStateResource>(HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			return new ResponseEntity<UserTokenStateResource>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 202, message = "Accepted", response = UserTokenStateResource.class)}) 
	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public ResponseEntity<UserTokenStateResource> refreshAuthenticationToken(final HttpServletRequest request, final Principal principal) {

		String authToken = tokenHelper.getToken(request);
		Device device = deviceProvider.getCurrentDevice(request);

		if (authToken != null && principal != null) {
			String refreshedToken = tokenHelper.refreshToken(authToken, device);
			int expiresIn = tokenHelper.getExpiredIn(device);
			return new ResponseEntity<UserTokenStateResource>(new UserTokenStateResource(refreshedToken, expiresIn, null), HttpStatus.ACCEPTED);
		} else {
			UserTokenStateResource userTokenState = new UserTokenStateResource();
			return new ResponseEntity<UserTokenStateResource>(userTokenState, HttpStatus.ACCEPTED);
		}
	}

	@ApiResponses(value = { 
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 202, message = "Accepted", response = UserTokenStateResource.class)}) 
	@RequestMapping(value = "/change/password", method = RequestMethod.POST)
	public ResponseEntity<?> changePassword(@RequestBody final PasswordChangerResource passwordChanger) {
		userService.changePassword(passwordChanger.getOldPassword(), passwordChanger.getNewPassword());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
