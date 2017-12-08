package tech.yotz.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.model.mapper.StateMapper;
import tech.yotz.start.model.resource.StateResource;
import tech.yotz.start.repository.StateRepository;
import tech.yotz.start.service.StateService;

@Service("stateService")
public class StateServiceImpl implements StateService {
	
	@Autowired
	private StateRepository repository;

	@Override
	public List<StateResource> findByCountry(final String country) {
		return StateMapper.parseResources(repository.findByCountry(country));
	}

}