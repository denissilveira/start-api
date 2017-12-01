package tech.yotz.start.model.mapper;

import tech.yotz.start.model.entity.Country;
import tech.yotz.start.model.resource.CountryResource;

public class CountryMapper {
	public static final Country parse(final CountryResource countryResource) {
		Country country = null;
		if (countryResource != null) {
			country = new Country();
			country.setId(countryResource.getId());
			country.setDescription(countryResource.getDescription());
		}
		return country;
	}
	
	public static final CountryResource parse(final Country country) {
		CountryResource countryResource = null;
		if (country != null) {
			countryResource = new CountryResource();
			countryResource.setId(country.getId());
			countryResource.setDescription(country.getDescription());
		}
		return countryResource;
	}
}