package tech.yotz.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;

import com.mongodb.DuplicateKeyException;

import tech.yotz.start.model.entity.User;
import tech.yotz.start.model.mapper.PartnerMapper;
import tech.yotz.start.model.mapper.UserMapper;
import tech.yotz.start.model.resource.PartnerResource;
import tech.yotz.start.model.resource.UserResource;
import tech.yotz.start.model.resource.UserTokenStateResource;
import tech.yotz.start.repository.PartnerRepository;
import tech.yotz.start.service.AuthenticationService;
import tech.yotz.start.service.PartnerService;
import tech.yotz.start.service.UserService;

@Service("proposalService")
public class PartnerServiceImpl implements PartnerService {
	
	@Autowired
	private PartnerRepository partnerRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private PartnerMapper mapper;
	@Autowired
	private AuthenticationService authenticationService;
	
	@Override
	public UserTokenStateResource save(final PartnerResource resource, final Device device) throws DuplicateKeyException, Exception {
		final String pass = resource.getUserResource().getPassword();
		final UserResource user = userService.registration(resource.getUserResource());
		resource.setUserResource(user);
		partnerRepository.save(mapper.parse(resource));
		final UserTokenStateResource userTokenStateResource = authenticationService.authenticate(resource.getUserResource().getUsername(), pass, device);
		return userTokenStateResource;
	}

	@Override
	public PartnerResource findByUser(final String userId) {
		final User user = UserMapper.parse(userService.findById(userId));
		if(user == null)
			return null;
		return mapper.parse(partnerRepository.findByUser(user));
	}

	@Override
	public PartnerResource findById(final String id) {
		return mapper.parse(partnerRepository.findOne(id));
	}
}