package tech.yotz.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.repository.ProposalRepository;
import tech.yotz.start.service.ProposalService;

@Service
public class ProposalServiceImpl implements ProposalService {
	
	@Autowired
	private ProposalRepository proposalRepository;
}
