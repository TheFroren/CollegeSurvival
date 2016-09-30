package froren.collegesurvival;

import javax.swing.JFrame;

public class CollegeSurvival extends JFrame{
	
	static final String TITLE = "College Survival v2";
	
	private void run(){
		
		
		
		
		
		setTitle(TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	private void loop(){
		
	}
	
	public static void main (String... args){
		new CollegeSurvival().run();
	}
}
