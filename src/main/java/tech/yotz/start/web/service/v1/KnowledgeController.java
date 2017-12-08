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
import tech.yotz.start.model.resource.KnowledgeResource;
import tech.yotz.start.service.KnowledgeService;

@RestController
@RequestMapping(value = "/v1/knowledges", produces = MediaType.APPLICATION_JSON_VALUE)
public class KnowledgeController {
	
	@Autowired
	private KnowledgeService service;
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 200, message = "OK", response = KnowledgeResource.class)}) 
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<KnowledgeResource>> findAll() {
		
		try {
			final List<KnowledgeResource> knowledges = service.findAll();
			return new ResponseEntity<List<KnowledgeResource>>(knowledges, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<KnowledgeResource>>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}