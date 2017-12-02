package tech.yotz.start.model.mapper;

import java.util.ArrayList;

import tech.yotz.start.model.entity.Chat;
import tech.yotz.start.model.resource.ChatResource;
import tech.yotz.start.model.resource.MessageResource;

public class ChatMapper {
	public final static Chat parse(final ChatResource chatResource) {
		Chat chat = null;
		if (chatResource != null) {
			chat = new Chat();
			chat.setId(chatResource.getId());
			chat.setPartner(PartnerMapper.parse(chatResource.getPartnerResource()));
			chat.setMessages(new ArrayList<>());
			for (MessageResource message : chatResource.getMessages()) {
				chat.getMessages().add(MessageMapper.parse(message));
			}
		}
		return chat;
	}
	
	public final static ChatResource parse(final Chat chat) {
		ChatResource chatResource = null;
		if (chat != null) {
			chatResource = new ChatResource();
			chatResource.setId(chat.getId());
			chatResource.setPartnerResource(PartnerMapper.parse(chat.getPartner()));
			chatResource.setMessages(new ArrayList<>());
			for (MessageResource message : chatResource.getMessages()) {
				chat.getMessages().add(MessageMapper.parse(message));
			}
		}
		return chatResource;
	}
}