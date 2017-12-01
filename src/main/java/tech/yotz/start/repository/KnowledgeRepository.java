package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.yotz.start.model.entity.Knowledge;

public interface KnowledgeRepository extends MongoRepository<Knowledge, String>{

}
