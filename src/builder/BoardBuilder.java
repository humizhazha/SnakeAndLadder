package builder;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import common.TelePortType;
import model.Board;
import model.TelePort;

public class BoardBuilder {
	private TelePortFactory factory;

	public BoardBuilder() {
		this.factory = new TelePortFactory();
	}

	public TelePort createTeleport(TelePortType type, int start, int end) {
		TelePort port = factory.createTelePort(type);
		port.setStart(start);
		port.setEnd(end);
		return port;
	}
	
	public Board createBoard(JSONArray teleportData,int size){
		HashMap<Integer,TelePort> telePortTable = new HashMap<Integer,TelePort>();
		for (int i = 0; i < teleportData.size(); i++) {
			JSONObject teleport = (JSONObject)teleportData.get(i);
			TelePortType type = TelePortType.valueOf(teleport.get("type").toString());
			int start = Integer.parseInt(teleport.get("start").toString());
			int end = Integer.parseInt(teleport.get("end").toString());
			TelePort port = createTeleport(type,start,end);
			telePortTable.put(port.eventPosition(), port);
		}
		return new Board(telePortTable,size);
	}

}
