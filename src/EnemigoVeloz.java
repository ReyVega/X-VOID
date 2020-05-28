/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: EnemigoVeloz.java
* Fecha: 4/05/2019
* Comentarios u observaciones: atributos y comportamiento de Enemigo Veloz
* 
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemigoVeloz extends Objeto {

	//Atributos
	private Handler handler;

	//Constructor de Enemigo Veloz
	public EnemigoVeloz(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;

		this.velX = 8;
		this.velY = 8;
	}

	//Método donde se establece la velocidad del objeto y sus colisiones respecto a la pantalla
	public void aps() {
		this.x += this.velX;
		this.y += this.velY;

		if (this.y <= 0 || this.y >= Juego.ALTO - 100)
			this.velY *= -1;
		if (this.x <= 0 || this.x >= Juego.ANCHO - 16)
			this.velX *= -1;

		this.handler.agregarObjeto(new Recorrido(this.x, this.y, ID.RECORRIDO, Color.RED, 16, 16, 0.02f, this.handler));
	}

	//Método para generar margen de colisión del enemigo
	public Rectangle getMedidas() {
		return new Rectangle((int)this.x, (int)this.y, 16, 16);
	}

	public void renderizar(Graphics g) {
		
	}

}
