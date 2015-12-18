import java.util.Random;

public class Enemy {
	private int eXMove;
	private int eYMove;
	public int xEnemy, yEnemy;
	public Random r;
	private int tempSpeed;
	private int AI;
	public int getxEnemy() {
		return xEnemy;
	}
	public int getyEnemy() {
		return yEnemy;
	}
	public void setxEnemy() {
		xEnemy = 200 + r.nextInt(540);

	}
	public void setyEnemy() {
		yEnemy = 200 + r.nextInt(540);
	}
	public Enemy(){
		r = new Random();
		tempSpeed = r.nextInt(5);
		AI = r.nextInt(2);
	}
	public void moveEnemyY(int moveEnemy) {
		yEnemy = moveEnemy;
	}
	public void moveEnemyX(int moveEnemy) {
		xEnemy = moveEnemy;
	}
	public void regularEnemyAI(int x, int y) {
		int tempSpeed = r.nextInt(5);
		if(this.getxEnemy()> x){
			eXMove = -tempSpeed;
			eYMove = 0;
		}
		else if(this.getxEnemy()< x){
			eXMove = tempSpeed;
			eYMove = 0;

		}
		else if(this.getyEnemy()> y){
			eXMove = 0;
			eYMove = -tempSpeed;
		}
		else if(this.getyEnemy()< y){
			eXMove = 0;
			eYMove = tempSpeed;
		}
		this.moveEnemyX(this.getxEnemy()+eXMove);
		this.moveEnemyY(this.getyEnemy()+eYMove);
	}
	public void backandforthEnemyAI(int x, int y) {
		int tempSpeed = r.nextInt(5);
		if(this.getxEnemy()> x){
			eXMove = -tempSpeed;
			eYMove = 0;
		}
		else if(this.getxEnemy()< x){
			eXMove = tempSpeed;
			eYMove = 0;

		}
		this.moveEnemyX(this.getxEnemy()+eXMove);
	}
	public void moveEnemyAI(int x, int y) {
		switch(AI) {
		case 0: regularEnemyAI(x, y);
				break;
		case 1:	backandforthEnemyAI(x, y);
				break;
		}
	}
}