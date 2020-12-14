package model;

public class Snake extends TelePort{
	
	@Override
	public int transferTo() {
		return this.start;
	}
	
	@Override
	public int eventPosition() {
		return this.end;
	}

	@Override
	public String toString() {
		return "Snake [start=" + start + ", end=" + end + "]";
	}
	

}
