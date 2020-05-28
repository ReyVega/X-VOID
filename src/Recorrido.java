/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Recorrido.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase que maneja el difuminado del recorrido de los enemigos
* 
*/
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Recorrido extends Objeto {
	
	//Atributos
	private float alfa = 1,
			      vida;
	private Handler handler;
	private Color color;
	private int ancho,
	            alto;

	//Constructos del dibujadod de los recorridos de los objetos
	public Recorrido(float x, float y, ID id, Color color, int ancho, int alto, float vida, Handler handler) {
		super(x, y, id);
		this.color = color;
		this.ancho = ancho;
		this.alto = alto;
		this.vida = vida;
		this.handler = handler;	
	}
	
	//Método que renderiza y cambia la opacidad de los recorridos
	public void renderizar(Graphics g) {
		Graphics2D g2d = (Graphics2D)(g);
		g2d.setComposite(this.hacerTransparente(this.alfa));
		g.setColor(this.color);
		g.fillRect((int)this.x, (int)this.y, this.ancho, this.alto);
	}
	
	//Método donde se establece el nivel de opacidad de los recorridos
	private AlphaComposite hacerTransparente(float alfa) {
		int tipo = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(tipo, alfa));
	}
	
	//Método que actualiza y mantiene el recorrido de los objetos estable
	public void aps() {
		if(this.alfa >= vida) {
			this.alfa -= this.vida;
		} else {
			this.handler.removerObjeto(this);
		}
	}

	//Método que establece que no se generará ningún margen de colisión del recorrido
	public Rectangle getMedidas() {
		return null;
	}

}
