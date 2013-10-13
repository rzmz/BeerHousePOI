package ee.ut.math.tvt.SiirisTeam.utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

public class ImagePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ImagePanel.class);

	private BufferedImage _image = null;

	public ImagePanel(String imageSrc){
		
		try {
			_image = ImageIO.read(new File(imageSrc));
		} catch (IOException ex) {
			log.error("Error reading image: " + imageSrc, ex);
		}
		
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(_image != null){
            g.drawImage(_image, 0, 0, null);        	
        }
    }
}
