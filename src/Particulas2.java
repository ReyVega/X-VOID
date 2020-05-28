/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Particulas2.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase que maneja el estilo del menú
* 
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Particulas2 extends Objeto {
	
	//Atributos
	private Handler handler;
	
	//Constructor del segundo tipo de partículas de la pantalla
	public Particulas2(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		this.velX = 10;
		this.velY = 0;
	}
	
	//Método que actualiza los atributos de las partículas de la pantalla
	public void aps() {
		this.x += this.velX;
		this.y += this.velY;
		
		if(this.y <= 0 || this.y >= Juego.ALTO - 100) this.velY *= -1;
		if(this.x <= 0 || this.x >= Juego.ANCHO - 16) this.velX *= -1;

		this.handler.agregarObjeto(new Recorrido(this.x, this.y, ID.RECORRIDO, Color.BLUE, 16, 16, 0.05f, this.handler));
	}

	//Método que no regresa margen de la partículas para no colisionar
	public Rectangle getMedidas() {
		return null;
	}

	public void renderizar(Graphics g) {
		
	}

}
