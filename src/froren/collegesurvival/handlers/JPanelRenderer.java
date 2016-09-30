package froren.collegesurvival.handlers;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import froren.collegesurvival.entities.Component;
import froren.collegesurvival.entities.Sprite;

public class JPanelRenderer extends JPanel implements ComponentHandler{
	private static final long serialVersionUID = 3684305562348494959L;
	
	private final List<Sprite> sprites = new ArrayList<>();
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		synchronized(sprites){
			for(Sprite s : sprites)
				g2d.drawImage(s.getSprite(), s.getTransform(), null);
		}
	}

	public Component createRenderComponent() {
		Sprite s = new Sprite(this);
		
		synchronized (sprites){ 
			sprites.add(s);
		}
			
		return s;
	}
	
	public void removeSprite(Sprite s) {
		synchronized (sprites) {
			sprites.remove(s);
		}
	}

	@Override
	public void handle(double delta) {
		repaint();
		
	}
	
}
