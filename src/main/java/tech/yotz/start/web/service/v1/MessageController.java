package tech.yotz.start.web.service.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.yotz.start.model.resource.MessageResource;
import tech.yotz.start.service.MessageService;

@RestController
@RequestMapping(value = "/v1/messages", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {
	
	@Autowired
	private MessageService service;
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 201, message = "Created")}) 
	@RequestMapping(path="/chat/{chat}", method = RequestMethod.POST)
	public ResponseEntity<?> saveMessage(@PathVariable final String chat,@RequestBody final MessageResource messageResource) {
		try {
			service.save(chat, messageResource);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
}