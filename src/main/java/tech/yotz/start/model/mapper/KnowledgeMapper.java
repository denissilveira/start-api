package tech.yotz.start.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import tech.yotz.start.model.entity.Knowledge;
import tech.yotz.start.model.resource.KnowledgeResource;
import tech.yotz.start.service.KnowledgeService;

@Component
public class KnowledgeMapper {
	
	@Autowired
	private KnowledgeService knowledgeService;
	
	public final List<Knowledge> parseList(final List<String> resources) {
		
		if(CollectionUtils.isEmpty(resources))
			return null;
		
		return resources.stream().map(resource -> {
			return parse(resource);
		}).collect(Collectors.toList());
	}
	
	public final List<String> parseResources(final List<Knowledge> knowledges) {
		
		if(CollectionUtils.isEmpty(knowledges))
			return null;
		
		return knowledges.stream().map(knowledge -> {
			return parseResource(knowledge);
		}).collect(Collectors.toList());
	}
	
	public final Knowledge parse(final String resource) {
		if (StringUtils.isEmpty(resource))
			return null;
		return knowledgeService.findById(resource);
	}
	
	public final Knowledge parse(final KnowledgeResource knowledgeResource) {
		if (knowledgeResource == null)
			return null;
		final Knowledge knowledge = new Knowledge();
		knowledge.setId(knowledgeResource.getId());
		knowledge.setDescription(knowledgeResource.getDescription());
		return knowledge;
	}
	
	public final KnowledgeResource parse(final Knowledge knowledge) {
		if (knowledge == null)
			return null;
		final KnowledgeResource knowledgeResource = new KnowledgeResource();
		knowledgeResource.setId(knowledge.getId());
		knowledgeResource.setDescription(knowledge.getDescription());
		return knowledgeResource;
	}
	
	public final String parseResource(final Knowledge knowledge) {
		if (knowledge == null)
			return null;
		return knowledge.getDescription();
	}
}