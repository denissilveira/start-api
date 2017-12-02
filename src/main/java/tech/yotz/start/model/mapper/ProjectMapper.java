package tech.yotz.start.model.mapper;

import java.util.ArrayList;

import tech.yotz.start.model.entity.Knowledge;
import tech.yotz.start.model.entity.Project;
import tech.yotz.start.model.resource.KnowledgeResource;
import tech.yotz.start.model.resource.ProjectResource;

public class ProjectMapper {
	public static final Project parse(final ProjectResource projectResource) {
		Project project = null;
		if (projectResource != null) {
			project = new Project();
			project.setId(projectResource.getId());
			project.setDescription(projectResource.getDescription());
			project.setProfile(projectResource.getProfile());
			project.setTitle(projectResource.getTitle());
			project.setUrl(projectResource.getUrl());
			project.setKnowledges(new ArrayList<>());
			/*for (KnowledgeResource knowledgeResource : projectResource.getKnowledges()) {
				project.getKnowledges().add(KnowledgeMapper.parse(knowledgeResource));
			}*/
		}
		return project;
	}
	
	public static final ProjectResource parse(final Project project) {
		ProjectResource projectResource = null;
		if (project != null) {
			projectResource = new ProjectResource();
			projectResource.setId(project.getId());
			projectResource.setDescription(project.getDescription());
			projectResource.setProfile(project.getProfile());
			projectResource.setTitle(project.getTitle());
			projectResource.setUrl(project.getUrl());
			projectResource.setKnowledges(new ArrayList<>());
			/*for (Knowledge knowledge : project.getKnowledges()) {
				projectResource.getKnowledges().add(KnowledgeMapper.parse(knowledge));
			}*/
		}
		return projectResource;
	}
}