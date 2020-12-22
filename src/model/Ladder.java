package model;

public class Ladder extends TelePort{
	
	public Ladder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ladder(int start, int end) {
		super(start, end);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ladder [start=" + start + ", end=" + end + "]";
	}

}
