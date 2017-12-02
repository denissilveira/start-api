package tech.yotz.start.service;

import tech.yotz.start.model.entity.City;

public interface CityService {
	
	City findByDescription(final String description);
}