package tech.yotz.start.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import tech.yotz.start.model.entity.Message;
import tech.yotz.start.model.resource.MessageResource;

public class MessageMapper {
	
	public static final List<Message> parseList(final List<MessageResource> resources) {
		if(CollectionUtils.isEmpty(resources))
			return null;
		return resources.stream().map(resource -> {
			return parse(resource);
		}).collect(Collectors.toList());
	}
	
	public static final List<MessageResource> parseResources(final List<Message> messages) {
		if(CollectionUtils.isEmpty(messages))
			return null;
		return messages.stream().map(message -> {
			return parse(message);
		}).collect(Collectors.toList());
	}
	
	public final static Message parse(final MessageResource messageResource) {
		if (messageResource == null)
			return null;
		final Message message = new Message();
		message.setId(messageResource.getId());
		message.setMessage(messageResource.getMessage());
		message.setDate(messageResource.getDate());
		return message;
	}
	
	public final static MessageResource parse(final Message message) {
		if (message == null) 
			return null;
		final MessageResource messageResource = new MessageResource();
		messageResource.setId(message.getId());
		messageResource.setMessage(message.getMessage());
		messageResource.setDate(message.getDate());
		return messageResource;
	}
}