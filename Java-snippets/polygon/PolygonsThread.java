package ch.codespin.java.polygon;

import java.applet.*;
import java.awt.*;
  
public class PolygonsThread extends Applet implements Runnable {
	Graphics dbg;
	Image img, dbImage;
	Polygons poly[] = new Polygons[50];

	public void init() {
		for (int z = 0; z < poly.length; z++)
			poly[z] = new Polygons();

		setBackground(Color.black);
	}

	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		while (true) {
			for (int z = 0; z < poly.length; z++)
				poly[z].move();

			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException ex) {
			}
		}
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		this.setSize(300, 300);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		Polygon p = new Polygon();
		g2d.setColor(Color.red);
		for (int z = 0; z < poly.length; z++) {
			p.addPoint((int) poly[z].getX(), (int) poly[z].getY());
		}
		g2d.drawPolygon(p);
		
	}

	public void update(Graphics g) {
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
		dbg.setColor(getForeground());
		paint(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
}
