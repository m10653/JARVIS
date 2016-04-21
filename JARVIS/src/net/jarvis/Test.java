package net.jarvis;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;

import net.jarvis.io.Keyboard;


public class Test {
//	public static void main(String[] args)throws Exception {
//		JTextToSpeech test = new JTextToSpeech();
////		ChatBot chatBot = new ChatBot();
////	        Scanner scan = new Scanner(System.in);
////	        while(true){
////	        	String s = scan.nextLine();
////	        	if(s.equals("new")){
////	        		System.out.println("new Session");
////	        		chatBot.newSession();
////	        	}else{
////	        		System.out.println(chatBot.tell(s));
////	        	}
////	        }
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
	 * @throws Exception 
	 * @throws LineUnavailableException 
	 */

	  public static void main(String[] args) throws Exception {
		  
		  
		  Jarvis ai = new Jarvis();
//		  Microphone mic = new Microphone("mic");
//		  JSpeechToText thing = new JSpeechToText();
//		  JTextToSpeech tts = new JTextToSpeech("tts");
//		  Speaker speaker = new Speaker();
//		  speaker.play(tts.say("Input interpretation\n------------\nEmma Watson  (actor, etc.)\nBasic information\n------------\nfull name | Emma Charlotte Duerre Watson\ndate of birth | Sunday, April 15, 1990 (age: 26 years)\nplace of birth | Paris, Ile?de?France, France\n"));		  
//		  Scanner scan = new Scanner(System.in);
//		  while(true){
//			  String input = scan.nextLine();
//			  if(input.equals("1")){
//				  mic.start();
//			  }else{
//				  System.out.println(thing.toText(mic.stop()));
////				  Skype.chat(thing.toText(mic.stop())).send("This is a Test");
//			  }
//			  
//		  }
		  
	  }
	

}


