/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: HUD.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase donde se controla la barra de salud, nivel y score
* 
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	//Atributos
	public static float Salud = 100;
	
	private int score = 0,
			    nivel = 1;
	
	private float valorAzul = 100;
	
	//Método donde se actualizan los atributos
	public void aps() {
		this.Salud = Juego.limite(this.Salud, 0, 100);
		
		this.valorAzul = Juego.limite(this.valorAzul, 0, 255);
		
		this.valorAzul = this.Salud * 2;
		
		this.score++;
	}
	
	//Método donde se dibujar la barra de salud junto con el score y el nivel
	public void renderizar(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(175, 13, 300, 20);
		g.setColor(new Color(75, 0, (int)this.valorAzul));
		g.fillRect(175, 13, (int)Salud * 3, 20);
		g.setColor(Color.WHITE);
		g.drawRect(175, 13, 300, 20);
		
		g.setFont(new Font("Rockwell", 1, 20));
		g.drawString("Score: " + this.score, 15, 26);
		g.drawString("Nivel: " + this.nivel, 15, 44);
	}
	
	//Setters
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	//Getters
	public int getScore() {
		return this.score;
	}
	
	public int getNivel() {
		return this.nivel;
	}
}
