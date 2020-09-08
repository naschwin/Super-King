package com.project.game.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.project.game.framework.GameObject;
import com.project.game.framework.ObjectId;
import com.project.game.window.Animation;
import com.project.game.window.Game;
import com.project.game.window.Handler;

public class Enemy extends GameObject{
	private int width = 32, height = 32;
	private Handler handler;
    private int health;
	private boolean died = false;
	
	private static Animation enemyIdleF, enemyIdleR, enemyDieAni;
	

	public Enemy(float x, float y, ObjectId id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		health = 10;
		enemyIdleF = new Animation(10, Game.getTex().enemy_right);
		enemyIdleR = new Animation(10, Game.getTex().enemy_left);
		enemyDieAni = new Animation(10, Game.getTex().enemy_die_r);
	}

	
	
	public static Animation getEnemyIdleF() {
		return enemyIdleF;
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		
		Collision(object);

		enemyIdleF.runAnimation();
		enemyIdleR.runAnimation();
		enemyDieAni.runAnimation();
	}

	@Override
	public void render(Graphics g) {
		enemyIdleF.drawAnimation(g,(int) x,(int) y);
		enemyIdleR.drawAnimation(g,(int) x,(int) y);
		if(died)
			enemyDieAni.drawAnimation(g,(int) x,(int) y);
	}

	private void Collision(LinkedList<GameObject> object) {
		for (int i  = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - height;
					velY = 0;
					falling = false;
					jumping = false;
				}
				else {
					falling = true;
				}
					
			}

			
			if(tempObject.getId() == ObjectId.Bullet) {
				if(getBounds().intersects(tempObject.getBounds())){
				   getHit();
				   handler.object.remove(tempObject);
				}
					
			}
			
		}
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	@Override
	protected void getHit() {
		this.health--;
		if(this.health < 0) {
			died = true;
			handler.object.remove(this);
		}
	}
	
}
