package tech.yotz.start.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import tech.yotz.start.model.entity.City;
import tech.yotz.start.model.resource.CityResource;

public class CityMapper {
	
	public static final List<City> parseList(final List<CityResource> resources) {
		
		if(CollectionUtils.isEmpty(resources))
			return null;
		
		return resources.stream().map(resource -> {
			return parse(resource);
		}).collect(Collectors.toList());
	}
	
	public static final List<CityResource> parseResources(final List<City> cities) {
		
		if(CollectionUtils.isEmpty(cities))
			return null;
		
		return cities.stream().map(city -> {
			return parse(city);
		}).collect(Collectors.toList());
	}
	
	public final static City parse(CityResource cityResource) {
		if (cityResource == null) 
			return null;
		final City city = new City();
		city.setId(cityResource.getId());
		city.setDescription(cityResource.getDescription());
		city.setState(cityResource.getState());
		return city;
	}
	
	public final static CityResource parse(City city) {
		if (city == null) 
			return null;
		final CityResource cityResource = new CityResource();
		cityResource.setId(city.getId());
		cityResource.setDescription(city.getDescription());
		cityResource.setState(city.getState());
		return cityResource;
	}
}