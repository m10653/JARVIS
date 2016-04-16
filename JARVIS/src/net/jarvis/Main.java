package net.jarvis;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

import net.jarvis.oi.Keyboard;


public class Main implements Runnable{
	
	private int height = 1080;
	private int width = 1920;
	
	private long window;
	
	private Thread thread;
	private boolean running = false;
	
	
	
	public void start(){
		running = true;
		thread = new Thread(this,"Game");
		thread.start();
	}
	public void intit(){
		glfwInit();
		
		window = glfwCreateWindow(width, height, "Test",NULL,NULL);
	}
	public void run(){
		intit();
		while(running){
			update();
			render();
			
			if(glfwWindowShouldClose(window) == GLFW_TRUE){
				running = false;
			}
		}
	}
	public void update(){
		glfwPollEvents();
		if (Keyboard.keys[GLFW_KEY_SPACE]){
			System.out.println("Space");
		}
	}
	public void render(){
		glfwSwapBuffers(window);
	}
	

	public static void main(String[] args) {
		new Main().start();
	}

}
