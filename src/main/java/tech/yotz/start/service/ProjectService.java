package tech.yotz.start.service;

import tech.yotz.start.model.resource.ProjectResource;

public interface ProjectService {
	
	ProjectResource findById(final String id);
	ProjectResource save(final ProjectResource projectResource);
	ProjectResource update(final ProjectResource projectResource);
	void remove(final String id);
}