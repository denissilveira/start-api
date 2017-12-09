package tech.yotz.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.model.entity.City;
import tech.yotz.start.model.mapper.CityMapper;
import tech.yotz.start.model.resource.CityResource;
import tech.yotz.start.repository.CityRepository;
import tech.yotz.start.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository repository;
	
	@Override
	public City findByDescription(final String description) {
		return repository.findByDescription(description);
	}

	@Override
	public List<CityResource> findByState(final String state) {
		return CityMapper.parseResources(repository.findByState(state));
	}

	@Override
	public City findById(final String id) {
		return repository.findOne(id);
	}
}