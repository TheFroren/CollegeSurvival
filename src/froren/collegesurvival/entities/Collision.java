package froren.collegesurvival.entities;

import java.util.HashSet;
import java.util.Set;

import froren.collegesurvival.handlers.CollisionHandler;

public abstract class Collision extends Component{
	
	protected static final Set<Class<? extends Component>> DEPENDENCIES = new HashSet<>(0);

	static{
		DEPENDENCIES.add(Spatial.class);
	}
	
	protected CollisionHandler collisionHandler;
	
	public void setCollisionHandler(CollisionHandler collisionHandler) {
		this.collisionHandler = collisionHandler;
	}

	@Override
	public void destroy() {
		collisionHandler.removeComponent(this);
	}
	
	public abstract void collidedWith(Collision c);
	
	public Spatial getSpatial(){
		return (Spatial) linkedDependencies.get(Spatial.class);
	}
}
