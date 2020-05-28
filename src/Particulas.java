/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Particulas.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase que maneja el estilo del menú
* 
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Particulas extends Objeto {
	
	//Atributos
	private Handler handler;
	
	//Constructor del diseño de las partículas de la pantalla
	public Particulas(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		this.velX = 0;
		this.velY = 5;
	}
	
	//Método para actualizar los atributos de las partículas
	public void aps() {
		this.x += this.velX;
		this.y += this.velY;
		
		if(this.y <= 0 || this.y >= Juego.ALTO - 100) this.velY *= -1;
		if(this.x <= 0 || this.x >= Juego.ANCHO - 16) this.velX *= -1;

		this.handler.agregarObjeto(new Recorrido(this.x, this.y, ID.RECORRIDO, Color.YELLOW, 16, 16, 0.05f, this.handler));
	}

    //Método que establce que las partículas no colisionaran, no se genera margen alrededor de las partículas
	public Rectangle getMedidas() {
		return null;
	}

	public void renderizar(Graphics g) {
		
	}

}
