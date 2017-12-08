package tech.yotz.start.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tech.yotz.start.model.entity.Country;

@Repository("countryRepository")
@CacheConfig(cacheNames = "countries")
public interface CountryRepository extends MongoRepository<Country, String> {

	@Cacheable
	List<Country> findAll();
}