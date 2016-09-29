package froren.collegesurvival;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageLoader {
	private final String root;
	
	private final Map<String,BufferedImage> images = new HashMap<>();
	private final BufferedImage defaultImage;
	
	public ImageLoader(String root, BufferedImage defaultImage) {
		this.root = root;
		this.defaultImage = defaultImage;
	}
	
	public void loadImage(String path, String name){
		try {
			images.put(name, ImageIO.read(Class.class.getResourceAsStream(root + path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadExternalImage(String path, String name){
		try {
			images.put(name, ImageIO.read(new File(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(String name){
		return images.getOrDefault(name, defaultImage);
	}
	
}
