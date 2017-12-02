package tech.yotz.start.model.mapper;

import tech.yotz.start.model.entity.Startup;
import tech.yotz.start.model.resource.StartupResource;

public class StartupMapper {
	public final static Startup parse(final StartupResource startupResource) {
		Startup startup = null;
		if (startupResource != null) {
			startup = new Startup();
			startup.setId(startupResource.getId());
			startup.setName(startupResource.getName());
			startup.setCity(CityMapper.parse(startupResource.getCity()));
			startup.setCompany(startupResource.getCompany());
			startup.setUser(null); //TODO
		}
		return startup;
	}
	
	public final static StartupResource parse(final Startup startup) {
		StartupResource startupResource = null;
		if (startup != null) {
			startupResource = new StartupResource();
			startupResource.setId(startup.getId());
			startupResource.setName(startup.getName());
			startupResource.setCity(CityMapper.parse(startup.getCity()));
			startupResource.setCompany(startup.getCompany());
			startupResource.setUser(null); //TODO
		}
		return startupResource;
	}
}