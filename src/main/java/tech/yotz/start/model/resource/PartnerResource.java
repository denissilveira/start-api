package tech.yotz.start.model.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PartnerResource {
	
	private String id;
	private String name;
	private List<String> knowledges;
	private String city;
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
	public List<String> getKnowledges() {
		return knowledges;
	}
	public void setKnowledges(List<String> knowledges) {
		this.knowledges = knowledges;
	}
	public UserResource getUserResource() {
		return userResource;
	}
	public void setUserResource(UserResource userResource) {
		this.userResource = userResource;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}