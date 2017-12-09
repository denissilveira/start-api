package tech.yotz.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.model.entity.Chat;
import tech.yotz.start.model.mapper.ChatMapper;
import tech.yotz.start.model.mapper.MessageMapper;
import tech.yotz.start.model.resource.ChatResource;
import tech.yotz.start.model.resource.MessageResource;
import tech.yotz.start.repository.MessageRepository;
import tech.yotz.start.service.ChatService;
import tech.yotz.start.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageRepository repository;
	@Autowired
	private MessageMapper mapper;
	@Autowired
	private ChatService chatService;
	@Autowired
	private ChatMapper chatMapper;

	@Override
	public void save(final String chatId, final MessageResource messageResource) throws Exception {

		try {
			final ChatResource chat = chatService.findById(chatId);
			if(chat == null)
				throw new Exception("Chat nao encontrado");
			repository.save(mapper.parse(messageResource, chatMapper.parse(chat)));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<MessageResource> save(final List<MessageResource> messages) throws Exception {
		return mapper.parseResources(repository.save(mapper.parseList(messages)));
	}

	@Override
	public List<MessageResource> save(final List<MessageResource> messages, final Chat chat) throws Exception {
		return mapper.parseResources(repository.save(mapper.parseList(messages, chat)));
	}

	@Override
	public List<MessageResource> findByChat(final Chat chat) {
		return mapper.parseResources(repository.findByChat(chat));
	}
}