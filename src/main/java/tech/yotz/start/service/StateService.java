package tech.yotz.start.service;

import java.util.List;

import tech.yotz.start.model.resource.StateResource;

public interface StateService {

	List<StateResource> findByCountry(final String country);
}