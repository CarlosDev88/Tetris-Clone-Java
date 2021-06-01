package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controll implements KeyListener {

	Piece currentPiece;

	private int initialX = 5;
	private int initialY = 0;
	private int finalX;
	private int finalY;

	public Controll() {
		currentPiece = this.createPiece();
		this.movePieceInitialPosition();
	}

	public Piece createPiece() {
		Piece p = new Piece(5);
		return p;

	}

	public void movePieceInitialPosition() {
		for (Coordinate coordinate : currentPiece.getBody()) {
			int pX = coordinate.getX();
			int pY = coordinate.getY();
			int cX = pX + initialX;
			int cY = pY + initialY;

			coordinate.setX(cX);
			coordinate.setY(cY);

		}
	}

	public void moveDownPieces() {
		for (Coordinate coordinate : currentPiece.getBody()) {
			// int pX = coordinate.getX();
			int pY = coordinate.getY();
			int cY = pY + 1;
			coordinate.setY(cY);
		}
	}

	public void execute() {
		if (!isEndBoard()) {
			this.moveDownPieces();
		}

	}

	public boolean isEndBoard() {
		boolean isEnd = false;
		for (Coordinate c : currentPiece.getBody()) {
			if (c.getY() + 1 == this.finalY) {
				return true;
			}
		}

		return isEnd;
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public Piece getCurrentPiece() {
		return currentPiece;
	}

	public int getFinalX() {
		return finalX;
	}

	public void setFinalX(int finalX) {
		this.finalX = finalX;
	}

	public int getFinalY() {
		return finalY;
	}

	public void setFinalY(int finalY) {
		this.finalY = finalY;
	}

	/*
	 * 
	 * public void setCurrentPiece(Piece currentPiece) { this.currentPiece =
	 * currentPiece; }
	 */

}
