package tech.yotz.start.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.yotz.start.model.entity.Proposal;
import tech.yotz.start.model.resource.ProposalResource;

@Component
public class ProposalMapper {
	
	@Autowired
	private PartnerMapper partnerMapper;
	
	public final Proposal parse(final ProposalResource proposalResource) {
		Proposal proposal = null;
		if (proposalResource != null) {
			proposal = new Proposal();
			proposal.setId(proposalResource.getId());
			proposal.setDescription(proposalResource.getDescription());
			proposal.setPartner(partnerMapper.parse(proposalResource.getPartnerResource()));
			proposal.setProject(ProjectMapper.parse(proposalResource.getProjectResource()));
			proposal.setStatus(proposalResource.getStatus());
		}
		return proposal;
	}
	
	public final ProposalResource parse(final Proposal proposal) {
		ProposalResource proposalResource = null;
		if (proposal != null) {
			proposalResource = new ProposalResource();
			proposalResource.setId(proposal.getId());
			proposalResource.setDescription(proposal.getDescription());
			proposalResource.setPartnerResource(partnerMapper.parse(proposal.getPartner()));
			proposalResource.setProjectResource(ProjectMapper.parse(proposal.getProject()));
			proposalResource.setStatus(proposal.getStatus());
		}
		return proposalResource;
	}
}