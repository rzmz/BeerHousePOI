package ee.ut.math.tvt.SiirisTeam;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.SiirisTeam.utils.ImagePanel;

public class Intro {

	private static final Logger log = Logger.getLogger(Intro.class);

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		log.info("Intro main method invoked");
		
		IntroUI ui = new IntroUI();
		
		ui.displayTeamInfo();
		
		testImage();
		
	}
	
	public static void testImage(){
		JFrame frame = new JFrame("Should be logo");
		
		// exit the program when window is closed by the user
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.setSize(640, 480);
		frame.setLocation(900, 300);
		ImagePanel logoPanel = new ImagePanel("assets/logo.jpg");
		frame.add(logoPanel);
		frame.setVisible(true);
	}
	
}
