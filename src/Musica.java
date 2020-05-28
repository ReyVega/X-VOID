/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Musica.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase donde se reproduce la música del juego
* 
*/
import java.io.*;
import javax.sound.sampled.*;

public class Musica extends Thread {
    
	//Hilo que corre la música
	public void run() {
		try {
	         Clip sonido = AudioSystem.getClip();
	         File a = new File("MUSICA.wav");
	         sonido.open(AudioSystem.getAudioInputStream(a));
	         sonido.start();
	         sonido.loop(Clip.LOOP_CONTINUOUSLY);
	      } catch (Exception e) {
	         System.out.println("" + e);
	      }
	}
}
