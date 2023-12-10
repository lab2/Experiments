package ch.codespin.java.plasma;

import java.awt.geom.*;

public class Plasma extends Ellipse2D.Double {

	double x = 0, y = 0;

	public Plasma(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getColor(double time) {
		double v = Math.sin(getDist(x + time, y, 128.0, 128.0) / 8.0)
				+ Math.sin(getDist(x, y, 64.0, 64.0) / 8.0)
				+ Math.sin(getDist(x, y, 192.0, 64.0) / 7.0)
				+ Math.sin(getDist(x, y + time, 192.0, 50.0) / 8.0);
		return (4 + v)*32;
	}

	public double getDist(double a, double b, double c, double d) {
		return Math.sqrt(((a - c) * (a - c) + (b - d) * (b - d)));
	}
}