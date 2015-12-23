import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Panel extends JPanel {
	private ImageIcon goat;
	public kListener kListener = new kListener();
	private Color pinkieColor;
	private ArrayList<Enemy> enemies;
	private Enemy e1;
	boolean badCollision = false, goodCollision = false;
	public int x = 8, y = 8, xMove = 0, yMove = 0, level, eXMove=0, eYMove=0;
	double x2 = 22, y2 = 13, x3 = 32, y3 = 13, x4 = 23, y4 = 23;
	private JButton playAgain;
	private Random r = new Random();
	public Rectangle rect, rect1;
	private ArrayList<Rectangle> eRectangle;
	boolean running = false;
	private JLabel youWin, gameOver;
	private bListener listen;
	private JFrame frame;
	private ImageIcon i1, i2;
	
	public Panel() {
		frame = new JFrame();
		frame.add(this);
		frame.setTitle("Pinkie");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
	    frame.setResizable(false);
	    frame. setVisible(true);  
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation(dimension.width/2-400, dimension.height/2-400);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(kListener);
		setFocusTraversalKeysEnabled(false);
		listen = new bListener();
		init();
	}
	
	public void step() {
		if(x<0 || x>760) {
			xMove = -xMove;
		}
		if(y<0 || y>760) {
			yMove = -yMove;
		}
		for(Enemy enemy: enemies){
			enemy.moveEnemyAI(x, y);
		}
		
		x += xMove;
		x2 += xMove;
		x3 += xMove;
		x4 += xMove;
		y += yMove;
		y2 += yMove;
		y3 += yMove;
		y4 +=yMove;
		collision();
	}
	
	public void gameOver(){
		setFocusable(true);
		setBackground(Color.white);
		i1 = new ImageIcon("GameOver.png");
		gameOver = new JLabel(i1);
		playAgain = new JButton("Play Again?");
		playAgain.setFocusable(true);
		playAgain.addActionListener(listen);
		add(gameOver);
		add(Box.createVerticalGlue());
		add(playAgain);

		validate();

	}
	public void youWin(){
		setFocusable(true);
		i2 = new ImageIcon("youWin.png");
		youWin = new JLabel(i2);
		setBackground(Color.white);
		playAgain = new JButton("Play Again?");
		playAgain.addActionListener(listen);
		playAgain.setFocusable(true);
		add(playAgain);
		add(youWin);
		validate();
	}
	public void init(){
		pinkieColor = Color.PINK;
		level = 1;
		e1 = new Enemy();
		enemies = new ArrayList<Enemy>();
		eRectangle = new ArrayList<Rectangle>();
		enemies.add(e1);
		setEnemies();
		rect1 = new Rectangle(e1.getxEnemy(), e1.getyEnemy(), 50, 50);
		eRectangle.add(rect1);

	}
	public void setEnemies(){
		for(Enemy enemy: enemies){
			enemy.setxEnemy();
			enemy.setyEnemy();
		}

	}
	public void restartGame(){
		enemies.clear();
		eRectangle.clear();
		  x = 8; y = 8; xMove = 0; yMove = 0; eXMove=0; eYMove=0;
		 x2 = 22; y2 = 13; x3 = 32; y3 = 13; x4 = 23; y4 = 23;

		
	}
	
	public void totalRestart(){
		this.removeAll();
		setBackground(Color.BLACK);
		badCollision = false; goodCollision = false;
		setFocusable(true);
		addKeyListener(kListener);
		setFocusTraversalKeysEnabled(false);
		restartGame();
		init();
		validate();
		repaint();
	}
	
	public void initLevel(){
		restartGame();
		int enemyNum = level;
		for(int i = 0; i < enemyNum; i++){
			enemies.add(new Enemy());
		}
		setEnemies();
		for(Enemy e: enemies){
			eRectangle.add(new Rectangle(e.getxEnemy(), e.getyEnemy(), 50, 50));

		}
	}

	public void up() {
		xMove = 0;
		yMove = -4;
		pinkieColor = Color.PINK;
		running = true;
	}

	public void down() {
		xMove = 0;
		yMove = 4;
		pinkieColor = Color.PINK;
		running = true;

	}

	public void right() {
		xMove = 4;
		yMove = 0;
		pinkieColor = Color.PINK;
		running = true;

	}

	public void left() {
		running = true;
		xMove = -4;
		yMove = 0;
		pinkieColor = Color.PINK;

	}
	public void stopIt(){
		pinkieColor = Color.red;
		xMove = 0;
		yMove = 0;
	}

	private class kListener 
	implements KeyListener{
		public void keyPressed(KeyEvent e) {
			int input = e.getKeyCode();

			if (input == KeyEvent.VK_UP) {
				up();
				pinkieColor = Color.pink;

			}

			else if (input == KeyEvent.VK_DOWN) {
				down();
				pinkieColor = Color.pink;

			}

			else if (input == KeyEvent.VK_RIGHT) {
				right();
				pinkieColor = Color.pink;
			}

			else if (input == KeyEvent.VK_LEFT) {
				left();
				pinkieColor = Color.pink;
			}

		}

		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() == 's'){
				totalRestart();
			}
		}

		public void keyReleased(KeyEvent e) {


		}
	}


	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		Pinkie(g);
		Enemies(g);
		Door(g);

		if(badCollision == true){
			xMove = 0;
			yMove = 0;
			eYMove = 0;
			eXMove = 0;
			gameOver();
		}
		else if(goodCollision == true){
			if(level<5){
				this.level = level+1;
			}
			else if(level>=5){
				youWin();

			}
			initLevel();
			goodCollision = false;
		}
	}
	private void Door(java.awt.Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(785, 710, 10, 70);

	}

	private void Pinkie(java.awt.Graphics g) {
		rect1 = new Rectangle(x, y, 40, 40);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g.fillRect(x, y, 40, 40);
		g2.fill(rect1);
		g2.setColor(pinkieColor);
		g2.fillArc(x, y, 40, 80, 0, 180);
		g2.setColor(Color.WHITE);
		g2.fill(new Ellipse2D.Double(x2,  y2,  4,  4));
		g2.fill(new Ellipse2D.Double(x3,  y3,  4,  4));
		g2.fill(new Ellipse2D.Double(x4,  y4,  10,  6));


	}

	private void Enemies(java.awt.Graphics g){
		goat = new ImageIcon("goat.png");
		for(Enemy enemy: enemies){
			g.setColor(Color.black);
			g.fillRect(enemy.getxEnemy(), enemy.getyEnemy(), 50, 50);
			goat.paintIcon(this, g, enemy.getxEnemy(), enemy.getyEnemy());
		}
	}

	void collision() {
		Rectangle rectangle1 = new Rectangle(x, y, 40, 40).getBounds(); 
		Rectangle rectangle2 = new Rectangle(785, 710, 10, 70).getBounds();
		if(rectangle1.intersects(rectangle2)||rectangle2.intersects(rectangle1)){
			goodCollision = true;
		}
		else{
			for(Enemy enemy: enemies){
				Rectangle rect1 = new Rectangle(enemy.getxEnemy(), enemy.getyEnemy(), 50, 50);

				if(rectangle1.intersects(rect1)||rect1.intersects(rectangle1)) {
					badCollision = true;
				}

			}
		}

	}
	
	private class bListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			totalRestart();
			// TODO Auto-generated method stub
			
		}
			
		}
	}


