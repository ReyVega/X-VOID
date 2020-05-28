/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: EnemigoRastreador.java
* Fecha: 4/05/2019
* Comentarios u observaciones: Atributos y comportamiento de Enemigo Rastreador
* 
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemigoRastreador extends Objeto {

	//Atributos
	private Handler handler;
	private Objeto jugador;

	//Constructor del Enemigo Rastreador
	public EnemigoRastreador(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;
		
		for(int i = 0; i < this.handler.objeto.size(); i++) {
			if(this.handler.objeto.get(i).getID() == ID.JUGADOR) {
				this.jugador = this.handler.objeto.get(i);
			}
		}
	}

	//Método donde se establece la velocidad del enemigo, y algoritmo para perseguir jugador
	public void aps() {
		this.x += this.velX;
		this.y += this.velY;
		
		float diffX = this.x - this.jugador.getX();
		float diffY = this.y - this.jugador.getY();
		float distancia = (float) Math.sqrt((this.x - this.jugador.getX()) * (this.x - this.jugador.getX()) + (this.y - this.jugador.getY()) * (this.y - this.jugador.getY()));

		this.velX = (float)(((-1.0 / distancia) * diffX) * 2.5);
		this.velY = (float)(((-1.0 / distancia) * diffY) * 2.5) ;

		this.handler.agregarObjeto(new Recorrido(this.x, this.y, ID.RECORRIDO, Color.YELLOW, 16, 16, 0.02f, this.handler));
	}

	//Método que genera el margen de colisión del enemigo
	public Rectangle getMedidas() {	
		return new Rectangle((int)this.x, (int)this.y, 16, 16);
	}

		
	public void renderizar(Graphics g) {
			
	}

}

