package net.jarvis;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import net.jarvis.commands.ChatBot;
import net.jarvis.commands.JSpeechToText;
import net.jarvis.commands.JTextToSpeech;
import net.jarvis.graphics.PlaceHolder;
import net.jarvis.io.Microphone;
import net.jarvis.io.Speaker;

public class Jarvis extends KeyAdapter {
	private ChatBot chatBot;
	private Microphone mic;
	private Speaker speaker;
	private JTextToSpeech tts;
	private JSpeechToText stt;
	private boolean isListening = false;
	
	public Jarvis(){
		try{
			chatBot = new ChatBot();
			mic = new Microphone("Mic");
			speaker = new Speaker();
			tts = new JTextToSpeech("tts");
			stt = new JSpeechToText();
		}catch(Exception e){
			System.err.println("Unable to Start Error : " + e);
			System.exit(1);
		}
		PlaceHolder gui = new PlaceHolder();
		gui.addKeyListener(this);
	}
	
	public void handleCommand(String command,double confidence){
		try {
			speaker.play(tts.say(chatBot.tell(command)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}
	
	public void listenToggle(){
		if(!isListening){
			System.out.println("REcording");
			mic.start();
			isListening = true;
		}else{
			System.out.println("Done");
			String trascript = stt.toText(mic.stop());
			isListening = false;
			String[] command = parseTrascript(trascript);
			handleCommand(command[0], Double.parseDouble(command[1]));
		}
	}
	
	public String[] parseTrascript(String trascript){
		int tstart = trascript.indexOf("\"transcript\": \"");
		String command = "";
		for(int i = tstart+1+"transcript\": \"".length(); i < trascript.length(); i++){
			if(trascript.charAt(i) == '"'){
				System.out.println("Break!");
				break;
			}else{
				command += trascript.charAt(i);
			}
		}
		int cstart = trascript.indexOf("\"confidence\":") + "\"confidence\":".length();
		String confidence = "";
		for(int i = cstart +1;i < trascript.length();i++){
			if(trascript.charAt(i) == '}'){
				break;
			}else{
				confidence +=trascript.charAt(i);
			}
		}
		System.out.println(command + ";" + confidence);
		
		return new String[]{command,confidence};
	}
	
	public void speak(String text){
		try {
			File speech = tts.say(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_SPACE){
			listenToggle();
			
		}
	}
	

}
