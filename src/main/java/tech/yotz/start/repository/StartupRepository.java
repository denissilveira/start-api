package tech.yotz.start.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tech.yotz.start.model.entity.City;
import tech.yotz.start.model.entity.Startup;
import tech.yotz.start.model.entity.User;

@Repository("startupRepository")
public interface StartupRepository extends MongoRepository<Startup, String> {
	
	List<Startup> findByCity(final City city);
	
	Startup findByUser(final User user);
}