package model;

import java.util.HashMap;

public class Board {
	private HashMap<Integer, TelePort> portList;
	private int size;

	public Board(HashMap<Integer, TelePort> portList, int size) {
		this.portList = portList;
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public TelePort checkEvent(int position) {
		return this.portList.get(position);
	}

}
