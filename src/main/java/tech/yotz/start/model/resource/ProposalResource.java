package tech.yotz.start.model.resource;

public class ProposalResource {

	private String id;
	private PartnerResource partnerResource;
	private ProjectResource projectResource;
	private String description;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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