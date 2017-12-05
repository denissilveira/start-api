package tech.yotz.start.web.service.v1;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tech.yotz.start.model.resource.StartupResource;
import tech.yotz.start.model.resource.UserTokenStateResource;
import tech.yotz.start.service.StartupService;

@RestController
@RequestMapping(value = "/v1/startups", produces = MediaType.APPLICATION_JSON_VALUE)
public class StartupController {

	
	@Autowired
	private StartupService startupService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody final StartupResource startupResource, 
			final HttpServletResponse response, final Device device) throws Exception {
		final UserTokenStateResource userTokenStateResource = startupService.save(startupResource, device);
		return ResponseEntity.ok(userTokenStateResource);
	}
	
}