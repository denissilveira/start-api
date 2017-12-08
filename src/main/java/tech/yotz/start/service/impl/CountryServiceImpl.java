package tech.yotz.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.model.mapper.CountryMapper;
import tech.yotz.start.model.resource.CountryResource;
import tech.yotz.start.repository.CountryRepository;
import tech.yotz.start.service.CountryService;

@Service("countryService")
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<CountryResource> findAll() {
		return CountryMapper.parseResources(countryRepository.findAll());
	}
}