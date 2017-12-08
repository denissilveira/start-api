package tech.yotz.start.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tech.yotz.start.model.entity.State;

@Repository("stateRepository")
@CacheConfig(cacheNames = "states")
public interface StateRepository  extends MongoRepository<State, String> {

	@Cacheable
	List<State> findByCountry(final String country);
}