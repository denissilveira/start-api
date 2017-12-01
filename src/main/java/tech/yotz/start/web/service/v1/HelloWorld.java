package tech.yotz.start.web.service.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("HelloWorldV1")
@RequestMapping("/v1/hello")
public class HelloWorld {
	
	
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "Unauthorized")}) 
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> list() {
		return new ResponseEntity<String>("Helo World!", HttpStatus.OK);
	}

}
