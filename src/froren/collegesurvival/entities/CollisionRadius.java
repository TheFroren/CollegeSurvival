package froren.collegesurvival.entities;

import java.util.Set;

public class CollisionRadius extends Component{
	public double radius;

	public CollisionRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public void invoke(double delta) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public Set<Class<? extends Component>> getDependencyList() {
		return NO_DEPENDENCIES;
	}
	
	
}
