package tech.yotz.start.model.resource;

import java.util.List;

public class ChatResource {
	
	private String id;
	private PartnerResource partnerResource;
	private ProjectResource projectResource;
	private List<MessageResource> messages;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<MessageResource> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageResource> messages) {
		this.messages = messages;
	}
	public PartnerResource getPartnerResource() {
		return partnerResource;
	}
	public void setPartnerResource(PartnerResource partnerResource) {
		this.partnerResource = partnerResource;
	}
	public ProjectResource getProjectResource() {
		return projectResource;
	}
	public void setProjectResource(ProjectResource projectResource) {
		this.projectResource = projectResource;
	}
	

}