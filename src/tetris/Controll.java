package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controll implements KeyListener {

	Piece currentPiece;
	

	private int initialX = 5;
	private int initialY = 0;

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
	
	
	
	public void execute() {
		
		
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

	public void setCurrentPiece(Piece currentPiece) {
		this.currentPiece = currentPiece;
	}



}
