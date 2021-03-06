package tetris;

import java.awt.Color;
import java.util.ArrayList;

public class Piece {

	String[] piecesNames = { "I", "L", "IL", "Z", "IZ", "T", "S" };
	String id;
	Coordinate center;
	Color pieceColor;
	ArrayList<Coordinate> body = new ArrayList<Coordinate>();

	public Piece(int pieceNumber) {
		assert pieceNumber >= 0 && pieceNumber <= 6 : String.format("n?mero fuera de rango");

		switch (pieceNumber) {
		case 0: {
			this.createPieceI();
		}
			break;
		case 1: {
			this.createPieceL();
		}
			break;
		case 2: {
			this.createPieceIL();
		}
			break;
		case 3: {
			this.createPieceZ();
		}
			break;
		case 4: {
			this.createPieceIZ();
		}
			break;
		case 5: {
			this.createPieceT();
		}
			break;
		case 6: {
			this.createPieceS();
		}
			break;

		}
	}

	public Piece() {

	}

	public ArrayList<Coordinate> createPieceI() {
		ArrayList<Coordinate> listCoordinates = new ArrayList<Coordinate>();

		Coordinate p1 = new Coordinate(0, 0);
		Coordinate p2 = new Coordinate(1, 0);
		Coordinate p3 = new Coordinate(2, 0);
		Coordinate p4 = new Coordinate(3, 0);
		
		listCoordinates.add(p1);
		listCoordinates.add(p2);
		listCoordinates.add(p3);
		listCoordinates.add(p4);

		body = listCoordinates;
		id = piecesNames[0];
		this.pieceColor = Color.RED;
		p1.setColor(pieceColor);
		p2.setColor(pieceColor);
		p3.setColor(pieceColor);
		p4.setColor(pieceColor);

		this.center = this.getBody().get(3);
		return this.getBody();
	}

	public ArrayList<Coordinate> createPieceL() {
		ArrayList<Coordinate> listCoordinates = new ArrayList<Coordinate>();

		Coordinate p1 = new Coordinate(0, 0);
		Coordinate p2 = new Coordinate(0, 1);
		Coordinate p3 = new Coordinate(1, 1);
		Coordinate p4 = new Coordinate(2, 1);

		listCoordinates.add(p1);
		listCoordinates.add(p2);
		listCoordinates.add(p3);
		listCoordinates.add(p4);

		body = listCoordinates;
		id = piecesNames[1];
		this.pieceColor = Color.MAGENTA;
		p1.setColor(pieceColor);
		p2.setColor(pieceColor);
		p3.setColor(pieceColor);
		p4.setColor(pieceColor);
		this.center = this.getBody().get(3);
		return this.getBody();
	}

	public ArrayList<Coordinate> createPieceIL() {
		ArrayList<Coordinate> listCoordinates = new ArrayList<Coordinate>();

		Coordinate p1 = new Coordinate(0, 0);
		Coordinate p2 = new Coordinate(0, 1);
		Coordinate p3 = new Coordinate(1, 0);
		Coordinate p4 = new Coordinate(2, 0);

		listCoordinates.add(p1);
		listCoordinates.add(p2);
		listCoordinates.add(p3);
		listCoordinates.add(p4);

		body = listCoordinates;
		id = piecesNames[2];
		this.pieceColor = Color.GREEN;
		p1.setColor(pieceColor);
		p2.setColor(pieceColor);
		p3.setColor(pieceColor);
		p4.setColor(pieceColor);
		this.center = this.getBody().get(3);
		return this.getBody();
	}

	public ArrayList<Coordinate> createPieceZ() {
		ArrayList<Coordinate> listCoordinates = new ArrayList<Coordinate>();

		Coordinate p1 = new Coordinate(0, 1);
		Coordinate p2 = new Coordinate(0, 2);
		Coordinate p3 = new Coordinate(1, 1);
		Coordinate p4 = new Coordinate(1, 0);

		listCoordinates.add(p1);
		listCoordinates.add(p2);
		listCoordinates.add(p3);
		listCoordinates.add(p4);

		body = listCoordinates;
		id = piecesNames[3];
		this.pieceColor = Color.PINK;
		p1.setColor(pieceColor);
		p2.setColor(pieceColor);
		p3.setColor(pieceColor);
		p4.setColor(pieceColor);
		this.center = this.getBody().get(2);
		return this.getBody();
	}

	public ArrayList<Coordinate> createPieceIZ() {
		ArrayList<Coordinate> listCoordinates = new ArrayList<Coordinate>();

		Coordinate p1 = new Coordinate(0, 0);
		Coordinate p2 = new Coordinate(0, 1);
		Coordinate p3 = new Coordinate(1, 1);
		Coordinate p4 = new Coordinate(1, 2);

		listCoordinates.add(p1);
		listCoordinates.add(p2);
		listCoordinates.add(p3);
		listCoordinates.add(p4);

		body = listCoordinates;
		id = piecesNames[4];
		this.pieceColor = Color.BLUE;
		p1.setColor(pieceColor);
		p2.setColor(pieceColor);
		p3.setColor(pieceColor);
		p4.setColor(pieceColor);
		this.center = this.getBody().get(2);
		return this.getBody();
	}

	public ArrayList<Coordinate> createPieceT() {
		ArrayList<Coordinate> listCoordinates = new ArrayList<Coordinate>();

		Coordinate p1 = new Coordinate(0, 1);
		Coordinate p2 = new Coordinate(1, 0);
		Coordinate p3 = new Coordinate(1, 1);
		Coordinate p4 = new Coordinate(1, 2);

		listCoordinates.add(p1);
		listCoordinates.add(p2);
		listCoordinates.add(p3);
		listCoordinates.add(p4);

		body = listCoordinates;
		id = piecesNames[5];
		this.pieceColor = Color.YELLOW;
		p1.setColor(pieceColor);
		p2.setColor(pieceColor);
		p3.setColor(pieceColor);
		p4.setColor(pieceColor);
		this.center = this.getBody().get(2);
		return this.getBody();
	}

	public ArrayList<Coordinate> createPieceS() {
		ArrayList<Coordinate> listCoordinates = new ArrayList<Coordinate>();

		Coordinate p1 = new Coordinate(0, 0);
		Coordinate p2 = new Coordinate(0, 1);
		Coordinate p3 = new Coordinate(1, 0);
		Coordinate p4 = new Coordinate(1, 1);

		listCoordinates.add(p1);
		listCoordinates.add(p2);
		listCoordinates.add(p3);
		listCoordinates.add(p4);

		body = listCoordinates;
		id = piecesNames[6];
		this.pieceColor = Color.ORANGE;
		p1.setColor(pieceColor);
		p2.setColor(pieceColor);
		p3.setColor(pieceColor);
		p4.setColor(pieceColor);
		this.center = this.getBody().get(2);
		return this.getBody();
	}

	public void rotate() {
		Coordinate center = this.getCenter();

		for (Coordinate c : this.getBody()) {
			int centerX = center.getX();
			int centerY = center.getY();
			int centerPiceX = c.getX() - centerX;
			int centerPieceY = c.getY() - centerY;
			int x = center.getX() + centerPieceY;
			int y = center.getY() - centerPiceX;
			c.setX(x);
			c.setY(y);
		}
	}

	public String[] getPiecesNames() {
		return piecesNames;
	}

	public void setPiecesNames(String[] piecesNames) {
		this.piecesNames = piecesNames;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Coordinate getCenter() {
		return center;
	}

	public void setCenter(Coordinate center) {
		this.center = center;
	}

	public Color getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(Color pieceColor) {
		this.pieceColor = pieceColor;
	}

	public ArrayList<Coordinate> getBody() {
		return body;
	}

	public void setBody(ArrayList<Coordinate> body) {
		this.body = body;
	}

}
