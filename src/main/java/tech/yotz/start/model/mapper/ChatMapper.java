package tech.yotz.start.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import tech.yotz.start.model.entity.Chat;
import tech.yotz.start.model.resource.ChatResource;
import tech.yotz.start.service.MessageService;

@Component
public class ChatMapper {
	
	@Autowired
	private MessageService messageService;
	
	public final List<Chat> parseList(final List<ChatResource> resources) {
		
		if(CollectionUtils.isEmpty(resources))
			return null;
		
		return resources.stream().map(resource -> {
			return parse(resource);
		}).collect(Collectors.toList());
	}
	
	public final List<ChatResource> parseResources(final List<Chat> countries) {
		
		if(CollectionUtils.isEmpty(countries))
			return null;
		
		return countries.stream().map(country -> {
			return parse(country);
		}).collect(Collectors.toList());
	}
	
	
	public final Chat parse(final ChatResource chatResource) {
		
		if (chatResource == null) 
			return null;
		final Chat chat = new Chat();
		chat.setId(chatResource.getId());
		chat.setStartup(chatResource.getStartup());
		chat.setPartner(chatResource.getPartner());
		chat.setProject(chatResource.getProject());
		return chat;
	}
	
	public final ChatResource parse(final Chat chat) {
		if (chat == null) 
			return null;
		final ChatResource chatResource = new ChatResource();
		chatResource.setId(chat.getId());
		chatResource.setStartup(chat.getStartup());
		chatResource.setPartner(chat.getPartner());
		chatResource.setProject(chat.getProject());
		chatResource.setMessages(messageService.findByChat(chat));
		return chatResource;
	}
}