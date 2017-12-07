package tech.yotz.start.service;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.mobile.device.Device;

import tech.yotz.start.model.resource.PartnerResource;
import tech.yotz.start.model.resource.UserTokenStateResource;

public interface PartnerService {
	
	UserTokenStateResource save(final PartnerResource resource, final Device device) throws DuplicateKeyException, Exception;
}