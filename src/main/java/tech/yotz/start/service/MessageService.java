package tech.yotz.start.service;

import java.util.List;

import tech.yotz.start.model.entity.Chat;
import tech.yotz.start.model.resource.MessageResource;

public interface MessageService {
	
	List<MessageResource> findByChat(final Chat chat);
	
	void save(final String chat, final MessageResource messageResource) throws Exception;
	
	List<MessageResource> save(final List<MessageResource> messages) throws Exception;
	
	List<MessageResource> save(final List<MessageResource> messages, final Chat chat) throws Exception;
}