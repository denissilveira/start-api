package tech.yotz.start.model.mapper;

import tech.yotz.start.model.entity.User;
import tech.yotz.start.model.resource.UserResource;

public class UserMapper {
	
	public static final UserResource parse(final User user) {
		
		if(user == null)
			return null;
		
		final UserResource userResource = new UserResource();
		userResource.setActive(user.isActive());
		userResource.setCreated(user.getCreated());
		userResource.setId(user.getId());
		userResource.setPassword(user.getPassword());
		userResource.setPhoto(user.getPhoto());
		userResource.setRoles(user.getRoles());
		userResource.setUsername(user.getUsername());
		userResource.setName(user.getName());
		return userResource;
	}
	
	public static final User parse(final UserResource userResource) {
		
		if(userResource == null)
			return null;
		
		final User user = new User();
		user.setActive(userResource.isActive());
		user.setCreated(userResource.getCreated());
		user.setId(userResource.getId());
		user.setPassword(userResource.getPassword());
		user.setPhoto(userResource.getPhoto());
		user.setRoles(userResource.getRoles());
		user.setUsername(userResource.getUsername());
		user.setName(userResource.getName());
		return user;
	}

}