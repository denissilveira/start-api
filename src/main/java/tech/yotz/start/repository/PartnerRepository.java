package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.yotz.start.model.entity.Partner;

public interface PartnerRepository extends MongoRepository<Partner, String> {

}
