package ch.codespin.java.applets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.util.Random;
 
class Bubble extends Ellipse2D.Double { 
	private double xpos;
	private double ypos;
	private Color[] colors = { Color.BLUE, Color.CYAN, Color.GREEN,
			Color.YELLOW, Color.RED, Color.MAGENTA, Color.ORANGE, Color.WHITE,
			Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY };
	private Color color;
	private double size, maxsize; 

	public Bubble(int w, int h) {
		xpos = w * Math.random();
		ypos = h * Math.random();
		setColor();
		setSize();
		setMaxSize();
	}

	public void setSize() {
		size = 10;
	}

	public double getSize() {
		return size;
	}

	public double getCurrentSize() {
		return size++;
	}

	public void setCurrentSize() {
		setSize();
	}

	public void setMaxSize() {
		Random r = null;
		r = new Random();
		maxsize = size + r.nextInt(40);
	}

	public double getMaxSize() {
		return maxsize;
	}

	public double getXpos() {
		return xpos;
	}

	public double getYpos() {
		return ypos;
	}

	public void setColor() {
		Random r = null;
		r = new Random();
		color = colors[r.nextInt(colors.length)];
	}

	public Color getColor() {
		return color;
	}
}

public class Bubbles extends JApplet implements ActionListener {
	int frame;
	Timer animator;
	Canvas canvas;
	Bubble[] bubbles;

	public void init() {
		bubbles = new Bubble[10];
		for (int i = 0; i < bubbles.length; i++)
			bubbles[i] = new Bubble(300, 200);
		canvas = new Canvas();
		setContentPane(canvas);
		setSize(300, 200); 
	}

	public void start() {
		animator = new Timer(40, this);
		animator.start();
	}

	public void actionPerformed(ActionEvent e) {
		frame++;
		canvas.repaint();
	}

	public void stop() {
		animator.stop();
		animator = null;
	}

	public class Canvas extends JPanel {
		public Canvas() {
			setBackground(Color.BLACK);
		}

		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			super.paintComponent(g2d);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setStroke(new BasicStroke(2));
			for (int i = 0; i < bubbles.length; i++) {
				g2d.setColor(bubbles[i].getColor());
				bubbles[i].setFrame(bubbles[i].getXpos(), bubbles[i].getYpos(),
						bubbles[i].getCurrentSize(), bubbles[i]
								.getCurrentSize());
				g2d.draw(bubbles[i]);
				if (bubbles[i].getCurrentSize() > bubbles[i].getMaxSize()) {
					bubbles[i].setCurrentSize();
					bubbles[i] = new Bubble(300, 200);
					bubbles[i].setFrame(bubbles[i].getXpos(), bubbles[i]
							.getYpos(), bubbles[i].getCurrentSize(), bubbles[i]
							.getCurrentSize());
					g2d.setColor(bubbles[i].getColor());
					g2d.draw(bubbles[i]);
				}
			}
		}
	}
}