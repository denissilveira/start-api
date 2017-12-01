package tech.yotz.start.model.mapper;

import tech.yotz.start.model.entity.Proposal;
import tech.yotz.start.model.resource.ProposalResource;

public class ProposalMapper {
	public final static Proposal parse(final ProposalResource proposalResource) {
		Proposal proposal = null;
		if (proposalResource != null) {
			proposal = new Proposal();
			proposal.setId(proposalResource.getId());
			proposal.setDescription(proposalResource.getDescription());
			proposal.setPartner(PartnerMapper.parse(proposalResource.getPartnerResource()));
			proposal.setProject(ProjectMapper.parse(proposalResource.getProjectResource()));
			proposal.setStatus(proposalResource.getStatus());
		}
		return proposal;
	}
	
	public final static ProposalResource parse(final Proposal proposal) {
		ProposalResource proposalResource = null;
		if (proposal != null) {
			proposalResource = new ProposalResource();
			proposalResource.setId(proposal.getId());
			proposalResource.setDescription(proposal.getDescription());
			proposalResource.setPartnerResource(PartnerMapper.parse(proposal.getPartner()));
			proposalResource.setProjectResource(ProjectMapper.parse(proposal.getProject()));
			proposalResource.setStatus(proposal.getStatus());
		}
		return proposalResource;
	}
}