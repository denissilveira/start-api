package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tech.yotz.start.model.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	User findByUsernameAndPassword(final String email, final String password);
	
	User findByUsername(final String email);
}