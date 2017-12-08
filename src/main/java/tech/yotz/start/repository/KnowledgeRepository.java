package tech.yotz.start.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tech.yotz.start.model.entity.Knowledge;

@Repository("knowledgeRepository")
@CacheConfig(cacheNames = "knowledges")
public interface KnowledgeRepository extends MongoRepository<Knowledge, String>{

	@Cacheable
	List<Knowledge> findAll();
	
	@Cacheable
	Knowledge findById(final String id);
}