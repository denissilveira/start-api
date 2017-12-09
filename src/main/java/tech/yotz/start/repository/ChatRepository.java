package tech.yotz.start.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tech.yotz.start.model.entity.Chat;

@Repository("chatRepository")
public interface ChatRepository extends MongoRepository<Chat, String> {
	
	List<Chat> findByPartner(final String partner);
	
	List<Chat> findByProject(final String projetct);
	
	List<Chat> findByStartup(final String startup);

}