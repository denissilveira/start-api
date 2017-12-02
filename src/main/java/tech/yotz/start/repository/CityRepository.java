package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tech.yotz.start.model.entity.City;

@Repository
public interface CityRepository extends MongoRepository<City, String> {
	
	City findByDescription(final String description);
}