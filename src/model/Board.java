package model;

import java.util.HashMap;

public class Board {
	private HashMap<Integer, TelePort> portList;
	private int size;

	public Board(HashMap<Integer, TelePort> portList, int size) {
		this.portList = portList;
		this.size = size;
	}

	public HashMap<Integer, TelePort> getPortList() {
		return portList;
	}

	public void setPortList(HashMap<Integer, TelePort> portList) {
		this.portList = portList;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public TelePort checkEvent(int position) {
		return this.portList.get(position);

	}

}
