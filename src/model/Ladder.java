package model;

import model_interface.TelePort;

public class Ladder implements TelePort{
	
	private int transferTo;
	private int position;
	
	public Ladder(int start, int end) {
		this.transferTo = end;
		this.position = start;
	}
	
	

	@Override
	public String toString() {
		return "Ladder [from=" + position + " to=" + transferTo + "]";
	}



	@Override
	public int transferTo() {
		// TODO Auto-generated method stub
		return transferTo;
	}



	@Override
	public int eventPosition() {
		// TODO Auto-generated method stub
		return position;
	}

}
