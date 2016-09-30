package froren.collegesurvival.entities;

import java.util.LinkedHashMap;
import java.util.Set;

public class Entity {
	private LinkedHashMap<Class<? extends Component>, Component> components = new LinkedHashMap<>();

	public void invokeComponents(float delta) {
		synchronized (components) {
			for (Component c : components.values())
				c.invoke(delta);
		}
	}

	public void addComponent(Component c) {
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
	}

	public void destroy() {
		synchronized (components) {
			for (Component c : components.values())
				c.destroy();
		}
	}
}
