package net.jarvis;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JFrame;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;


public class Test {
//	public static void main(String[] args)throws Exception {
//		 ChatterBotFactory factory = new ChatterBotFactory();
//
//	        ChatterBot bot1 = factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
//	        ChatterBotSession bot1session = bot1.createSession();
//
////	        ChatterBot bot2 = factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
////	        ChatterBotSession bot2session = bot2.createSession();
//	        Scanner scan = new Scanner(System.in);
//	        while(true){
//	        	String s = scan.nextLine();
//	        	System.out.println(bot1session.think(s));
//	        }
//	}
	/**
	 * Copyright 2015 IBM Corp. All Rights Reserved.
	 * 
	 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
	 * in compliance with the License. You may obtain a copy of the License at
	 * 
	 * http://www.apache.org/licenses/LICENSE-2.0
	 * 
	 * Unless required by applicable law or agreed to in writing, software distributed under the License
	 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
	 * or implied. See the License for the specific language governing permissions and limitations under
	 * the License.
	 */


	/**
	 * Recognize a sample wav file and print the transcript into the console output. Make sure you are
	 * using UTF-8 to print messages; otherwise, you will see question marks.
	 * @throws LineUnavailableException 
	 */

	  public static void main(String[] args) {

		System.out.println("test");
	    SpeechToText service = new SpeechToText();
	    service.setUsernameAndPassword("36020111-18f4-4b43-9a10-62c7c5a29095", "QviJq5Awde4I");
	    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
	    File audio = new File("test.wav");
	    SpeechResults transcript = service.recognize(audio);

	    System.out.println(transcript);
//		  
//			AudioFormat format = new AudioFormat(44100, 16, 1, true,false);
//
//			DataLine.Info targetInfo = new DataLine.Info(TargetDataLine.class, format);
//			DataLine.Info sourceInfo = new DataLine.Info(SourceDataLine.class, format);
//
//			try {
//				TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(targetInfo);
//				targetLine.open(format);
//				targetLine.start();
//				
//				SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(sourceInfo);
//				sourceLine.open(format);
//				sourceLine.start();
//
//			}
//			catch (Exception e) {
//				System.err.println(e);
//			}
	  }
	

}


