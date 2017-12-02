package tech.yotz.start.model.mapper;

import tech.yotz.start.model.entity.Message;
import tech.yotz.start.model.resource.MessageResource;

public class MessageMapper {
	public final static Message parse(final MessageResource messageResource) {
		Message message = null;
		if (messageResource != null) {
			message = new Message();
			message.setId(messageResource.getId());
			message.setMessage(messageResource.getMessage());
			message.setDate(messageResource.getDate());
		}
		return message;
	}
	
	public final static MessageResource parse(final Message message) {
		MessageResource messageResource = null;
		if (message != null) {
			messageResource = new MessageResource();
			messageResource.setId(message.getId());
			messageResource.setMessage(message.getMessage());
			messageResource.setDate(message.getDate());
		}
		return messageResource;
	}
}