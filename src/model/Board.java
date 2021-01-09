package model;

import java.util.Map;

public class Board {
	private Map<Integer, TelePort> portMap;
	public final int size;

	public Board(Map<Integer, TelePort> portMap, int size) {
		this.portMap = portMap;
		this.size = size;
	}

	/**
	 * Return 
	 * @param position
	 * @return
	 */
	public TelePort getTelePort(int position) {
		return this.portMap.get(position);
	}

}
