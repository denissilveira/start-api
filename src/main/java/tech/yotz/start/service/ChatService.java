package tech.yotz.start.service;

import java.util.List;

import tech.yotz.start.model.resource.ChatResource;

public interface ChatService {

	ChatResource save(final ChatResource chatResource) throws Exception;
	
	ChatResource findById(final String id);
	
	List<ChatResource> findByPartner(final String partner);
	
	List<ChatResource> findByProject(final String project);
	
	List<ChatResource> findByStartup(final String startup);
}