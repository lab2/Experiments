package ch.codespin.java.barnsley;

import java.applet.*;
import java.awt.*;
import java.awt.geom.*;

public class BarnsleyFern extends Applet {

	double cachex, cachey;
	double x = 0, y = 0;

	public void init() {
		setBackground(Color.darkGray);
	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		this.setSize(230, 370);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.green);
		//(x'= ax + by + c)
		//(y'= dx + ey + f)
		for (int i = 0; i < 50000; i++) {
			double r = Math.random();
			if (r < 0.01) {
				cachex = 0;
				cachey = 0.16 * y;
				
			} else if (r < 0.85) {
				cachex = 0.85 * x + 0.04 * y;
				cachey = -0.04 * r + 0.85 * y + 1.60;
				
			} else if (r < 0.93) {
				cachex = 0.2 * x - 0.26 * y;
				cachey = 0.23 * r + 0.22 * y + 1.60;
				
			} else {
				cachex = -0.15 * x + 0.28 * y;
				cachey = 0.26 * r + 0.24 * y + 0.44;
				
			}
			x = cachex;
			y = cachey;
			
			g2d.fill(new Ellipse2D.Double(x * 30 + 100, y * -30 + 330, 0.3, 0.3));
		}
	}
}
