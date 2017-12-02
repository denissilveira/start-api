package tech.yotz.start.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.yotz.start.model.entity.Partner;
import tech.yotz.start.model.resource.PartnerResource;
import tech.yotz.start.service.CityService;

@Component
public class PartnerMapper {
	
	@Autowired
	private CityService cityService;
	@Autowired
	private KnowledgeMapper knowledgeMapper;
	
	public final Partner parse(final PartnerResource partnerResource) {
		
		if (partnerResource == null) 
			return null;
		
		Partner partner = new Partner();
		partner.setId(partnerResource.getId());
		partner.setDescription(partnerResource.getDescription());
		partner.setCity(cityService.findByDescription(partnerResource.getCity()));
		partner.setKnowledges(knowledgeMapper.parseList(partnerResource.getKnowledges()));
		partner.setName(partnerResource.getName());
		partner.setUrlLinkedIn(partnerResource.getUrlLinkedIn());
		partner.setUser(UserMapper.parse(partnerResource.getUserResource()));
		return partner;
	}
	
	public final PartnerResource parse(final Partner partner) {
		
		if(partner == null)
			return null;
			
		final PartnerResource partnerResource = new PartnerResource();
		partnerResource.setId(partner.getId());
		partnerResource.setDescription(partner.getDescription());
		if(partner.getCity() != null) {
			partnerResource.setCity(partner.getCity().getDescription());
		}
		partnerResource.setKnowledges(knowledgeMapper.parseResources(partner.getKnowledges()));
		partnerResource.setName(partner.getName());
		partnerResource.setUrlLinkedIn(partner.getUrlLinkedIn());
		partnerResource.setUserResource(UserMapper.parse(partner.getUser())); 
		return partnerResource;
	}
}