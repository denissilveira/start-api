package tech.yotz.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.repository.PartnerRepository;
import tech.yotz.start.service.ProposalService;

@Service
public class PartnerServiceImpl implements ProposalService {
	
	@Autowired
	private PartnerRepository partnerRepository;
}
