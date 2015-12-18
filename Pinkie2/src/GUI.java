import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class GUI extends Canvas {
	static GUI game;
	
	public static void main(String[] arg){
	   game = new GUI();
	}
	
	public GUI(){
		HelpFrame helpFrame = new HelpFrame();
		Panel frame = new Panel();

	}
	 
}
