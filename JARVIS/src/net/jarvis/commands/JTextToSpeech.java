package net.jarvis.commands;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

public class JTextToSpeech {
	private TextToSpeech tts;
	private File speech;
	private Voice voice = new Voice("en-US_MichaelVoice", "male", "en-US");;
	
	
	public JTextToSpeech(String fileName) throws IOException{
		tts = new TextToSpeech();
		tts.setUsernameAndPassword("48abc7de-b0cd-4bf3-b142-4394ac13d104", "u1jgTWn0nNJ0");
		
		speech = File.createTempFile(fileName, ".wav");
		speech.deleteOnExit();
		
	}
	public JTextToSpeech(String fileame, Voice voice) throws IOException{
		this(fileame);
		this.voice = voice;
	}
	public File say(String text) throws Exception{
		InputStream in = tts.synthesize(text, voice, HttpMediaType.AUDIO_WAV);
		in = WaveUtils.reWriteWaveHeader(in);
		
		Files.copy(in,speech.toPath(), StandardCopyOption.REPLACE_EXISTING);
		in.close();
		return speech;
		
	}
	public void setVoice(Voice voice){
		this.voice = voice;
	}

}
