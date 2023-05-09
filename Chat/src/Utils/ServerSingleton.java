package Utils;

import java.util.ArrayList;

import agents.ThirdAgent;


public class ServerSingleton {
	
		public String receiverNameString;
		public String senderNameString;
		public ThirdAgent server;
		
	    private static final ServerSingleton INSTANCE = new ServerSingleton();

	    private ServerSingleton() {}

	    public static ServerSingleton getInstance() {
	        return INSTANCE;
	    }
	}

