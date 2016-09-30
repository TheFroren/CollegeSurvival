package froren.collegesurvival.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import froren.collegesurvival.entities.Collision;
import froren.collegesurvival.entities.Spatial;

public class CollisionHandler implements ComponentHandler{

	private List<Collision> collisionComponents = new ArrayList<>();	
	
	public void removeComponent(Collision c){
		collisionComponents.remove(c);
	}
	
	@Override
	public void handle(double delta) {
		ListIterator<Collision> iter;
		Collision firstColl;
		Collision secondColl;
		Spatial firstSpatial;
		Spatial secondSpatial;
		
		for(int i = 0; i < collisionComponents.size()-1; i++){
			firstColl = collisionComponents.get(i);
			firstSpatial = firstColl.getSpatial();
			
			iter = collisionComponents.listIterator(i+1);
			
			while(iter.hasNext()){
				secondColl = iter.next();
				secondSpatial = secondColl.getSpatial();
				
				if (Math.sqrt(((secondSpatial.x - firstSpatial.x) * (secondSpatial.x - firstSpatial.x))
							+ ((secondSpatial.y - firstSpatial.y) * (secondSpatial.y - firstSpatial.y)))
							< (firstSpatial.radius + secondSpatial.radius)){
					firstColl.collidedWith(secondColl);
					secondColl.collidedWith(firstColl);
				}
			}
		}
		
		
	}	

}
