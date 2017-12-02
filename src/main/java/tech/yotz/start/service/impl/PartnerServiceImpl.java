package tech.yotz.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.model.entity.Partner;
import tech.yotz.start.model.mapper.PartnerMapper;
import tech.yotz.start.model.resource.PartnerResource;
import tech.yotz.start.model.resource.UserResource;
import tech.yotz.start.repository.PartnerRepository;
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
	
	@Override
	public PartnerResource save(final PartnerResource resource) throws Exception {
		
		try {
			final UserResource user = userService.registration(resource.getUserResource());
			resource.setUserResource(user);
			final Partner partner = partnerRepository.save(mapper.parse(resource));
			return mapper.parse(partner);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}