package tech.yotz.start.web.service.v1;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.yotz.start.model.resource.StartupResource;
import tech.yotz.start.model.resource.UserTokenStateResource;
import tech.yotz.start.service.StartupService;

@RestController
@RequestMapping(value = "/v1/startups", produces = MediaType.APPLICATION_JSON_VALUE)
public class StartupController {

	
	@Autowired
	private StartupService startupService;
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 201, message = "Created", response = UserTokenStateResource.class)}) 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserTokenStateResource> register(@RequestBody final StartupResource startupResource, 
			final HttpServletResponse response, final Device device) throws Exception {
		final UserTokenStateResource userTokenStateResource = startupService.save(startupResource, device);
		if(userTokenStateResource == null ) {
			return new ResponseEntity<UserTokenStateResource>(HttpStatus.EXPECTATION_FAILED);
		} else {
			return new ResponseEntity<UserTokenStateResource>(userTokenStateResource, HttpStatus.CREATED);
		}
	}
	
}