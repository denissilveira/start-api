package tech.yotz.start.model.enums;

public enum RolesEnum {
	
	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

	private final String role;

	private RolesEnum(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

}