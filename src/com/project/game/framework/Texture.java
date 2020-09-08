package com.project.game.framework;

import java.awt.image.BufferedImage;
import com.project.game.window.BufferedImageLoader;

public class Texture {

	private SpriteSheet ps, psr;
	
	public BufferedImage player_idle_f[], player_run_f[], player_idle_r[], player_run_r[],
						 enemy_right[], enemy_left[], enemy_die_r[], enemy_die_f[],
						 flag[], button1[], button2[], button3[], help, saw;

	private BufferedImageLoader loader;
	
	public Texture() {
		player_idle_f = new BufferedImage[2];
		player_run_f = new BufferedImage[5];
		player_idle_r = new BufferedImage[2];
		player_run_r = new BufferedImage[5];
		enemy_right = new BufferedImage[3];
		enemy_left = new BufferedImage[3];
		enemy_die_r = new BufferedImage[8];
		enemy_die_f = new BufferedImage[8];
		flag = new BufferedImage[3];
		button1 = new BufferedImage[2];
		button2 = new BufferedImage[2];
		button3 = new BufferedImage[2];
		
		
		loader = new BufferedImageLoader();
		try {
		ps = new SpriteSheet(loader.loadImage("/spritesheet2.png"));
		psr = new SpriteSheet(loader.loadImage("/spritesheet2rev.png"));
		saw = loader.loadImage("/blade_2.png");
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		getTextures();
		getEnemyTextures();
		flagTextures();
		
	}
/*	
	private void getAsset() {
		try {
		b = new SpriteSheet(loader.loadImage("/buttons.png"));
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		button1[0] = b.grabImage(1, 1, 30, 70);
		button1[1] = b.grabImage(1, 2, 30, 70);
		button2[0] = b.grabImage(1, 1, 30, 70);
		button2[1] = b.grabImage(1, 1, 30, 70);
		button3[0] = b.grabImage(1, 1, 30, 70);
		button3[1] = b.grabImage(1, 1, 30, 70);
	}
*/	
	private void flagTextures() {
		flag[0] = loader.loadImage("/flagGreen.png");
		flag[1] = loader.loadImage("/flagGreen2.png");
		flag[2] = loader.loadImage("/flagGreenHanging.png");
	}
	
	private void getTextures() {
		player_idle_f[0] = ps.grabImage(1, 4, 32, 32);
		player_idle_f[1] = ps.grabImage(5, 4, 32, 32);
		
		player_run_f[0]= ps.grabImage(5, 5, 32, 32);
		player_run_f[1]= ps.grabImage(6, 5, 32, 32);
		player_run_f[2]= ps.grabImage(8, 5, 32, 32);
		player_run_f[3]= ps.grabImage(1, 6, 32, 32);
		player_run_f[4]= ps.grabImage(2, 6, 32, 32);
		
		player_idle_r[0] = psr.grabImage(16, 4, 32, 32);
		player_idle_r[1] = psr.grabImage(12, 4, 32, 32);
		
		player_run_r[0]= psr.grabImage(12, 5, 32, 32);
		player_run_r[1]= psr.grabImage(11, 5, 32, 32);
		player_run_r[2]= psr.grabImage(9, 5, 32, 32);
		player_run_r[3]= psr.grabImage(16, 6, 32, 32);
		player_run_r[4]= psr.grabImage(15, 6, 32, 32);
		
	}
	
	private void getEnemyTextures() {
		enemy_left[0] = ps.grabImage(9, 1, 32, 32);
		enemy_left[1] = ps.grabImage(10, 1, 32, 32);
		enemy_left[2] = ps.grabImage(11, 1, 32, 32);
		
		enemy_right[0] = psr.grabImage(8, 1, 32, 32);
		enemy_right[1] = psr.grabImage(7, 1, 32, 32);
		enemy_right[2] = psr.grabImage(6, 1, 32, 32);
		
		enemy_die_f[0] = ps.grabImage(9, 3, 32, 32);
		enemy_die_f[1] = ps.grabImage(10, 3, 32, 32);
		enemy_die_f[2] = ps.grabImage(11, 3, 32, 32);
		enemy_die_f[3] = ps.grabImage(12, 3, 32, 32);
		enemy_die_f[4] = ps.grabImage(13, 3, 32, 32);
		enemy_die_f[5] = ps.grabImage(14, 3, 32, 32);
		enemy_die_f[6] = ps.grabImage(15, 3, 32, 32);
		enemy_die_f[7] = ps.grabImage(16, 3, 32, 32);
		
		enemy_die_r[0] = ps.grabImage(8, 3, 32, 32);
		enemy_die_r[1] = ps.grabImage(7, 3, 32, 32);
		enemy_die_r[2] = ps.grabImage(6, 3, 32, 32);
		enemy_die_r[3] = ps.grabImage(5, 3, 32, 32);
		enemy_die_r[4] = ps.grabImage(4, 3, 32, 32);
		enemy_die_r[5] = ps.grabImage(3, 3, 32, 32);
		enemy_die_r[6] = ps.grabImage(2, 3, 32, 32);
		enemy_die_r[7] = ps.grabImage(1, 3, 32, 32);
	}
}
