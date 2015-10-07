import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.Rectangle; 

public class Unit extends Entity{

	private int startX;
	int life = 1;
	int val = 1;
	
	public Unit(int x, int y){
	
		super(x,y);
		startX = x;
	}
	
	public void update(int value){
		
		this.val = value;
		
		x += value;
		checkCollisions();
		checkOffScreen();
	}
	
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics2D g2d){
	
		g2d.drawImage(getUnitImg(), x, y, null);
		//g2d.draw(getBounds());
	
	}

	public Image getUnitImg(){
	
		ImageIcon ic = new ImageIcon("unit.png");
		return ic.getImage();
	
	}
	
	public void checkCollisions(){
	
		for(int i=0; i<GameFrame.getTowerList().size(); i++){
		
			Tower t = GameFrame.getTowerList().get(i);
		
			if(getBounds().intersects(t.getBounds())){

				//GameFrame.removeFireBall(f);
				//life = life - 1;
				this.val = 0;
				
				if(life == 0){
				
					GameFrame.removeUnit(this);
					
				}
			}
		
		}
	
	}
	
	public void checkOffScreen(){
	
		if(x >= 700){
		
			x = startX;
			//GameFrame.removeUnit(this);
		}
	
	}
	
	public Rectangle getBounds(){
	
		return new Rectangle(x, y, getUnitImg().getWidth(null), getUnitImg().getHeight(null));
	
	}
	
}