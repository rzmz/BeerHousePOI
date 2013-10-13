package ee.ut.math.tvt.SiirisTeam;

import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.SiirisTeam.utils.ImagePanel;

public class Intro {

	private final static String versionPropertiesFile = "config/version.properties";
	
	private static final Logger log = Logger.getLogger(Intro.class);

	public static void main(String[] args) {
		
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
	
	public static void updateVersion(){
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(Intro.versionPropertiesFile));
			String revisionNumber = prop.getProperty("build.revision.number");
			String minorNumber = prop.getProperty("build.minor.number");
			String majorNumber = prop.getProperty("build.major.number");

			try{
				Integer revNr = Integer.parseInt(revisionNumber);
				revNr++;
				prop.setProperty("build.revision.number",  revNr.toString());
				prop.setProperty("build.number", String.format("%s.%s.%s", majorNumber, minorNumber, revNr.toString()));
				prop.store(new FileOutputStream(Intro.versionPropertiesFile), null);
			} catch(NumberFormatException ex){
				log.error("Error reading property build.revision.number", ex);
			}
			
		} catch(IOException e){
			log.error("Error reading properties file version.properties", e);
		}
	}
	
}
