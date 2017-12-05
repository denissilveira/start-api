package tech.yotz.start.service;

import org.springframework.mobile.device.Device;

import tech.yotz.start.model.resource.StartupResource;
import tech.yotz.start.model.resource.UserTokenStateResource;

public interface StartupService {
	
	UserTokenStateResource save(final StartupResource resource, final Device device) throws Exception;

}