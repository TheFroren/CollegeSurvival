package froren.collegesurvival.entities;

import java.util.Set;

public class Position extends Component {	
	
	public double
		x,
		y,
		angle;
	
	public Position(double x, double y, double angle) {
		this.x = x;
		this.y = y;
		this.angle = angle;
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
