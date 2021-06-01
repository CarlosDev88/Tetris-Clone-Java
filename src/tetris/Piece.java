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
		assert pieceNumber >= 0 || pieceNumber <= 6 : String.format("número fuera de rango");

		switch (pieceNumber) {
		case 0: {
		}
			break;
		case 1: {
		}
			break;
		case 2: {
		}
			break;
		case 3: {
		}
			break;
		case 4: {
		}
			break;
		case 5: {
		}
			break;
		case 6: {
		}
			break;

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
