 import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends Canvas {
	
	public JFrame frame;
	private JPanel startScreen;

	public Frame(){
		frame = new JFrame();
		Panel panel = new Panel();
		frame.add(panel);
		frame.setTitle("Pinkie");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
	    frame.setResizable(false);
	    frame. setVisible(true);  
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation(dimension.width/2-400, dimension.height/2-400);

	    
	}

	
	

}