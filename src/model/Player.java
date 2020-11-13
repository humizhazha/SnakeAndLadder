package model;

public class Player {

	private String name;
	private int currentPosition;

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Player(String name) {
		this.name = name;
		this.currentPosition = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void moveForward(int step) {
		this.currentPosition += step;
	}
	
	public void moveBackward(int step) {
		this.currentPosition -= step;
	}
	
	public void moveTo(int position) {
		this.currentPosition = position;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}
	
	
}
