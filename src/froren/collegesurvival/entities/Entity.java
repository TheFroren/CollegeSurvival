package froren.collegesurvival.entities;

import java.util.LinkedHashMap;
import java.util.Set;

import froren.collegesurvival.handlers.World;

public class Entity {
	
	public final World world;
	
	private LinkedHashMap<Class<? extends Component>, Component> components = new LinkedHashMap<>();

	public Entity(World world) {
		this.world = world;
	}
	
	public void invokeComponents(double delta) {
		synchronized (components) {
			for (Component c : components.values())
				c.invoke(delta);
		}
	}

	public Entity addComponent(Component c) {
		Set<Class<? extends Component>> dependencies = c.getDependencyList();

		for (Class<? extends Component> clazz : dependencies) {
			if (components.containsKey(clazz))
				c.putDependency(components.get(clazz));
			else
				throw new RuntimeException("Unable to link dependency: " + clazz.getName());
		}
		
		synchronized (components) {
			components.put(c.getClass(), c);
		}
		
		return this;
	}

	public Entity destroy() {
		synchronized (components) {
			for (Component c : components.values())
				c.destroy();
		}
		return this;
	}
}
