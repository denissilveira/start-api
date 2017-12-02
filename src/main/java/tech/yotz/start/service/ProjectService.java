package tech.yotz.start.service;

import tech.yotz.start.model.entity.Project;
import tech.yotz.start.model.resource.ProjectResource;

public interface ProjectService {
	
	Project findById(final String id);
	Project save(final ProjectResource projectResource);
	Project update(final ProjectResource projectResource);
	void remove(final String id);
}