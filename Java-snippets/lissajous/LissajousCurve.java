package ch.codespin.java.lissajous;

import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;

public class LissajousCurve extends JApplet {

	double x = 0, y = 0;

	public void init() {
		this.setSize(620, 300);
		this.setBackground(Color.white);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.lightGray);
		double x1, x2, y1, y2;
		// double a = 2.0, b = 0.99, c = -0.7, d = 3.01, e = 1, f = 1.01, gi =
		// 0.1, h = 15.03;
		double a = 1, b = 2, c = -0.7, d = 3.01, e = 1, f = 1.01, gi = 0.1, h = 15.03;
		for (double t = 5; t <= 30000; t += 0.25) {
			x1 = a * Math.sin(Math.toRadians(b * t)) * 100;
			x2 = c * Math.cos(Math.toRadians(d * t)) * 100;
			x = (x1 + x2) + 300;
			y1 = e * Math.cos(Math.toRadians(f * t)) * 100;
			y2 = gi * Math.sin(Math.toRadians(h * t)) * 100;
			y = (y1 + y2) + 150;
			g2.fill(new Ellipse2D.Double(x, y, 0.5, 0.5));
		}
	}
}