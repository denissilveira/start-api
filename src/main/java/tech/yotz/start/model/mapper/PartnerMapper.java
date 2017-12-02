package tech.yotz.start.model.mapper;

import java.util.ArrayList;

import tech.yotz.start.model.entity.Knowledge;
import tech.yotz.start.model.entity.Partner;
import tech.yotz.start.model.resource.KnowledgeResource;
import tech.yotz.start.model.resource.PartnerResource;

public class PartnerMapper {
	public final static Partner parse(PartnerResource partnerResource) {
		Partner partner = null;
		if (partnerResource != null) {
			partner = new Partner();
			partner.setId(partnerResource.getId());
			partner.setDescription(partnerResource.getDescription());
			partner.setCity(CityMapper.parse(partnerResource.getCityResource()));
			partner.setKnowledges(new ArrayList<>());
			for (KnowledgeResource knowledgeResource : partnerResource.getKnowledges()) {
				partner.getKnowledges().add(KnowledgeMapper.parse(knowledgeResource));
			}
			partner.setName(partnerResource.getName());
			partner.setUrlLinkedIn(partnerResource.getUrlLinkedIn());
			partner.setUser(null); //TODO userMapper
		}
		return partner;
	}
	
	public final static PartnerResource parse(Partner partner) {
		PartnerResource partnerResource = null;
		if (partner != null) {
			partnerResource = new PartnerResource();
			partnerResource.setId(partner.getId());
			partnerResource.setDescription(partner.getDescription());
			partnerResource.setCityResource(CityMapper.parse(partner.getCity()));
			partnerResource.setKnowledges(new ArrayList<>());
			for (Knowledge knowledge : partner.getKnowledges()) {
				partnerResource.getKnowledges().add(KnowledgeMapper.parse(knowledge));
			}
			partnerResource.setName(partner.getName());
			partnerResource.setUrlLinkedIn(partner.getUrlLinkedIn());
			partnerResource.setUserResource(null); //TODO userMapper
		}
		return partnerResource;
	}
}