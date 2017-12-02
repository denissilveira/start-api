package tech.yotz.start.model.mapper;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.yotz.start.model.entity.Chat;
import tech.yotz.start.model.resource.ChatResource;
import tech.yotz.start.model.resource.MessageResource;

@Component
public class ChatMapper {
	
	@Autowired
	private PartnerMapper partnerMapper;
	
	public final Chat parse(final ChatResource chatResource) {
		Chat chat = null;
		if (chatResource != null) {
			chat = new Chat();
			chat.setId(chatResource.getId());
			chat.setPartner(partnerMapper.parse(chatResource.getPartnerResource()));
			chat.setMessages(new ArrayList<>());
			for (MessageResource message : chatResource.getMessages()) {
				chat.getMessages().add(MessageMapper.parse(message));
			}
		}
		return chat;
	}
	
	public final ChatResource parse(final Chat chat) {
		ChatResource chatResource = null;
		if (chat != null) {
			chatResource = new ChatResource();
			chatResource.setId(chat.getId());
			chatResource.setPartnerResource(partnerMapper.parse(chat.getPartner()));
			chatResource.setMessages(new ArrayList<>());
			for (MessageResource message : chatResource.getMessages()) {
				chat.getMessages().add(MessageMapper.parse(message));
			}
		}
		return chatResource;
	}
}