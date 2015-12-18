import java.util.Random;

public class Enemy {
	public int xEnemy, yEnemy;
	public Random r;
	public int getxEnemy() {
		return xEnemy;
	}
	public void setxEnemy() {
		this.xEnemy = 200 + r.nextInt(540);

	}
	public int getyEnemy() {
		return yEnemy;
	}
	public void setyEnemy() {
		this.yEnemy = 200 + r.nextInt(540);
	}
	public Enemy(){
		r = new Random();
		
	}
	public void moveEnemyY(int moveEnemy){
		this.yEnemy = moveEnemy;
	}
	public void moveEnemyX(int moveEnemy){
		this.xEnemy = moveEnemy;
	}
	
}
