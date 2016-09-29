package froren.collegesurvival.entities;

import java.util.HashSet;
import java.util.Set;

public class VectorSpeed extends Component{
	
	private static final Set<Class<? extends Component>> DEPENDENCIES = new HashSet<>();
	
	static{
		DEPENDENCIES.add(Position.class);
	}
	
	public double
		vx,
		vy;

	public VectorSpeed(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}

	@Override
	public void invoke(double delta) {
		Position pos = (Position) linkedDependencies.get(Position.class);
		
		pos.x += vx*delta;
		pos.y += vy*delta;
	}

	@Override
	public void destroy() {		
	}

	@Override
	public Set<Class<? extends Component>> getDependencyList() {
		return DEPENDENCIES;
	}
	
	
}
