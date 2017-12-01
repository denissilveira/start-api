package tech.yotz.start.model.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "partner")
public class Partner {
	
	@Id
	private String id;
	private String name;
	@DBRef
	private List<Knowledge> knowledges;
	@DBRef
	private City city;
	private String description;
	private String urlLinkedIn;
	@DBRef
	private User user;
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
	public List<Knowledge> getKnowledges() {
		return knowledges;
	}
	public void setKnowledges(List<Knowledge> knowledges) {
		this.knowledges = knowledges;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}