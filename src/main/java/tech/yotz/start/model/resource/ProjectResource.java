package tech.yotz.start.model.resource;

import java.util.List;

public class ProjectResource {
	
	private String id;
	private String title;
	private String description;
	private String profile;
	private List<KnowledgeResource> knowledges;
	private String url;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public List<KnowledgeResource> getKnowledges() {
		return knowledges;
	}
	public void setKnowledges(List<KnowledgeResource> knowledges) {
		this.knowledges = knowledges;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}