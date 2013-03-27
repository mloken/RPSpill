package model;

import java.awt.Image;

import bent.Wall;

public class PlayerChar {

	int posx; int posy;
	
	public PlayerChar(int x, int y) {
		this.posx = x;
		this.posy = y;
	}

	public void move(int i, int j) {
		this.posx = posx + i;
		this.posy = posy + j;
		
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isLeftCollision(Wall wall) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRightCollision(Wall wall) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTopCollision(Wall wall) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBottomCollision(Wall wall) {
		// TODO Auto-generated method stub
		return false;
	}

	public int posx() {
		return this.posx;
	}

	public int posy() {
		return this.posy;
	}
}
