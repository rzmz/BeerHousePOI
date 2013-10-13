package ee.ut.math.tvt.SiirisTeam;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Intro {

	private static final Logger log = Logger.getLogger(Intro.class);

	public static void main(String[] args) {
		
		log.info("Intro main method invoked");
		
		IntroUI ui = new IntroUI();
		ui.displayTeamInfo();
		
	}
	
	public static void updateVersion(){
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("version.properties"));
			System.out.println(String.format("Build revision number: %s", prop.getProperty("build.revision.number")));
			System.out.println(String.format("Build minor number: %s", prop.getProperty("build.minor.number")));
			System.out.println(String.format("Build major number: %s", prop.getProperty("build.major.number")));
		} catch(Exception e){
			log.error("Error reading properties file version.properties", e);
		}
	}
	
}
