package froren.collegesurvival.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Component {
	
	protected static final Set<Class<? extends Component>> NO_DEPENDENCIES = new HashSet<>(0);
	
	protected Entity entity;
	protected Map<Class<? extends Component>, Component> linkedDependencies;
	
	public abstract void invoke(double delta);
	public abstract void destroy();
	public abstract Set<Class<? extends Component>> getDependencyList();
	
	public void setEntity(Entity entity){
		this.entity = entity;
	}
	
	public Entity getEntity(){
		return entity;
	}
	
	public void putDependency(Component c){
		assert(linkedDependencies != null);
		linkedDependencies.put(c.getClass(), c);
	}
}
