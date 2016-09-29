package froren.collegesurvival;

import java.util.List;
import java.util.Map;

public abstract class Component {
	
	private Entity entity;
	private Map<String, Component> dependencies;
	
	public abstract void invoke(double delta);
	public abstract void destroy();
	public abstract List<Class<? extends Component>> getDependencyList();
}
