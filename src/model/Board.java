package model;

import java.util.HashMap;

public class Board {
	private HashMap<Integer, TelePort> portList;
	public final int size;

	public Board(HashMap<Integer, TelePort> portList, int size) {
		this.portList = portList;
		this.size = size;
	}

	public TelePort checkEvent(int position) {
		return this.portList.get(position);
	}

}
