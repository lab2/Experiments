package ch.codespin.java.arecibo;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class MessageDecoderPanel extends JPanel {

	private String msg;

	MessageDecoderPanel(String msg) {
		this.msg = msg;
	}

	MessageDecoderPanel() {
		this.msg = "00000010101010000000000001010000010100000001001000100010001001011001010101010101010100100100000000000000000000000000000000000001100000000000000000001101000000000000000000011010000000000000000001010100000000000000000011111000000000000000000000000000000001100001110001100001100010000000000000110010000110100011000110000110101111101111101111101111100000000000000000000000000100000000000000000100000000000000000000000000001000000000000000001111110000000000000111110000000000000000000000011000011000011100011000100000001000000000100001101000011000111001101011111011111011111011111000000000000000000000000001000000110000000001000000000001100000000000000010000011000000000011111100000110000001111100000000001100000000000001000000001000000001000001000000110000000100000001100001100000010000000000110001000011000000000000000110011000000000000011000100001100000000011000011000000100000001000000100000000100000100000001100000000100010000000011000000001000100000000010000000100000100000001000000010000000100000000000011000000000110000000011000000000100011101011000000000001000000010000000000000010000011111000000000000100001011101001011011000000100111001001111111011100001110000011011100000000010100000111011001000000101000001111110010000001010000011000000100000110110000000000000000000000000000000000011100000100000000000000111010100010101010101001110000000001010101000000000000000010100000000000000111110000000000000000111111111000000000000111000000011100000000011000000000001100000001101000000000101100000110011000000011001100001000101000001010001000010001001000100100010000000010001010001000000000000100001000010000000000001000000000100000000000000100101000000000001111001111101001111000";
	}

	boolean checkBit(char bit) {
		return bit == '0';
	}

	Rectangle2D.Double bit;

	protected void paintComponent(Graphics g) {
		int qwidth = 6, x = qwidth, y = qwidth, cells = 0, posx = 45, posy = 10;
		setBackground(Color.WHITE);
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.DARK_GRAY);

		for (int count = 0; count < msg.length(); count++) {
			Rectangle2D.Double bit = new Rectangle2D.Double(posx + x, posy + y,
					qwidth, qwidth);
			if (checkBit(msg.charAt(count)))
				g2.draw(bit);
			else {
				bit.width += 1;
				bit.height += 1;
				g2.fill(bit);
			}
			if (cells < 22) {
				x += qwidth;
				cells++;
			} else {
				cells = 0;
				x = qwidth;
				y += qwidth;
			}
		}
	}
}