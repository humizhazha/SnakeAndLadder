package builder;

import java.util.HashMap;
import java.util.List;

import common.TelePortType;
import model.Board;
import model.TelePort;

public class BoardBuilder {
	private TelePortFactory factory;

	public BoardBuilder() {
		this.factory = new TelePortFactory();
	}

	private TelePort createTeleport(TelePortType type, int start, int end) {
		TelePort port = factory.createTelePort(type);
		port.setStart(start);
		port.setEnd(end);
		return port;
	}
	
	public Board createBoard(List<TelePortType> typeList,int size) {
		HashMap<Integer,TelePort> telePortTable = new HashMap<Integer,TelePort>();
		for(TelePortType type: typeList) {
			telePortTable.put(1, createTeleport(type,1,2));
			telePortTable.put(4, createTeleport(type,5,9));
		}
		return new Board(null,size);
	}

}
