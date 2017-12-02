package tech.yotz.start.model.resource;

import java.util.List;

public class PartnerResource {
	
	private String id;
	private String name;
	private List<KnowledgeResource> knowledges;
	private CityResource cityResource;
	private String description;
	private String urlLinkedIn;
	private UserResource userResource;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlLinkedIn() {
		return urlLinkedIn;
	}
	public void setUrlLinkedIn(String urlLinkedIn) {
		this.urlLinkedIn = urlLinkedIn;
	}
	public List<KnowledgeResource> getKnowledges() {
		return knowledges;
	}
	public void setKnowledges(List<KnowledgeResource> knowledges) {
		this.knowledges = knowledges;
	}
	public CityResource getCityResource() {
		return cityResource;
	}
	public void setCityResource(CityResource cityResource) {
		this.cityResource = cityResource;
	}
	public UserResource getUserResource() {
		return userResource;
	}
	public void setUserResource(UserResource userResource) {
		this.userResource = userResource;
	}
	
}