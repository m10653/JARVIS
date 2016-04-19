package net.jarvis.commands;

import com.skype.Skype;
import com.skype.SkypeClient;
import com.skype.SkypeException;

public class SkypeHandler {
	public SkypeHandler(){
		
	}
	public boolean addContact(){
		return false;
	}
	public void send(String s){
		try {
			Skype.chat("azen9909").send(s);
		} catch (SkypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
