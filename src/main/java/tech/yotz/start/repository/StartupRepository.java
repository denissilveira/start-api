package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.yotz.start.model.entity.Startup;

public interface StartupRepository extends MongoRepository<Startup, String> {

}
