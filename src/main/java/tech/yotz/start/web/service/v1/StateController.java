package tech.yotz.start.web.service.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.yotz.start.model.resource.StateResource;
import tech.yotz.start.service.StateService;

@RestController
@RequestMapping(value = "/v1/states", produces = MediaType.APPLICATION_JSON_VALUE)
public class StateController {
	
	@Autowired
	private StateService service;
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 200, message = "OK", response = StateResource.class)}) 
	@RequestMapping(path="/country/{country}", method = RequestMethod.GET)
	public ResponseEntity<List<StateResource>> findAll(@PathVariable final String country) {
		
		try {
			final List<StateResource> states = service.findByCountry(country);
			return new ResponseEntity<List<StateResource>>(states, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<StateResource>>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
