package ee.ut.math.tvt.SiirisTeam;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class IntroUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public Properties version;
	public Properties application;
	
	public IntroUI() throws FileNotFoundException, IOException {
		super("Information about the team");
		version = new Properties();
		application = new Properties();
		version.load(new FileInputStream("config/version.properties"));
		application.load(new FileInputStream("config/application.properties"));
		displayTeamInfo();
	}

	private void displayTeamInfo() throws IOException{
		
		// exit the program when window is closed by the user
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setLocation(800, 200);
		setLayout(new GridLayout());
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		JPanel teamNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel teamName = new JLabel("Team name: ");
		JLabel prooviNimi = new JLabel(application.getProperty("team.name"));
		teamNamePanel.add(teamName);
		teamNamePanel.add(prooviNimi);
		mainPanel.add(teamNamePanel);

		
		JPanel teamLeaderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel teamLeader = new JLabel("Team leader: ");
		JLabel prooviNimi2 = new JLabel(application.getProperty("team.leader"));
		teamLeaderPanel.add(teamLeader);
		teamLeaderPanel.add(prooviNimi2);
		mainPanel.add(teamLeaderPanel);
		
		JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel emailLabel = new JLabel("Team leader email:");
		JLabel proovimeil = new JLabel(application.getProperty("team.leader_email"));
		emailPanel.add(emailLabel);
		emailPanel.add(proovimeil);
		mainPanel.add(emailPanel);
		
		JPanel membersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel membersLabel = new JLabel("Team members:");
		JLabel prooviliikmed0 = new JLabel(application.getProperty("team.members.0"));
		JLabel prooviliikmed1 = new JLabel(application.getProperty("team.members.1"));
		JLabel prooviliikmed2 = new JLabel(application.getProperty("team.members.2"));
		membersPanel.add(membersLabel);
		membersPanel.add(prooviliikmed0);
		membersPanel.add(prooviliikmed1);
		membersPanel.add(prooviliikmed2);
		mainPanel.add(membersPanel);

		JPanel logoPanel = new JPanel();
		logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel logoLabel = new JLabel("Team logo:");
		
		BufferedImage logoImage = ImageIO.read(new File(application.getProperty("team.logo")));
		JLabel logoImageLabel = new JLabel(new ImageIcon(logoImage));
		
		logoPanel.add(logoLabel);
		logoPanel.add(logoImageLabel);
		mainPanel.add(logoPanel);		
		
		JPanel versionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel versionLabel = new JLabel("Version number:");
		JLabel proovivers = new JLabel(version.getProperty("build.number"));
		versionPanel.add(versionLabel);
		versionPanel.add(proovivers);
		mainPanel.add(versionPanel);
		
		add(mainPanel);
		
		pack();
	}
}
