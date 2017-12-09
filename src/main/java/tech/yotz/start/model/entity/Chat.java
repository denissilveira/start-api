package tech.yotz.start.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chat")
public class Chat {
	
	@Id
	private String id;
	private String startup;
	private String partner;
	private String project;
	
	public String getStartup() {
		return startup;
	}
	public void setStartup(String startup) {
		this.startup = startup;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}

}