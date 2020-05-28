/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Ventana.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase que incializa el frame donde se jugará el juego
* 
*/
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Ventana{

	//Serial Version
	//Atributo de panel
	private static final long serialVersionUID = -6775489271518568856L;
	private Version pnl;
	
	//Constructos que incializa el juego, el panel de versión, y la música
	public Ventana(int ancho, int alto, String titulo, Juego juego) {
		JFrame frame = new JFrame(titulo);
		Musica musica = new Musica();
		
		this.pnl = new Version();
		this.pnl.setBackground(Color.GRAY);
		this.pnl.setPreferredSize(new Dimension(640,55));
		
		frame.setPreferredSize(new Dimension(ancho, alto));
		frame.setMaximumSize(new Dimension(ancho, alto));
		frame.setMinimumSize(new Dimension(ancho, alto));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(juego, BorderLayout.CENTER);
		frame.add(this.pnl, BorderLayout.SOUTH);
		frame.pack();
		musica.start();
		try {
			BufferedImage icono = ImageIO.read(new File("icono.jpg"));
			frame.setIconImage(icono);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		frame.setVisible(true);
		juego.iniciar();
		

	}
	

}
