public class Ship {
	int size = 0;
	int hits = 0;
	int row = 0;
	int col = 0;
	boolean isVertical = false;
	
	Ship(int size){
		this.size = size;
		this.hits = 0;
	}
	
	public static boolean isHit() {
		return false;
	}

	public static boolean isSunk() {
		return false;
	}

}
