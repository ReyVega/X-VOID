/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: JefeBalas.java
* Fecha: 4/05/2019
* Comentarios u observaciones: atributos y comportamientos de las balas del Jefe
* 
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class JefeBalas extends Objeto {
	
	//Atributos
	private Handler handler;
	private Random r = new Random();
	
	//Constructor de las balas del Jefe
	public JefeBalas(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		this.velX = ((this.r.nextInt(20)) - 10);
		this.velY = 14;
	}
	
	//Método que actualiza las posiciones de las balas 
	public void aps() {
		this.x += this.velX;
		this.y += this.velY;
		
		if(this.y >= Juego.ALTO - 100) {
			this.handler.removerObjeto(this);
		}
		
		this.handler.agregarObjeto(new Recorrido(this.x, this.y, ID.RECORRIDO, Color.CYAN, 16, 16, 0.02f, this.handler));
	}

	//Método que genera el margen de colisión del enemigo
	public Rectangle getMedidas() {
		return new Rectangle((int)this.x,(int)this.y,16,16);
	}

	public void renderizar(Graphics g) {
		
	}

}
