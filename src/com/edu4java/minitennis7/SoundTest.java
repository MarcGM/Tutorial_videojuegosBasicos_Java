package com.edu4java.minitennis7;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundTest {
	/*
	 * En el método main de abajo, se reproduce un archivo de audio.
	 * Para hacerlo, hay varias formas de hacerlo:
	 * 	-Mediante el método que está comentado.
	 *  -Mediante el método que está sin comentar (es la mejor opción).
	 * 
	 * [Más información en: "http://www.edu4java.com/es/game/game7.html".]
	 */
	public static void main(String[] args) throws Exception {

//		System.out.println("1");
//		URL url = new URL("http://www.edu4java.com/es/game/sound/back.wav");
//		System.out.println("2");
//		AudioClip clip = Applet.newAudioClip(url);
//		System.out.println("3");
//		clip.play();
//		System.out.println("4");
//		Thread.sleep(1000);

//		URL url = new URL(
//			"file:/C:/eclipseClasic/workspace/minitennis/src/com/edu4java/minitennis7/back.wav");

		URL url = SoundTest.class.getResource("GameOver_Effect_Mario.wav");
		AudioClip clip = Applet.newAudioClip(url);;
		clip.loop();
		Thread.sleep(10000);
		clip.stop();
		
		System.out.println("end");
	}
}