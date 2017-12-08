package tech.yotz.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.model.entity.Knowledge;
import tech.yotz.start.model.mapper.KnowledgeMapper;
import tech.yotz.start.model.resource.KnowledgeResource;
import tech.yotz.start.repository.KnowledgeRepository;
import tech.yotz.start.service.KnowledgeService;

@Service("knowledgeService")
public class KnowledgeServiceImpl implements KnowledgeService {
	
	@Autowired
	private KnowledgeRepository repository;
	@Autowired
	private KnowledgeMapper mapper;
	
	@Override
	public Knowledge findById(final String id) {
		return repository.findById(id);
	}

	@Override
	public List<KnowledgeResource> findAll() {
		return mapper.parseResources(repository.findAll());
	}
}