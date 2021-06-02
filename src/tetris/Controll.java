
package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Controll implements KeyListener {

	Piece currentPiece;

	private int initialX = 5;
	private int initialY = 0;
	private int finalX;
	private int finalY;
	ArrayList<Piece> PieceList = new ArrayList<Piece>();

	public Controll() {
		currentPiece = new Piece();
		this.createPiece();

	}

	public void createPiece() {
		Random r = new Random();
		int idPiece = r.nextInt(currentPiece.piecesNames.length);
		currentPiece = new Piece(idPiece);
		this.movePieceInitialPosition();

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
		if (!isEndBoard() && !isPieceCollition()) {
			this.moveDownPieces();
		} else {
			this.getPieceList().add(currentPiece);
			this.createPiece();
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

	public boolean isPieceCollition() {
		boolean isColition = false;

		for (Piece piece : PieceList) {
			for (Coordinate cB : piece.getBody()) {
				for (Coordinate cP : currentPiece.getBody()) {
					if (cP.getY() + 1 == cB.getY() && cP.getX() + 1 == cB.getX()) {
						isColition = true;
					}
				}
			}
		}

		return isColition;
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

	public ArrayList<Piece> getPieceList() {
		return PieceList;
	}

	public void setPieceList(ArrayList<Piece> pieceList) {
		PieceList = pieceList;
	}

	/*
	 * 
	 * public void setCurrentPiece(Piece currentPiece) { this.currentPiece =
	 * currentPiece; }
	 */

}
