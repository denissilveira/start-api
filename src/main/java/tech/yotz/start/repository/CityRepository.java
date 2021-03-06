package tech.yotz.start.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tech.yotz.start.model.entity.City;

@Repository("cityRepository")
@CacheConfig(cacheNames = "cities")
public interface CityRepository extends MongoRepository<City, String> {
	
	@Cacheable
	City findByDescription(final String description);
	
	@Cacheable
	List<City> findByState(final String state);
}