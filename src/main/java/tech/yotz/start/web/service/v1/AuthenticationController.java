package tech.yotz.start.web.service.v1;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tech.yotz.start.auth.TokenHelper;
import tech.yotz.start.model.resource.AuthenticationResource;
import tech.yotz.start.model.resource.PasswordChangerResource;
import tech.yotz.start.model.resource.UserResource;
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody final AuthenticationResource authenticationRequest,
			final Device device) throws AuthenticationException, IOException {

		final UserTokenStateResource userTokenStateResource = authenticationService.authenticate(
				authenticationRequest.getUsername(), authenticationRequest.getPassword(), device);
		return ResponseEntity.ok(userTokenStateResource);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody final UserResource userResource, final Device device) throws Exception {

		final String pass = userResource.getPassword();
		userService.registration(userResource);

		final UserTokenStateResource userTokenStateResource = authenticationService.authenticate(
				userResource.getUsername(), pass, device);
		return ResponseEntity.ok(userTokenStateResource);
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public ResponseEntity<?> refreshAuthenticationToken(final HttpServletRequest request, final Principal principal) {

		String authToken = tokenHelper.getToken(request);
		Device device = deviceProvider.getCurrentDevice(request);

		if (authToken != null && principal != null) {
			String refreshedToken = tokenHelper.refreshToken(authToken, device);
			int expiresIn = tokenHelper.getExpiredIn(device);
			return ResponseEntity.ok(new UserTokenStateResource(refreshedToken, expiresIn, null));
		} else {
			UserTokenStateResource userTokenState = new UserTokenStateResource();
			return ResponseEntity.accepted().body(userTokenState);
		}
	}

	@RequestMapping(value = "/change/password", method = RequestMethod.POST)
	public ResponseEntity<?> changePassword(@RequestBody final PasswordChangerResource passwordChanger) {
		userService.changePassword(passwordChanger.getOldPassword(), passwordChanger.getNewPassword());
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return ResponseEntity.accepted().body(result);
	}

}
