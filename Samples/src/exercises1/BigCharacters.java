package exercises1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import javax.swing.JFrame;

public class BigCharacters {

	public static void main(String[] args) {
		
		// FIXME some idea what needs fixing
		
		final BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_BINARY);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, 100, 100);
		graphics.setColor(Color.black);
		graphics.drawString("hello".toUpperCase(), 0, 100);
		
		JFrame window = new JFrame() {
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				g.drawImage(image, 0, 0, null);
			}
		};
		window.setSize(100, 100);
		window.setVisible(true);
		
		image.getGraphics().setColor(Color.red);
		int y = 50;
		for (int x = 0; x < image.getWidth(); x++) {
			int rgb = image.getRGB(x, y);
			image.getGraphics().fillRect(x, y, 1, 1);	
			System.out.println(rgb);
		}
		window.repaint();
		
		
	}
	
}
