package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.yotz.start.model.entity.Partner;
import tech.yotz.start.model.entity.User;

public interface PartnerRepository extends MongoRepository<Partner, String> {
	
	Partner findByUser(final User user);

}