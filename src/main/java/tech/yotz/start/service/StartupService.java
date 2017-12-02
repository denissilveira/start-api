package tech.yotz.start.service;

import tech.yotz.start.model.resource.StartupResource;

public interface StartupService {
	
	StartupResource save(final StartupResource resource) throws Exception;

}