package ee.ut.math.tvt.SiirisTeam;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

public class Intro {

	private static final Logger log = Logger.getLogger(Intro.class);

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		log.info("Intro main method invoked");
		
		IntroUI ui = new IntroUI();
		
		ui.displayTeamInfo();		
	}		
}
