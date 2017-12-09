package tech.yotz.start.web.service.v1;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.yotz.start.model.resource.PartnerResource;
import tech.yotz.start.model.resource.StartupResource;
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
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 201, message = "Created", response = UserTokenStateResource.class)}) 
	@RequestMapping(path="/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody final PartnerResource partnerResource, 
			final HttpServletResponse response, final Device device) {
		
		try {
			final UserTokenStateResource userTokenStateResource = partnerService.save(partnerResource, device);
			if(userTokenStateResource == null ) {
				return new ResponseEntity<UserTokenStateResource>(HttpStatus.EXPECTATION_FAILED);
			} else {
				return new ResponseEntity<UserTokenStateResource>(userTokenStateResource, HttpStatus.CREATED);
			}
		} catch (DuplicateKeyException e) {
			return new ResponseEntity<UserTokenStateResource>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<UserTokenStateResource>(HttpStatus.CONFLICT);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 200, message = "OK", response = StartupResource.class)}) 
	@RequestMapping(path="/{id}",method = RequestMethod.GET)
	public ResponseEntity<PartnerResource> findById(@PathVariable final String id) {
		
		try {
			final PartnerResource partnerResource = partnerService.findById(id);
			return new ResponseEntity<PartnerResource>(partnerResource, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<PartnerResource>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 200, message = "OK", response = StartupResource.class)}) 
	@RequestMapping(path="/user/{user}",method = RequestMethod.GET)
	public ResponseEntity<PartnerResource> findByUser(@PathVariable final String user) {
		
		try {
			final PartnerResource partnerResource = partnerService.findByUser(user);
			return new ResponseEntity<PartnerResource>(partnerResource, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<PartnerResource>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}