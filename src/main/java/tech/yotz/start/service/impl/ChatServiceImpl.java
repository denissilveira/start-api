package tech.yotz.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.model.entity.Chat;
import tech.yotz.start.model.mapper.ChatMapper;
import tech.yotz.start.model.resource.ChatResource;
import tech.yotz.start.repository.ChatRepository;
import tech.yotz.start.service.ChatService;
import tech.yotz.start.service.MessageService;

@Service("chatService")
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatRepository chatRepository;
	@Autowired
	private MessageService messageService;
	@Autowired
	private ChatMapper mapper;
	
	@Override
	public ChatResource save(final ChatResource chatResource) throws Exception {

		try {
			final Chat chat = chatRepository.save(mapper.parse(chatResource));
			messageService.save(chatResource.getMessages(), chat);
			return mapper.parse(chat);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public ChatResource findById(final String id) {
		return mapper.parse(chatRepository.findOne(id));
	}

	@Override
	public List<ChatResource> findByPartner(final String partner) {
		return mapper.parseResources(chatRepository.findByPartner(partner));
	}

	@Override
	public List<ChatResource> findByProject(final String project) {
		return mapper.parseResources(chatRepository.findByProject(project));
	}
	
	@Override
	public List<ChatResource> findByStartup(final String startup) {
		return mapper.parseResources(chatRepository.findByStartup(startup));
	}

}