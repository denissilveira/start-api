package tech.yotz.start.service;

import java.util.List;

import tech.yotz.start.model.resource.CountryResource;

public interface CountryService {
	
	List<CountryResource> findAll();
}