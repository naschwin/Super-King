package com.project.game.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.project.game.framework.GameObject;


public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.tick(object);
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object); 
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object); 
	}
	
	public void clearLevel() {
		object.clear();
	}

	
}
