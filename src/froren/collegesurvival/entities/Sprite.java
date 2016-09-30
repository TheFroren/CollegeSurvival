package froren.collegesurvival.entities;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import froren.collegesurvival.handlers.JPanelRenderer;

public class Sprite extends Component{

	private static final Set<Class<? extends Component>> DEPENDENCIES = new HashSet<>();
	
	static{
		DEPENDENCIES.add(Spatial.class);
	}
	
	private final JPanelRenderer renderer;
	private BufferedImage sprite;
	private AffineTransform transform = new AffineTransform();
	
	public Sprite(JPanelRenderer renderer) {
		this.renderer = renderer;
	}
	
	public void setSprite(BufferedImage img){
		sprite = img;
	}
	
	public BufferedImage getSprite(){
		return sprite;
	}
	
	public AffineTransform getTransform(){
		return transform;
	}
	
	@Override
	public void invoke(double delta) {
		Spatial pos = (Spatial) linkedDependencies.get(Spatial.class);
		
		transform.setToRotation(pos.angle);
		transform.translate(pos.x - (sprite.getWidth()*0.5), pos.y - (sprite.getHeight()*0.5));
	}

	@Override
	public void destroy() {
		renderer.removeSprite(this);
	}

	@Override
	public Set<Class<? extends Component>> getDependencyList() {
		return DEPENDENCIES;
	}

}
