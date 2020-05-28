/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Jefe.java
* Fecha: 4/05/2019
* Comentarios u observaciones: atributos y comportamientos del Jefe
* 
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Jefe extends Objeto {
	
	//Atributos
	private Handler handler;
	
	private int contador = 105,
			    contador2 = 50;
	
	private Random r = new Random();
	
	//Constructor del jefe
	public Jefe(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		this.velX = 0;
		this.velY = 2;
	}
	
	//Método que actualiza la velocidad del jefe, además de su comportamiento
	public void aps() {
		this.x += this.velX;
		this.y += this.velY;
		
		this.contador--;
		
		if(this.contador <= 0) {
			this.velY = 0;
		} else {
			this.contador--;
		}
		
		if(this.contador <= 0) {
			this.contador2--;
		}
		
		if(this.contador2 <= 0) {
			if(this.velX == 0) {
				this.velX = 3;
			}
			
			if(this.velX > 0) {
				this.velX += 0.004f;
			} else if(this.velX < 0) {
				this.velX -= 0.004f;
			}
			
			this.velX = Juego.limite(this.velX, -10, 10);
			
			
			int spawn = r.nextInt(5);
			if(spawn == 0) {
				this.handler.agregarObjeto(new JefeBalas((int)this.x, (int)this.y, ID.ENEMIGOBASICO, this.handler));
			}
		}
		
		
		if(this.x <= 0 || this.x >= Juego.ANCHO - 80) this.velX *= -1;

		this.handler.agregarObjeto(new Recorrido(this.x, this.y, ID.RECORRIDO, Color.CYAN, 85, 85, 0.07f, this.handler));
	}

	//Método que genera el margen de colisiónd del enemigo
	public Rectangle getMedidas() {
		return new Rectangle((int)this.x,(int)this.y,85,85);
	}

	public void renderizar(Graphics g) {
	
	}

}
