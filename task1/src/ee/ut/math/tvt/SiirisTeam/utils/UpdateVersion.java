package ee.ut.math.tvt.SiirisTeam.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.SiirisTeam.Intro;


public class UpdateVersion {
	private final static String versionPropertiesFile = "config/version.properties";
	private static final Logger log = Logger.getLogger(Intro.class);

	public static void main(String[] args) {
		updateVersion();
	}
	
	public static void updateVersion(){
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(UpdateVersion.versionPropertiesFile));
			String revisionNumber = prop.getProperty("build.revision.number");
			String minorNumber = prop.getProperty("build.minor.number");
			String majorNumber = prop.getProperty("build.major.number");

			try{
				Integer revNr = Integer.parseInt(revisionNumber);
				revNr++;
				prop.setProperty("build.revision.number",  revNr.toString());
				prop.setProperty("build.number", String.format("%s.%s.%s", majorNumber, minorNumber, revNr.toString()));
				prop.store(new FileOutputStream(UpdateVersion.versionPropertiesFile), null);
			} catch(NumberFormatException ex){
				log.error("Error reading property build.revision.number", ex);
			}
			
		} catch(IOException e){
			log.error("Error reading properties file version.properties", e);
		}
	}
}
