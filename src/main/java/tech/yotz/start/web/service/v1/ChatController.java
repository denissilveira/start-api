package tech.yotz.start.web.service.v1;

import java.util.List;

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
import tech.yotz.start.model.resource.ChatResource;
import tech.yotz.start.service.ChatService;

@RestController
@RequestMapping(value = "/v1/chats", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChatController {
	
	@Autowired
	private ChatService service;
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 201, message = "Created")}) 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ChatResource> save(@RequestBody final ChatResource chatResource) {
		
		try {
			final ChatResource chat = service.save(chatResource);
			return new ResponseEntity<ChatResource>(chat, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<ChatResource>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 200, message = "OK", response = ChatResource.class)}) 
	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public ResponseEntity<ChatResource> findById(@PathVariable final String id) {
		
		try {
			final ChatResource chat = service.findById(id);
			return new ResponseEntity<ChatResource>(chat, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ChatResource>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 200, message = "OK", response = ChatResource.class)}) 
	@RequestMapping(path="/partner/{partner}", method = RequestMethod.GET)
	public ResponseEntity<List<ChatResource>> findByPartner(@PathVariable final String partner) {
		
		try {
			final List<ChatResource> chats = service.findByPartner(partner);
			return new ResponseEntity<List<ChatResource>>(chats, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<List<ChatResource>>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 200, message = "OK", response = ChatResource.class)}) 
	@RequestMapping(path="/project/{project}", method = RequestMethod.GET)
	public ResponseEntity<List<ChatResource>> findByProject(@PathVariable final String project) {
		
		try {
			final List<ChatResource> chats = service.findByProject(project);
			return new ResponseEntity<List<ChatResource>>(chats, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<List<ChatResource>>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@ApiResponses(value = { 
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 200, message = "OK", response = ChatResource.class)}) 
	@RequestMapping(path="/startup/{startup}", method = RequestMethod.GET)
	public ResponseEntity<List<ChatResource>> findByStartup(@PathVariable final String startup) {
		
		try {
			final List<ChatResource> chats = service.findByStartup(startup);
			return new ResponseEntity<List<ChatResource>>(chats, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<List<ChatResource>>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}