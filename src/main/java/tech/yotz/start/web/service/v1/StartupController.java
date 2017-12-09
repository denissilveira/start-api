package tech.yotz.start.web.service.v1;

import java.util.List;

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
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 201, message = "Created", response = UserTokenStateResource.class)}) 
	@RequestMapping(path="/register", method = RequestMethod.POST)
	public ResponseEntity<UserTokenStateResource> register(@RequestBody final StartupResource startupResource, 
			final HttpServletResponse response, final Device device) {
		
		try {
			final UserTokenStateResource userTokenStateResource = startupService.save(startupResource, device);
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
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StartupResource>> findAll() {
		
		try {
			final List<StartupResource> startups = startupService.findAll();
			return new ResponseEntity<List<StartupResource>>(startups, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<StartupResource>>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 200, message = "OK", response = StartupResource.class)}) 
	@RequestMapping(path="/{id}",method = RequestMethod.GET)
	public ResponseEntity<StartupResource> findById(@PathVariable final String id) {
		
		try {
			final StartupResource startups = startupService.findById(id);
			return new ResponseEntity<StartupResource>(startups, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<StartupResource>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 200, message = "OK", response = StartupResource.class)}) 
	@RequestMapping(path="/user/{user}",method = RequestMethod.GET)
	public ResponseEntity<StartupResource> findByUser(@PathVariable final String user) {
		
		try {
			final StartupResource startups = startupService.findByUser(user);
			return new ResponseEntity<StartupResource>(startups, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<StartupResource>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 200, message = "OK", response = StartupResource.class)}) 
	@RequestMapping(path="/city/{city}",method = RequestMethod.GET)
	public ResponseEntity<List<StartupResource>> findByCity(@PathVariable final String city) {
		
		try {
			final List<StartupResource> startups = startupService.findByCity(city);
			return new ResponseEntity<List<StartupResource>>(startups, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<StartupResource>>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
}