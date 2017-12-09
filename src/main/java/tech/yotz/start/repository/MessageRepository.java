package tech.yotz.start.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.yotz.start.model.entity.Chat;
import tech.yotz.start.model.entity.Message;

public interface MessageRepository extends MongoRepository<Message, String> {

	List<Message> findByChat(final Chat chat);
}