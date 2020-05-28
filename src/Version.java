/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Version.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase donde se escribe la versión del juego
* 
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Version extends JPanel {
		
	//Serial
	private static final long serialVersionUID = -2036160783813662219L;

	//Constructor del panel
	public Version() {
		super();
	}
	
	//Método paint para dibujar los componentes del panel
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Bauhaus 93", 1, 25));

		g.drawString("VERSION: 1.0",20,35);
	}
}
