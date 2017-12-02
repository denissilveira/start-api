package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.yotz.start.model.entity.Chat;

public interface ChatRepository extends MongoRepository<Chat, String> {

}
