
package tetris;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class Controll implements KeyListener {
	Piece currentPiece;
	Action actionKey;
	Comparator comparator = new Comparation();
	ArrayList<Coordinate> pieceList = new ArrayList<Coordinate>();

	private int initialX = 5;
	private int initialY = 0;
	private int finalX;
	private int finalY;
	private int BoardRightBound;
	private int BoardLeftBound = 0;
	int score = 0;

	public Controll() {
		currentPiece = new Piece();
		this.createPiece();
		actionKey = Action.NOTHING;

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
			int pY = coordinate.getY();
			int cY = pY + 1;
			coordinate.setY(cY);
		}
	}

	public void moveDownAll() {
		for (Coordinate c : this.pieceList) {
			int y = c.getY();
			y++;
			c.setY(y);

		}
	}

	public void moveRightPiece() {
		for (Coordinate coordinate : currentPiece.getBody()) {
			int x = coordinate.getX();
			x += 1;
			coordinate.setX(x);
		}
	}

	public void moveLeftPiece() {
		for (Coordinate coordinate : currentPiece.getBody()) {
			int x = coordinate.getX();
			x -= 1;
			coordinate.setX(x);
		}
	}

	public void rotatePiece() {
		currentPiece.rotate();
	}

	public void execute() {
		if (this.isMove()) {
			if (actionKey == Action.LEFT) {
				this.moveLeftPiece();
			}
			if (actionKey == Action.RIGHT) {
				this.moveRightPiece();
			}
			if (actionKey == Action.SPACE) {
				this.rotatePiece();
			}
			actionKey = Action.NOTHING;
		}

		if (!isEndBoard() && !isPieceCollition()) {
			this.moveDownPieces();
		} else {
			this.getPieceList().addAll(currentPiece.getBody());
			this.createPiece();
			this.orderCoordinate();
			this.printCoordinate();
			this.isLine();

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
		boolean isCollition = false;

		for (Coordinate cB : this.pieceList) {
			for (Coordinate cP : currentPiece.getBody()) {
				if (cP.getY() + 1 == cB.getY() && cP.getX() == cB.getX()) {
					isCollition = true;
				}
			}
		}

		return isCollition;
	}

	public boolean isMove() {
		boolean isMove = true;
		for (Coordinate c : currentPiece.getBody()) {

			if (actionKey == Action.RIGHT) {
				if (c.getX() + 1 == this.BoardRightBound) {
					isMove = false;
				}
			}

			if (actionKey == Action.LEFT) {
				if (c.getX() == this.BoardLeftBound) {
					isMove = false;
				}
			}

		}
		return isMove;
	}

	public boolean isLine() {
		int counter = 0;
		boolean isLine = false;

		for (int i = 0; i < finalY; i++) {
			for (int j = 0; j < this.pieceList.size(); j++) {
				Coordinate c = this.pieceList.get(j);
				if (i == c.getY()) {
					counter++;

					if (counter == finalX) {
						int from = (j + 1) - finalX;

						isLine = true;
						for (int x = 0; x < finalX; x++) {
							this.pieceList.remove(from);
						}
						this.score++;
						break;						
					}
				}

			}
			counter = 0;
		}

		return isLine;
	}
	
	

	public void orderCoordinate() {
		this.pieceList.sort(comparator);
	}

	public void printCoordinate() {
		Iterator<Coordinate> it = this.pieceList.iterator();

		while (it.hasNext()) {
			Coordinate c = it.next();
			System.out.println(c.toString());
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();

		switch (key) {
		case 'a': {
			actionKey = Action.LEFT;
		}
			break;
		case 'd': {
			actionKey = Action.RIGHT;
		}
			break;
		case ' ': {
			actionKey = Action.SPACE;
		}
			break;
		default:
			break;
		}
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

	public int getBoardRightBound() {
		return BoardRightBound;
	}

	public void setBoardRightBound(int boardRightBound) {
		BoardRightBound = boardRightBound;
	}

	public ArrayList<Coordinate> getPieceList() {
		return pieceList;
	}

	public void setPieceList(ArrayList<Coordinate> pieceList) {
		this.pieceList = pieceList;
	}

}
