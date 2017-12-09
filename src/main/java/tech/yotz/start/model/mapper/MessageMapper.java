package tech.yotz.start.model.mapper;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import tech.yotz.start.model.entity.Chat;
import tech.yotz.start.model.entity.Message;
import tech.yotz.start.model.resource.MessageResource;
import tech.yotz.start.repository.ChatRepository;

@Component
public class MessageMapper {
	
	private ChatRepository chatRepository;
	
	public final List<Message> parseList(final List<MessageResource> resources) {
		if(CollectionUtils.isEmpty(resources))
			return null;
		return resources.stream().map(resource -> {
			return parse(resource);
		}).collect(Collectors.toList());
	}
	
	public final List<MessageResource> parseResources(final List<Message> messages) {
		if(CollectionUtils.isEmpty(messages))
			return null;
		return messages.stream().map(message -> {
			return parse(message);
		}).collect(Collectors.toList());
	}
	
	public final List<Message> parseList(final List<MessageResource> resources, final Chat chat) {
		if(CollectionUtils.isEmpty(resources))
			return null;
		return resources.stream().map(resource -> {
			return parse(resource, chat);
		}).collect(Collectors.toList());
	}
	
	public final List<MessageResource> parseResources(final List<Message> messages, final Chat chat) {
		if(CollectionUtils.isEmpty(messages))
			return null;
		return messages.stream().map(message -> {
			return parse(message, chat);
		}).collect(Collectors.toList());
	}
	
	public final Message parse(final MessageResource messageResource) {
		if (messageResource == null)
			return null;
		final Message message = new Message();
		message.setChat(chatRepository.findOne(messageResource.getChatId()));
		message.setMessage(messageResource.getMessage());
		message.setDate(messageResource.getDate());
		message.setSenderMessage(messageResource.getSenderMessage());
		return message;
	}
	
	public final MessageResource parse(final Message message) {
		if (message == null) 
			return null;
		final MessageResource messageResource = new MessageResource();
		messageResource.setChatId(message.getChat().getId());
		messageResource.setMessage(message.getMessage());
		messageResource.setDate(message.getDate());
		messageResource.setSenderMessage(message.getSenderMessage());
		return messageResource;
	}
	
	public final Message parse(final MessageResource messageResource, final Chat chat) {
		if (messageResource == null)
			return null;
		final Message message = new Message();
		message.setChat(chat);
		message.setMessage(messageResource.getMessage());
		message.setDate(new Date());
		message.setSenderMessage(messageResource.getSenderMessage());
		return message;
	}
	
	public final MessageResource parse(final Message message, final Chat chat) {
		if (message == null) 
			return null;
		final MessageResource messageResource = new MessageResource();
		messageResource.setChatId(chat.getId());
		messageResource.setMessage(message.getMessage());
		messageResource.setDate(message.getDate());
		messageResource.setSenderMessage(message.getSenderMessage());
		return messageResource;
	}
}