package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class View extends JFrame implements Runnable {

	private final int WIDTH = 1000;
	private final int HEIGHT = 800;
	private int row = 30;
	private int column = 10;
	private int boardDisplace = 100;
	private int cellSize = 20;

	BufferedImage bi = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
	Graphics gbi = bi.getGraphics();

	public View() {
		this.setTitle("Tetris Clone");
		this.setSize(this.WIDTH, this.HEIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void paintBackground(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(10, 10, this.WIDTH, this.HEIGHT);
	}

	public void paintBoard(Graphics g) {
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.column; j++) {
				g.setColor(Color.WHITE);
				g.drawRect(boardDisplace + (j * cellSize), boardDisplace + (i * cellSize), cellSize, cellSize);

			}

		}
	}

	public void paint(Graphics g) {
		this.paintBackground(gbi);
		this.paintBoard(gbi);
		g.drawImage(bi, 10, 10, this.WIDTH, this.HEIGHT, this);
	}

	public void run() {

	}

}
