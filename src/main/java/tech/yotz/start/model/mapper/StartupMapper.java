package tech.yotz.start.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import tech.yotz.start.model.entity.Startup;
import tech.yotz.start.model.resource.StartupResource;
import tech.yotz.start.service.CityService;

@Component
public class StartupMapper {
	
	@Autowired
	private CityService cityService;
	
	public final List<Startup> parseList(final List<StartupResource> resources) {
		
		if(CollectionUtils.isEmpty(resources))
			return null;
		
		return resources.stream().map(resource -> {
			return parse(resource);
		}).collect(Collectors.toList());
	}
	
	public final List<StartupResource> parseResources(final List<Startup> startups) {
		
		if(CollectionUtils.isEmpty(startups))
			return null;
		
		return startups.stream().map(startup -> {
			return parse(startup);
		}).collect(Collectors.toList());
	}
	
	public final Startup parse(final StartupResource startupResource) {
		Startup startup = null;
		if (startupResource != null) {
			startup = new Startup();
			startup.setId(startupResource.getId());
			startup.setName(startupResource.getName());
			startup.setCity(cityService.findById(startupResource.getCity()));
			startup.setCompany(startupResource.getCompany());
			startup.setUser(UserMapper.parse(startupResource.getUser())); 
		}
		return startup;
	}
	
	public final StartupResource parse(final Startup startup) {
		StartupResource startupResource = null;
		if (startup != null) {
			startupResource = new StartupResource();
			startupResource.setId(startup.getId());
			startupResource.setName(startup.getName());
			if(startup.getCity() != null) {
				startupResource.setCity(startup.getCity().getDescription());
			}
			startupResource.setCompany(startup.getCompany());
			startupResource.setUser(UserMapper.parse(startup.getUser())); 
		}
		return startupResource;
	}
}