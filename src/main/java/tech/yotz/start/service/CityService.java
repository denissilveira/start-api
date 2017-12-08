package tech.yotz.start.service;

import java.util.List;

import tech.yotz.start.model.entity.City;
import tech.yotz.start.model.resource.CityResource;

public interface CityService {
	
	City findByDescription(final String description);
	
	List<CityResource> findByState(final String state);
}