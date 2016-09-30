package froren.collegesurvival.handlers;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import froren.collegesurvival.entities.Entity;

public class World {
	private List<Entity> entities = new ArrayList<>();
	
	private final ComponentHandler[] preHandlers;
	private final ComponentHandler[] postHandlers;
	
	private Deque<Entity> newEntities = new LinkedList<>();
	private Deque<Entity> deadEntities = new LinkedList<>();
	
	public World(ComponentHandler[] preHandlers, ComponentHandler[] postHandlers) {
		this.preHandlers = preHandlers;
		this.postHandlers = postHandlers;
	}
	
	public Entity createEntity(){
		Entity e = new Entity(this);
		entities.add(e);
		return e;
	}
	
	public void addEntity(Entity e){
		newEntities.addLast(e);
	}
	
	public void deleteEntity(Entity e){
		deadEntities.addLast(e);
	}
	
	public void loop(double delta){
		for(ComponentHandler handler : preHandlers)
			handler.handle(delta);
		
		for(Entity entity : entities)
			entity.invokeComponents(delta);
		
		for(ComponentHandler handler : postHandlers)
			handler.handle(delta);
		
		while(!newEntities.isEmpty())
			entities.add(newEntities.pop());
		
		while(!deadEntities.isEmpty())
			entities.remove(deadEntities.pop());
		
	}
}
