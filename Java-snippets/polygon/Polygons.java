package ch.codespin.java.polygon;

import java.util.Random;
import java.awt.geom.*;

public class Polygons extends Ellipse2D.Double {
	public double posx, posy, size, h;
	int dx = 1, dy = 1;

	public Polygons() {
		Random r = new Random();
		int f = r.nextInt(300) + 1;
		int g = r.nextInt(300) + 1;
		h = r.nextInt(4) + 1;
		this.posx = f;
		this.posy = g;
		this.size = 4;
	}

	double getMove() {
		return h;
	}

	double moveRight() {
		if (posx >= 300 || posx < 0) {
			dx = -dx;
		}
		posx += dx;
		return posx;
	}

	double moveDown() {
		if (posy >= 300 || posy < 0) {
			dy = -dy;
		}
		posy += dy;
		return posy;
	}

	double moveUp() {
		if (posy < 0 || posy > 300) {
			dy = -dy;
		}
		posy -= dy;
		return posy;
	}

	double moveLeft() {
		if (posx < 0 || posx > 300) {
			dx = -dx;
		}
		posx -= dx;
		return posx;
	}

	double getSize() {
		return size;
	}

	void move() {
		if (getMove() == 1)
			this.setFrame(moveRight(), moveDown(), getSize(), getSize());
		if (getMove() == 2)
			this.setFrame(moveLeft(), moveUp(), getSize(), getSize());
		if (getMove() == 3)
			this.setFrame(moveUp(), moveLeft(), getSize(), getSize());
		if (getMove() == 4)
			this.setFrame(moveDown(), moveRight(), getSize(), getSize());

	}

}
