package com.project.game.levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.project.game.framework.ObjectId;
import com.project.game.objects.Block;
import com.project.game.objects.Enemy;
import com.project.game.objects.Player;
import com.project.game.objects.Saw;
import com.project.game.objects.Win_Block;
import com.project.game.window.BufferedImageLoader;
import com.project.game.window.Game;
import com.project.game.window.Handler;
import com.project.game.window.Win;

public class Levels {

	public Handler handler;
	public BufferedImage levels[], gameState[];
	private int level;
	private Game game;
	BufferedImageLoader loader = new BufferedImageLoader();
	
	public Levels(int level,  Game game) {
		this.game = game;
		this.level = level;
		handler = game.getHandler();
		levels = new BufferedImage[5];
		init();
	}
	
	private void init() {
		levels[0] = loader.loadImage("/mapy.png");
		levels[1] = loader.loadImage("/mapy2.png");
		levels[2] = loader.loadImage("/mapy3.png");
		levels[3] = loader.loadImage("/map4.png");
		levels[4] = loader.loadImage("/map5.png");
	}
	
	private void loadImageLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255 && green == 255 & blue == 255) handler.addObject(new Block(xx * 32, yy *32, ObjectId.Block));
				if(red == 0 && green == 0 & blue == 255) handler.addObject(new Player(xx * 32, yy *32, handler, ObjectId.Player, game));
				if(red == 0 && green == 255 & blue == 0) handler.addObject(new Win_Block(xx * 32, yy *32, ObjectId.Win_Block));
				if(red == 237 && green == 28 && blue == 36) handler.addObject(new Enemy(xx * 32, yy *32, ObjectId.Enemy, handler));
				if(red == 0 && green == 162 && blue == 232) {
					handler.addObject(new Saw(xx * 32, yy *32, ObjectId.Saw, handler));
				}
			}
		}
	}
	
	public void loadWorld() {
		loadImageLevel(levels[level]);
	}
	
	public void changeLevel() {
		handler.clearLevel();
		if(level == 4) {
			System.out.println("You Win!");
			new Win();
			level = 0;
		}
		else {
			level++;
			loadWorld();
		}
	}

	public void showGameOver(Graphics g) {
		handler.clearLevel();
		g.drawImage(levels[3], 0, 0, null);
	}


	
}
