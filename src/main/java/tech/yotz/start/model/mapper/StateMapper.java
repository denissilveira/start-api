package tech.yotz.start.model.mapper;

import tech.yotz.start.model.entity.State;
import tech.yotz.start.model.resource.StateResource;

public class StateMapper {
	
	public static final State parse(final StateResource stateResource) {
		State state = null;
		if (stateResource != null) {
			state = new State();
			state.setId(stateResource.getId());
			state.setCountry(stateResource.getCountry());
			state.setDescription(stateResource.getDescription());
		}
		return state;
	}
	
	public static final StateResource parse(final State state) {
		StateResource stateResource = null;
		if (state != null) {
			stateResource = new StateResource();
			stateResource.setId(state.getId());
			stateResource.setCountry(state.getCountry());
			stateResource.setDescription(state.getDescription());
		}
		return stateResource;
	}
}