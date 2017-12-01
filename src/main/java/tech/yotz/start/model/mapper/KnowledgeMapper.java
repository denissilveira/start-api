package tech.yotz.start.model.mapper;

import tech.yotz.start.model.entity.Knowledge;
import tech.yotz.start.model.resource.KnowledgeResource;

public class KnowledgeMapper {
	public static final Knowledge parse(KnowledgeResource knowledgeResource) {
		Knowledge knowledge = null;
		if (knowledgeResource != null) {
			knowledge = new Knowledge();
			knowledge.setId(knowledgeResource.getId());
			knowledge.setDescription(knowledgeResource.getDescription());
		}
		return knowledge;
	}
	
	public static final KnowledgeResource parse(Knowledge knowledge) {
		KnowledgeResource knowledgeResource = null;
		if (knowledge != null) {
			knowledgeResource = new KnowledgeResource();
			knowledgeResource.setId(knowledge.getId());
			knowledgeResource.setDescription(knowledge.getDescription());
		}
		return knowledgeResource;
	}
}