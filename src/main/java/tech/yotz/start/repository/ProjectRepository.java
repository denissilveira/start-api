package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.yotz.start.model.entity.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {
	Project findById(final String id);
}
