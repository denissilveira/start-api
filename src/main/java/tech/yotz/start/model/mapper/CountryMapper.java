package tech.yotz.start.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import tech.yotz.start.model.entity.Country;
import tech.yotz.start.model.resource.CountryResource;

public class CountryMapper {

	public static final List<Country> parseList(final List<CountryResource> resources) {
		
		if(CollectionUtils.isEmpty(resources))
			return null;
		
		return resources.stream().map(resource -> {
			return parse(resource);
		}).collect(Collectors.toList());
	}
	
	public static final List<CountryResource> parseResources(final List<Country> countries) {
		
		if(CollectionUtils.isEmpty(countries))
			return null;
		
		return countries.stream().map(country -> {
			return parse(country);
		}).collect(Collectors.toList());
	}
	
	public static final Country parse(final CountryResource countryResource) {
		if (countryResource == null) 
			return null;
		final Country country = new Country();
		country.setId(countryResource.getId());
		country.setDescription(countryResource.getDescription());
		return country;
	}
	
	public static final CountryResource parse(final Country country) {
		if (country == null) 
			return null;
		final CountryResource countryResource = new CountryResource();
		countryResource.setId(country.getId());
		countryResource.setDescription(country.getDescription());
		return countryResource;
	}
}