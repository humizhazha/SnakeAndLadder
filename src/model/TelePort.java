package model;

public class TelePort {
	protected int start;
	protected int end;
	
	public TelePort() {
	}
	
	public TelePort(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	public int transferTo() {
		return end;
	}
	
	public int eventPosition() {
		return start;
	}

}
