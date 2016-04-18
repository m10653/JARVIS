package net.jarvis;

import net.jarvis.commands.ChatBot;

public class Jarvis {
	private ChatBot chatBot;
	public Jarvis(){
		try{
			chatBot = new ChatBot();
		}catch(Exception e){
			System.err.println("Unable to Start ChatBot");
		}
		
		
	}

}
