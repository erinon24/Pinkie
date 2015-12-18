import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class HelpFrame extends JFrame {
	private JRadioButton pink, orange, blue;
	private JButton restart;
	private Color pinkieColor;
	private JPanel pan;
	
	public HelpFrame(){
	setTitle("Help Information");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pinkieColor = Color.PINK;
	setSize(300, 800);
    setResizable(false);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(dim.width/2+400, dim.height/2-400);
    setVisible(true);  
    pan = new JPanel();
    pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
    pan.setBackground(pinkieColor);
    JTextArea help = new JTextArea("Pinkie \n  A restless spirit trapped inside a haunted house \n "
    		+ " Save him from the Ghoasts by guiding him towards the light \n"
    		+ "  Manuver him by using the arrow keys\n"
    		+ "  Pinkie only has one life, but there are five levels\n"
    		+ "  Good luck!", 12, 30);
    JTextArea funny = new JTextArea("Too much pink?", 2, 2);
    funny.setForeground(Color.white);
    funny.setFont(new Font("Courier", Font.PLAIN, 15));  
    funny.setEditable(false);  
    funny.setLineWrap(true);  
    funny.setWrapStyleWord(true);
    funny.setOpaque(false);
    help.setForeground(Color.white);
    help.setFont(new Font("Courier", Font.PLAIN, 15));  
    help.setEditable(false);  
    help.setLineWrap(true);  
    help.setWrapStyleWord(true);
    help.setOpaque(false);
    
    pan.setForeground(Color.WHITE);
    pan.setFont(new Font("Courier", Font.PLAIN, 15));
    
    pink = new JRadioButton("Pinkie!");
    pink.setForeground(Color.WHITE);
    pink.setFont(new Font("Courier", Font.PLAIN, 15));  
    pink.setBackground (pinkieColor);
    orange = new JRadioButton("Orangie!");
    orange.setForeground(Color.WHITE);
    orange.setFont(new Font("Courier", Font.PLAIN, 15));  
    orange.setBackground (pinkieColor);
    blue = new JRadioButton("Bluie!");
    blue.setForeground(Color.WHITE);
    blue.setBackground (pinkieColor);
    blue.setFont(new Font("Courier", Font.PLAIN, 15));  

    pink.setSelected(true);
    
	ButtonGroup colors = new ButtonGroup();  
	colors.add(pink);  
	colors.add(orange);  
	colors.add(blue);
	
	cListen colorChange = new cListen();
	pink.addItemListener(colorChange);
	blue.addItemListener(colorChange);
	orange.addItemListener(colorChange);
	
	restart =  new JButton("Restart");
    
    
    pan.add(help);
    pan.add(funny);
    pan.add(pink);
    pan.add(blue);
    pan.add(orange);
    add(pan);
    pack();


	}
	private class cListen implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == pink) {
				pinkieColor = Color.pink;
			    blue.setBackground (pinkieColor);
			    orange.setBackground (pinkieColor);
			    pan.setBackground(pinkieColor);

			    pink.setBackground (pinkieColor);

			}
			else if (e.getSource() == orange)
			{
				pinkieColor = Color.orange;
			    blue.setBackground (pinkieColor);
			    orange.setBackground (pinkieColor);
			    pan.setBackground(pinkieColor);

			    pink.setBackground (pinkieColor);

			}
			else if (e.getSource()== blue)
			{
				pinkieColor = new Color(161, 202, 241);
			    blue.setBackground (pinkieColor);
			    orange.setBackground (pinkieColor);
			    pan.setBackground(pinkieColor);

			    pink.setBackground (pinkieColor);

			}
			pan.validate();
			pan.repaint();
		}

	}
}
