package tech.yotz.start.model.resource;

import java.util.List;

public class ChatResource {
	
	private String id;
	private String startup;
	private String partner;
	private String project;
	private List<MessageResource> messages;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStartup() {
		return startup;
	}
	public void setStartup(String startup) {
		this.startup = startup;
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
	public List<MessageResource> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageResource> messages) {
		this.messages = messages;
	}

}