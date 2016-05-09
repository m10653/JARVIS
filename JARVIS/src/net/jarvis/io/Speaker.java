package net.jarvis.io;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Speaker {
	
	AudioInputStream stream;
	Clip clip;
	
	public Speaker(){
	}
	public synchronized void play(File file) throws InterruptedException{
		try {
			stream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();
			stream.close();
			System.gc(); //here becuse of java bug;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Speaker Class");
		}
		
	}
}
