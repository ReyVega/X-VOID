/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Objeto.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase donde se establecen los métodos y atributos de todos los enemigos
* y el jugador dentro del juego
*/
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Objeto {
	
	//Atributos
	protected float x,
	                y;
	protected float velX, 
    				velY;
	protected ID id;
	
	//Constructor de objeto
	public Objeto(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	//Setters
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setID(ID id) {
		this.id = id;
	}
	
	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	//Getters
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public ID getID() {
		return this.id;
	}
	
	public float getVelX() {
		return this.velX;
	}
	
	public float getVelY() {
		return this.velY;
	}
	
	//Métodos para renderizar, actualizar y colisionar de los objetos
	public abstract Rectangle getMedidas();
	public abstract void aps();
	public abstract void renderizar(Graphics g);
	
}
