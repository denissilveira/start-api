package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.yotz.start.model.entity.City;

public interface CityRepository extends MongoRepository<City, String> {

}
