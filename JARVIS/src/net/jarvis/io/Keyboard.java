package net.jarvis.io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	@Override
	public void keyPressed(KeyEvent event) {}

	@Override
	public void keyReleased(KeyEvent event) {
		System.out.println("Released");
		if(event.getKeyCode() == KeyEvent.VK_SPACE){
			System.out.println("Space");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent event) {}
		
	
}