package tech.yotz.start.web.service.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.yotz.start.model.resource.CountryResource;
import tech.yotz.start.service.CountryService;

@RestController
@RequestMapping(value = "/v1/countries", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 200, message = "OK", response = CountryResource.class)}) 
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CountryResource>> findAll() {
		
		try {
			final List<CountryResource> countries = countryService.findAll();
			return new ResponseEntity<List<CountryResource>>(countries, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<CountryResource>>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}