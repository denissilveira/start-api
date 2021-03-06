package tech.yotz.start.model.resource;

public class StartupResource {
	
	private String id;
	private String name;
	private String company;
	private String city;
	private UserResource user;
	
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public UserResource getUser() {
		return user;
	}
	public void setUser(UserResource user) {
		this.user = user;
	}

}