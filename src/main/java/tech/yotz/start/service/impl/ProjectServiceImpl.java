package tech.yotz.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.model.mapper.ProjectMapper;
import tech.yotz.start.model.resource.ProjectResource;
import tech.yotz.start.repository.ProjectRepository;
import tech.yotz.start.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public ProjectResource findById(String id) {
		return ProjectMapper.parse(projectRepository.findById(id));
	}

	@Override
	public ProjectResource save(ProjectResource projectResource) {
		return ProjectMapper.parse(projectRepository.save(ProjectMapper.parse(projectResource)));
	}

	@Override
	public ProjectResource update(ProjectResource projectResource) {
		return ProjectMapper.parse(projectRepository.save(ProjectMapper.parse(projectResource)));
	}

	@Override
	public void remove(String id) {
		projectRepository.delete(id);
	}

}
