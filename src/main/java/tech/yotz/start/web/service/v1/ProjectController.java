package tech.yotz.start.web.service.v1;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.yotz.start.model.resource.ProjectResource;
import tech.yotz.start.service.ProjectService;

@RestController
@RequestMapping(value = "/v1/project", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 201, message = "OK", response = ProjectResource.class)}) 
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findById(@RequestParam final String id, final HttpServletResponse response) {
		try {
			ProjectResource project = projectService.findById(id);
			return new ResponseEntity<>(project, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 201, message = "Created", response = ProjectResource.class)}) 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody final ProjectResource projectResource, final HttpServletResponse response) {
		try {
			ProjectResource project = projectService.save(projectResource);
			return new ResponseEntity<>(project, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 201, message = "OK", response = ProjectResource.class)}) 
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final ProjectResource projectResource, final HttpServletResponse response) {
		try {
			ProjectResource project = projectService.update(projectResource);
			return new ResponseEntity<>(project, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 201, message = "OK")}) 
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> update(@RequestParam final String id, final HttpServletResponse response) {
		try {
			projectService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
