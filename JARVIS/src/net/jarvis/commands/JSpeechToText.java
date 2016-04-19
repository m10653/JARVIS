package net.jarvis.commands;

import java.io.File;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

public class JSpeechToText {
	
	SpeechToText stt;
	
	public JSpeechToText(){
		stt = new SpeechToText();
		stt.setUsernameAndPassword("36020111-18f4-4b43-9a10-62c7c5a29095", "QviJq5Awde4I");
	}
	public String toText(File file){
		String transcript = stt.recognize(file).toString();
		System.out.println(transcript);
		return null;
	}

}
