package tech.yotz.start;

import java.util.ArrayList;

import com.google.gson.Gson;

import tech.yotz.start.model.enums.RolesEnum;
import tech.yotz.start.model.resource.PartnerResource;
import tech.yotz.start.model.resource.UserResource;

public class PartnerTest {
	
	public static void main(String[] args) {
		
		final PartnerResource resource = new PartnerResource();
		resource.setCity("5a232b28103c16a4525fae6e");
		resource.setDescription("Parceria de teste");
		resource.setName("Parceiro");
		resource.setUrlLinkedIn("http://www.yotz.tech");
		resource.setKnowledges(new ArrayList<>());
		resource.getKnowledges().add("5a232d0e103c16a4525fae6f");
		resource.getKnowledges().add("5a232d0e103c16a4525fae70");
		final UserResource user = new UserResource();
		user.setActive(true);
		user.setName("Parceiro loko");
		user.setPassword("teste123");
		user.setUsername("parceiro@email.com");
		user.setRoles(new ArrayList<>());
		user.getRoles().add(RolesEnum.PARTNER.getCode());
		resource.setUserResource(user);
		
		System.out.println(new Gson().toJson(resource));
	}

}