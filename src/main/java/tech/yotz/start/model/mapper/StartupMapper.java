package tech.yotz.start.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.yotz.start.model.entity.Startup;
import tech.yotz.start.model.resource.StartupResource;
import tech.yotz.start.service.CityService;

@Component
public class StartupMapper {
	
	@Autowired
	private CityService cityService;
	
	public final Startup parse(final StartupResource startupResource) {
		Startup startup = null;
		if (startupResource != null) {
			startup = new Startup();
			startup.setId(startupResource.getId());
			startup.setName(startupResource.getName());
			startup.setCity(cityService.findByDescription(startupResource.getCity()));
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