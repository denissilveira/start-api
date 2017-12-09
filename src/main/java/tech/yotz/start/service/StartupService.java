package tech.yotz.start.service;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.mobile.device.Device;

import tech.yotz.start.model.resource.StartupResource;
import tech.yotz.start.model.resource.UserTokenStateResource;

public interface StartupService {
	
	UserTokenStateResource save(final StartupResource resource, final Device device) throws DuplicateKeyException, Exception;
	
	List<StartupResource> findAll();
	
	List<StartupResource> findByCity(final String city);
	
	StartupResource findById(final String id);
	
	StartupResource findByUser(final String user);

}