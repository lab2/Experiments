package ch.codespin.java.map;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class Map extends Applet implements ActionListener {
	int nodeRows = 17;
	int nodeCols = 17;
	Node node;
	Button refreshb;

	ArrayList nodes;
	ArrayList pos;

	void makeGrid() {
		pos = new ArrayList();
		nodes = new ArrayList();
		for (int u = 0; u <= nodeCols; u++) {
			for (int v = 0; v <= nodeRows; v++) {
				node = new Node(u, v, u + ";" + v);
				nodes.add(node);
				pos.add(u + ";" + v);
			}
		}
	}

	Node getNodeByCoords(int u, int v) {
		String posString = u + ";" + v;
		int nodePos = pos.indexOf(posString);
		if (nodePos >= 0) {
			return (Node) nodes.get(nodePos);
		} else {
			return null;
		}
	}

	public void init() {
		refreshb = new Button("Refresh");
		refreshb.addActionListener(this);
		add(refreshb);
		this.setSize(650, 350);
		this.setBackground(new Color(34, 47, 56));
	}

	public void paint(Graphics g) {
		makeGrid();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(new Color(151, 176, 74));

		for (int u = 0; u < nodeCols; u++) {
			for (int v = 0; v < nodeRows; v++) {
				double mean = 0;
				Node n = getNodeByCoords(u, v);
				Node e = getNodeByCoords(u + 1, v);
				Node s = getNodeByCoords(u + 1, v + 1);
				Node w = getNodeByCoords(u, v + 1);
				mean = (e.getZpos() + s.getZpos() + w.getZpos() + n.getZpos()) / 4;

				Polygon poly = new Polygon();
				poly.addPoint(e.getXpos(), e.getYpos() - e.getZpos());
				poly.addPoint(s.getXpos(), s.getYpos() - s.getZpos());
				poly.addPoint(w.getXpos(), w.getYpos() - w.getZpos());
				poly.addPoint(n.getXpos(), n.getYpos() - n.getZpos());

				if (mean < 1)
					g2d.setColor(new Color(81, 133, 172));
				else if (mean > 1 && mean < 8)
					g2d.setColor(new Color(180, 217, 121));
				else
					g2d.setColor(new Color(154, 189, 99));
				g2d.fillPolygon(poly);
			}
		}
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == refreshb) {
			repaint();
		}
	}
}