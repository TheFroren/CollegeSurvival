package froren.collegesurvival.entities.effects;

import froren.collegesurvival.entities.Component;

public abstract class Effect {
	protected double durationLeft;

	public Effect(double duration) {
		durationLeft = duration;
	}
	
	public double getDurationLeft(){
		return durationLeft;
	}

	public boolean apply(double delta) {
		durationLeft -= delta;
		return durationLeft <= 0;
	}

	public abstract void setTarget(Component target);
	public abstract Class<? extends Component> getTargetType();
}
