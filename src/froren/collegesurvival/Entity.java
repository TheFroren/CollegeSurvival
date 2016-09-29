package froren.collegesurvival;

import java.util.ArrayList;
import java.util.List;

public class Entity {
	private List<Component> components = new ArrayList<>();
	
	public void invokeComponents(float delta){
		synchronized(components){
			for(Component c : components)
				c.invoke(delta);
		}
	}
	
	public void addComponent(Component c){
		
	}
	
	public void destroy(){
		synchronized(components){
			for(Component c : components)
				c.destroy();
		}
	}
}
