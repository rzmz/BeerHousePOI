package ee.ut.math.tvt.SiirisTeam;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class IntroUI {

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
		JLabel prooviNimi = new JLabel("xxx");
		teamNamePanel.add(teamName);
		teamNamePanel.add(prooviNimi);
		raam.add(teamNamePanel);

		
		JPanel teamLeaderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel teamLeader = new JLabel("Team leader: ");
		JLabel prooviNimi2 = new JLabel("xxx");
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
		JLabel prooviliikmed = new JLabel("xxx");
		membersPanel.add(membersLabel);
		membersPanel.add(prooviliikmed);
		raam.add(membersPanel);

		JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel logoLabel = new JLabel("Team logo:");
		JLabel proovilogo = new JLabel("xxx");
		logoPanel.add(logoLabel);
		logoPanel.add(proovilogo);
		raam.add(logoPanel);
		
		JPanel versionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel versionLabel = new JLabel("Version number:");
		JLabel proovivers = new JLabel("xxx");
		versionPanel.add(versionLabel);
		versionPanel.add(proovivers);
		raam.add(versionPanel);

	}
}
