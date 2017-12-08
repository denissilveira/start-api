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
import tech.yotz.start.model.resource.CityResource;
import tech.yotz.start.service.CityService;

@RestController
@RequestMapping(value = "/v1/cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {
	
	@Autowired
	private CityService service;
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 200, message = "OK", response = CityResource.class)}) 
	@RequestMapping(path="/state/{state}", method = RequestMethod.GET)
	public ResponseEntity<List<CityResource>> findAll(@PathVariable final String state) {
		
		try {
			final List<CityResource> cities = service.findByState(state);
			return new ResponseEntity<List<CityResource>>(cities, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<CityResource>>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}