package froren.collegesurvival.entities.effects;

import froren.collegesurvival.entities.Component;
import froren.collegesurvival.entities.Spatial;

public class SpeedModifier extends Effect{

	private double modifier;
	private Spatial target;
	
	public SpeedModifier(double duration, double modifier) {
		super(duration);
	}

	@Override
	public boolean apply(double delta) {
		target.x += target.vx * modifier * delta;
		target.y += target.vy * modifier * delta;
		return super.apply(delta);
	}

	@Override
	public Class<? extends Component> getTargetType() {
		return Spatial.class;
	}

	@Override
	public void setTarget(Component target) {
		this.target = (Spatial) target;		
	}

	

}
