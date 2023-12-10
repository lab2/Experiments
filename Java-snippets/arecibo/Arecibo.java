package ch.codespin.java.arecibo;

import javax.swing.*;

public class Arecibo {
	private static void show() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		JFrame frame = new JFrame("Arecibo binary message, 1974");
		frame.getContentPane().add(new MessageDecoderPanel());
		frame.setSize(300, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				show();
			}
		});
	}
}