package model;

import model_interface.TelePort;

public class Snake implements TelePort{
	private int transferTo;
	private int position;
	
	public Snake(int start, int end) {
		this.transferTo = start;
		this.position = end;
	}
	
	public Snake() {
	}

	@Override
	public int transferTo() {
		return this.transferTo;
	}
	

	@Override
	public int eventPosition() {
		return this.position;
	}

	@Override
	public String toString() {
		return "Snake [from=" + position + " to=" + transferTo + "]";
	}
	

}
