package tech.yotz.start.model.mapper;

import tech.yotz.start.model.entity.City;
import tech.yotz.start.model.resource.CityResource;

public class CityMapper {
	public final static City parse(CityResource cityResource) {
		City city = null;
		if (cityResource != null) {
			city = new City();
			city.setId(cityResource.getId());
			city.setDescription(cityResource.getDescription());
			city.setState(cityResource.getState());
		}
		return city;
	}
	
	public final static CityResource parse(City city) {
		CityResource cityResource = null;
		if (city != null) {
			cityResource = new CityResource();
			cityResource.setId(city.getId());
			cityResource.setDescription(city.getDescription());
			cityResource.setState(city.getState());
		}
		return cityResource;
	}
}