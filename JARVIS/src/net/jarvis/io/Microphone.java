package net.jarvis.io;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

public class Microphone {
	
	private boolean isRecording = false;
	
	private File recording;
	private Thread listener;
	private final AudioFormat format;
	private final DataLine.Info targetInfo;
	private final TargetDataLine targetLine;
	
	public Microphone(String fileName) throws Exception{
		
		recording = File.createTempFile(fileName, ".wav");
		recording.deleteOnExit();
		
		format = new AudioFormat(44100, 16, 1, true,false);
		targetInfo = new DataLine.Info(TargetDataLine.class, format);
		targetLine = (TargetDataLine) AudioSystem.getLine(targetInfo);
		targetLine.open(format);
		
		listenThreadInit();
		
	}
	public void start(){
		if(!isRecording){
			targetLine.start();
			listenThreadInit();
			listener.start();
			isRecording = true;
			
			
		}else{
			System.err.println("Already Recording"); 
		}
	}
	public File stop(){
		targetLine.stop();
		while(listener.isAlive()){} // TODO: Find better way to make method wait for thread to finish.
		isRecording = false;
		return recording;
	}
	public double getLevel(){ //TODO: Add lvl detection
		return 0.0;
	}
	private void listenThreadInit(){
		listener = new Thread(){
			
			public void run(){
				AudioInputStream stream = new AudioInputStream(targetLine);
				try {
					AudioSystem.write(stream, AudioFileFormat.Type.WAVE, recording);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		};
	}
	

}
