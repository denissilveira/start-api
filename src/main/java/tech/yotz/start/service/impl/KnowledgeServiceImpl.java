package tech.yotz.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.model.entity.Knowledge;
import tech.yotz.start.repository.KnowledgeRepository;
import tech.yotz.start.service.KnowledgeService;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {
	
	@Autowired
	private KnowledgeRepository knowledgeRepository;
	
	public List<Knowledge> getAll() {
		return knowledgeRepository.findAll();
	}
}
