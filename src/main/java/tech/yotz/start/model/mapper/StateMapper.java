package tech.yotz.start.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import tech.yotz.start.model.entity.State;
import tech.yotz.start.model.resource.StateResource;

public class StateMapper {
	
	public static final List<State> parseList(final List<StateResource> resources) {
		
		if(CollectionUtils.isEmpty(resources))
			return null;
		
		return resources.stream().map(resource -> {
			return parse(resource);
		}).collect(Collectors.toList());
	}
	
	public static final List<StateResource> parseResources(final List<State> states) {
		
		if(CollectionUtils.isEmpty(states))
			return null;
		
		return states.stream().map(state -> {
			return parse(state);
		}).collect(Collectors.toList());
	}
	
	public static final State parse(final StateResource stateResource) {
		if (stateResource == null) 
			return null;
		final State state = new State();
		state.setId(stateResource.getId());
		state.setCountry(stateResource.getCountry());
		state.setDescription(stateResource.getDescription());
		return state;
	}
	
	public static final StateResource parse(final State state) {
		if (state == null) 
			return null;
		StateResource stateResource = new StateResource();
		stateResource.setId(state.getId());
		stateResource.setCountry(state.getCountry());
		stateResource.setDescription(state.getDescription());
		return stateResource;
	}
}