package ch.codespin.java.swatchbeat;

import java.awt.*;

import ch.codespin.java.swatchbeat.SwatchBeat;
import java.applet.*;

public class SwatchClock extends Applet implements Runnable {
	Thread t, t1;
	SwatchBeat beat;

	public void init() {
		this.setBackground(new Color(223, 43, 38));
		this.setForeground(Color.WHITE);
		this.setSize(50, 30);
	}

	public void start() {
		t = new Thread(this);
		t.start();
	}

	public void run() {
		t1 = Thread.currentThread();
		while (t1 == t) {
			repaint();
			try {
				t1.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public void paint(Graphics g) {
		beat = new SwatchBeat();
		g.drawString(beat.getBeatTime(), 20, 20);
	}
}