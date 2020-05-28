/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Recorrido2.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase que maneja el difuminado del recorrido del jugador
* 
*/
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RecorridoJugador extends Objeto {

	//Atributos
	private float alfa = 1, 
			      vida;
	private Handler handler;
	private int ancho, 
	            alto;

	public static int llave = 0;

	//Constructos que recibe los atributos de los objetos
	public RecorridoJugador(float x, float y, ID id, int ancho, int alto, float vida, Handler handler) {
		super(x, y, id);
		this.ancho = ancho;
		this.alto = alto;
		this.vida = vida;
		this.handler = handler;
	}

	//Método donde se incializan los gráficos 2D para crear el recorrido
	public void renderizar(Graphics g) {
		this.skin(g);
		Graphics2D g2d = (Graphics2D) (g);
		g2d.setComposite(this.hacerTransparente(this.alfa));

		if (this.llave == 0) {
			g.setColor(Color.WHITE);
			g.fillRect((int) this.x, (int) this.y, this.ancho, this.alto);
		}
	}

	//Método que sirve para renderizar el recorrido de los objetos
	private AlphaComposite hacerTransparente(float alfa) {
		int tipo = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(tipo, alfa));
	}
	
	//Método que contiene los skins del juego y los renderiza
	public void skin(Graphics g) {
		if(this.llave == 1) {
			BufferedImage skin;
			try {
				skin = ImageIO.read(new File("AZUL2.gif"));
				g.drawImage(skin,(int)this.x,(int)this.y,32,32,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(this.llave == 2) {
			BufferedImage skin2;
			try {
				skin2 = ImageIO.read(new File("AZUL.gif"));
				g.drawImage(skin2,(int)this.x,(int)this.y,32,32,null);		

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Método que se encarga de que el recorrido se mantenga estable
	public void aps() {
		if (this.alfa >= vida) {
			this.alfa -= this.vida;
		} else {
			this.handler.removerObjeto(this);
		}
	}
	
	//Método para evitar que el recorrido forme parte de la colisión con el jugador
	public Rectangle getMedidas() {
		return null;
	}
}
