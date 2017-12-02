package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.yotz.start.model.entity.Country;

public interface CountryRepository extends MongoRepository<Country, String>{

}
