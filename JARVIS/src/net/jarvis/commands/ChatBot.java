package net.jarvis.commands;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

public class ChatBot  {
	private  ChatterBotSession botsession;
	private  ChatterBot bot;
	private ChatterBotFactory factory;
	
	public ChatBot() throws Exception {
		factory = new ChatterBotFactory();
		bot = factory.create(ChatterBotType.CLEVERBOT);
//		bot = factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477"); //TODO add support for Diff bots.
		
		 botsession= bot.createSession();
		 
		 
		 
	}
	public String tell(String text){
		try {
			return botsession.think(text);
		} catch (Exception e) {
			e.printStackTrace();
			return "I was Unable to Proccess your request, Check your Internet Connection.";
		}
	}
	public void newSession() throws Exception{
		botsession = bot.createSession();
	}

}

