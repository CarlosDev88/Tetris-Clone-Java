package tetris;

import java.util.Comparator;

public class Comparation implements Comparator<Coordinate> {

	public int compare(Coordinate o1, Coordinate o2) {

		return o1.getX() - o2.getX();
	}

}
