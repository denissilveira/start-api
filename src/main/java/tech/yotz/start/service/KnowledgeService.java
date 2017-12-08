package tech.yotz.start.service;

import java.util.List;

import tech.yotz.start.model.entity.Knowledge;
import tech.yotz.start.model.resource.KnowledgeResource;

public interface KnowledgeService {
	
	List<KnowledgeResource> findAll();
	
	Knowledge findById(final String id);
}
