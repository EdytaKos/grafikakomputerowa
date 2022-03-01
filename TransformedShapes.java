

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;




public class TransformedShapes extends JPanel {

	

	private Graphics2D g2; 


	private void resetTransform() {
		g2.setTransform(new AffineTransform());
	}

	

	private void triangle() {
		int [] xpoints = {50,150,250};
	     int [] ypoints  = {250,150,250};
	     int nPoints =3;
	     g2.fillPolygon(xpoints, ypoints, nPoints);

	}

 private void square() {
		g2.fillRect(-50,-50,100,100);
	}
 




	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

//góra
		g2.setColor(Color.red);
		g2.scale(25,0.5);
		square();
	
//dół
		g2.setColor(Color.red);
		g2.translate(1100,1170);
		g2.scale(25,0.5);
		square();
		
		
		resetTransform();
//ukos		
		g2.setColor(Color.red);
		g2.rotate(Math.toRadians(45));
		g2.scale(25,0.5);
		square();
	
		
		resetTransform();
 
		

		
		
	}
		
		


	public TransformedShapes() {
		setPreferredSize(new Dimension(600,600) );
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
	}

	public static void main(String[] args)  {
		JFrame window = new JFrame("Drawing With Transforms");
		window.setContentPane(new TransformedShapes());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}
