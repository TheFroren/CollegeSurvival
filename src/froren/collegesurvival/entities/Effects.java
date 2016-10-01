package froren.collegesurvival.entities;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import froren.collegesurvival.entities.effects.Effect;

public class Effects extends Component {

	private Set<Class<? extends Component>> effectTargets = new HashSet<Class<? extends Component>>();

	private HashMap<Class<? extends Effect>, Effect> effects = new HashMap<>();
	private Deque<Effect> wornOutEffects = new LinkedList<>();

	@SafeVarargs
	public Effects(Class<? extends Component>... effectTargets) {
		for (Class<? extends Component> c : effectTargets)
			this.effectTargets.add(c);
	}

	public void addEffect(Effect e){
		e.setTarget(linkedDependencies.get(e.getTargetType()));
		effects.put(e.getClass(), e);		
	}

	@Override
	public void invoke(double delta) {
		for (Effect e : effects.values()) {
			if (e.apply(delta))
				wornOutEffects.addLast(e);
		}

		while (!wornOutEffects.isEmpty())
			effects.remove(wornOutEffects.pop().getClass());
	}

	@Override
	public void destroy() {
	}

	@Override
	public Set<Class<? extends Component>> getDependencyList() {
		return effectTargets;
	}

}
