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
import tech.yotz.start.model.resource.PartnerResource;
import tech.yotz.start.model.resource.UserTokenStateResource;
import tech.yotz.start.service.PartnerService;

@RestController
@RequestMapping(value = "/v1/partners", produces = MediaType.APPLICATION_JSON_VALUE)
public class PartnerController {
	
	@Autowired
	private PartnerService partnerService;
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 201, message = "Created", response = UserTokenStateResource.class)}) 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody final PartnerResource partnerResource, 
			final HttpServletResponse response, final Device device) throws Exception {
		
		final UserTokenStateResource userTokenStateResource = partnerService.save(partnerResource, device);
		if(userTokenStateResource == null ) {
			return new ResponseEntity<UserTokenStateResource>(HttpStatus.EXPECTATION_FAILED);
		} else {
			return new ResponseEntity<UserTokenStateResource>(userTokenStateResource, HttpStatus.CREATED);
		}
	}

}