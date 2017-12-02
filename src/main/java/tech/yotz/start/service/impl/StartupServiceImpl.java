package tech.yotz.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.model.entity.Startup;
import tech.yotz.start.model.mapper.StartupMapper;
import tech.yotz.start.model.resource.StartupResource;
import tech.yotz.start.model.resource.UserResource;
import tech.yotz.start.repository.StartupRepository;
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

	@Override
	public StartupResource save(final StartupResource resource) throws Exception {
		
		try {
			
			final UserResource user = userService.registration(resource.getUser());
			resource.setUser(user);
			final Startup startup = startupRepository.save(mapper.parse(resource));
			return mapper.parse(startup);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}