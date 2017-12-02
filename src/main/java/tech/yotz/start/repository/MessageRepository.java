package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.yotz.start.model.entity.Message;

public interface MessageRepository extends MongoRepository<Message, String>{

}
