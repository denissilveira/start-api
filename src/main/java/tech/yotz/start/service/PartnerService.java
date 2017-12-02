package tech.yotz.start.service;

import tech.yotz.start.model.resource.PartnerResource;

public interface PartnerService {
	
	PartnerResource save(final PartnerResource resource) throws Exception;
}