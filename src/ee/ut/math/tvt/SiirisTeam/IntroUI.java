package ee.ut.math.tvt.SiirisTeam;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class IntroUI {
	
	public Properties version;
	public Properties application;
	
	public IntroUI() throws FileNotFoundException, IOException {
		version = new Properties();
		application = new Properties();
		version.load(new FileInputStream("version.properties"));
		application.load(new FileInputStream("application.properties"));
	}

	public void displayTeamInfo(){
		
		JFrame raam = new JFrame("Information about the team");
		
		// exit the program when window is closed by the user
		raam.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		raam.setSize(500, 200);
		raam.setLocation(800, 200);
		raam.setVisible(true);
		raam.setLayout(new GridLayout(6,1));
		
		JPanel teamNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel teamName = new JLabel("Team name: ");
		JLabel prooviNimi = new JLabel(application.getProperty("team.name"));
		teamNamePanel.add(teamName);
		teamNamePanel.add(prooviNimi);
		raam.add(teamNamePanel);

		
		JPanel teamLeaderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel teamLeader = new JLabel("Team leader: ");
		JLabel prooviNimi2 = new JLabel(application.getProperty("team.leader"));
		teamLeaderPanel.add(teamLeader);
		teamLeaderPanel.add(prooviNimi2);
		raam.add(teamLeaderPanel);
		
		JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel emailLabel = new JLabel("Team leader email:");
		JLabel proovimeil = new JLabel("xxx");
		emailPanel.add(emailLabel);
		emailPanel.add(proovimeil);
		raam.add(emailPanel);
		
		JPanel membersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel membersLabel = new JLabel("Team members:");
		JLabel prooviliikmed = new JLabel(application.getProperty("team.members"));
		membersPanel.add(membersLabel);
		membersPanel.add(prooviliikmed);
		raam.add(membersPanel);

		JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel logoLabel = new JLabel("Team logo:");
		JLabel proovilogo = new JLabel(application.getProperty("team.logo"));
		logoPanel.add(logoLabel);
		logoPanel.add(proovilogo);
		raam.add(logoPanel);
		
		JPanel versionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel versionLabel = new JLabel("Version number:");
		JLabel proovivers = new JLabel(application.getProperty("version.number"));
		versionPanel.add(versionLabel);
		versionPanel.add(proovivers);
		raam.add(versionPanel);

	}
}
