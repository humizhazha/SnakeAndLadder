package builder;

import common.TelePortType;
import model.Ladder;
import model.Snake;
import model_interface.TelePort;


public class TelePortFactory {
	
	public TelePort createTelePort(TelePortType type, int start, int end) {
		switch (type){
		case SNAKE:
			return new Snake(start,end);
		case LADDER:
			return new Ladder(start,end);
		default:
			return null;
		}
		
	}

}
