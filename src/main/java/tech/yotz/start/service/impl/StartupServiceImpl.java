package tech.yotz.start.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;

import tech.yotz.start.model.entity.City;
import tech.yotz.start.model.mapper.StartupMapper;
import tech.yotz.start.model.resource.StartupResource;
import tech.yotz.start.model.resource.UserResource;
import tech.yotz.start.model.resource.UserTokenStateResource;
import tech.yotz.start.repository.CityRepository;
import tech.yotz.start.repository.StartupRepository;
import tech.yotz.start.service.AuthenticationService;
import tech.yotz.start.service.StartupService;
import tech.yotz.start.service.UserService;

@Service
public class StartupServiceImpl implements StartupService {
	
	@Autowired
	private StartupRepository startupRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private StartupMapper mapper;
	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private CityRepository cityRepository;

	@Override
	public UserTokenStateResource save(final StartupResource resource, final Device device) throws DuplicateKeyException, Exception {
		
		final String pass = resource.getUser().getPassword();
		final UserResource user = userService.registration(resource.getUser());
		resource.setUser(user);
		startupRepository.save(mapper.parse(resource));
		final UserTokenStateResource userTokenStateResource = authenticationService.authenticate(resource.getUser().getUsername(), pass, device);
		return userTokenStateResource;
	}

	@Override
	public List<StartupResource> findAll() {
		return mapper.parseResources(startupRepository.findAll());
	}

	@Override
	public List<StartupResource> findByCity(final String cityId) {
		final City city = cityRepository.findOne(cityId);
		if(city == null)
			return null;
		return mapper.parseResources(startupRepository.findByCity(city));
	}

	@Override
	public StartupResource findById(final String id) {
		return mapper.parse(startupRepository.findOne(id));
	}
}