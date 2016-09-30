package froren.collegesurvival.entities;

import java.util.Set;

public class Spatial extends Component {	
	
	public double
		x,
		y,
		angle,
		vx,
		vy,
		radius;
	
	public Spatial(double x, double y, double angle, double vx, double vy, double radius) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.vx = vx;
		this.vy = vy;
		this.radius = radius;
	}

	@Override
	public void invoke(double delta) {
		x += vx*delta;
		y += vy*delta;
	}

	@Override
	public void destroy() {
	}

	@Override
	public Set<Class<? extends Component>> getDependencyList() {
		return NO_DEPENDENCIES;
	}
}
