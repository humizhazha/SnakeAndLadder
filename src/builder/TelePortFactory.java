package builder;

import common.TelePortType;
import model.Ladder;
import model.Snake;
import model.TelePort;

public class TelePortFactory {
	
	public TelePort createTelePort(TelePortType type) {
		switch (type){
		case SNAKE:
			return new Snake();
		case LADDER:
			return new Ladder();
		default:
			return null;
		}
		
	}

}
