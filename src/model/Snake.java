package model;

public class Snake extends TelePort{
	
	public Snake(int start, int end) {
		super(start, end);
		// TODO Auto-generated constructor stub
	}
	
	public Snake() {
		super();
		// TODO Auto-generated constructor stub
	}

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
