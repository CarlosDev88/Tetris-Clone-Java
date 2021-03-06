package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class View extends JFrame implements Runnable {

	private final int WIDTH = 500;
	private final int HEIGHT = 720;
	private int row = 23;
	private int column = 11;
	private int boardDisplace = 100;
	private int cellSize = 25;

	Controll controll = new Controll();

	BufferedImage bi = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
	Graphics gbi = bi.getGraphics();

	public View() {
		this.setTitle("Tetris Clone");
		this.setSize(this.WIDTH, this.HEIGHT);
		this.setVisible(true);
		this.addKeyListener(controll);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controll.setFinalX(column);
		controll.setFinalY(row);
		controll.setBoardRightBound(column);

		Thread thread = new Thread(this);
		thread.start();
	}

	public void paint(Graphics g) {
		this.paintBackground(gbi);
		this.paintBoard(gbi);
		this.paintCurrentPiece(gbi);
		this.paintPiecesBoard(gbi);
		this.paintScore(gbi);		
		g.drawImage(bi, 10, 10, this.WIDTH, this.HEIGHT, this);
	}
	
	public void paintScore(Graphics g) {
		g.setColor(Color.WHITE);		
		g.drawString("Puntos: ",100,50);
		g.drawString(Integer.toString(controll.score),150,50);
	}

	public void paintBackground(Graphics g) {
		g.setColor(Color.BLACK);
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

	public void paintCurrentPiece(Graphics g) {
		Piece piece = this.controll.getCurrentPiece();

		for (Coordinate c : piece.getBody()) {
			g.setColor(piece.getPieceColor());
			g.fillRect(boardDisplace + (c.getX() * cellSize), boardDisplace + (c.getY() * cellSize), cellSize,
					cellSize);
		}
	}

	public void paintPiecesBoard(Graphics g) {
		for (Coordinate c : controll.getPieceList()) {
			g.setColor(c.getColor());
			g.fillRect(boardDisplace + (c.getX() * cellSize), boardDisplace + (c.getY() * cellSize), cellSize,
					cellSize);
		}
	}

	public void run() {

		while (true) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			controll.execute();
			this.repaint();
		}

	}

}
