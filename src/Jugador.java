/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Jugador.java
* Fecha: 4/05/2019
* Comentarios u observaciones: atributos y comportamiento del Jugador
* 
*/
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Jugador extends Objeto{

	//Atributos
    private Handler handler;
    
    public static int llave = 0;
	
    //Constructor de jugador
	public Jugador(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	//Métod que actualiza la posición del jugador con las velocidades establecidas
	public void aps() {
		this.x += this.velX;
		this.y += this.velY;
		
		this.x = Juego.limite(this.x, 0, Juego.ANCHO - 37);
		this.y = Juego.limite(this.y, 0, Juego.ALTO - 115);
		
		this.handler.agregarObjeto(new RecorridoJugador((int)this.x, (int)this.y, ID.RECORRIDO, 32, 32, 0.09f, this.handler));

		this.colision();
	}
	
	//Método de colisiones
	private void colision() {
		for(int i = 0; i < this.handler.objeto.size(); i++) {
			Objeto tmpObjeto = this.handler.objeto.get(i);
			
			if(tmpObjeto.getID() == ID.ENEMIGOBASICO || tmpObjeto.getID() == ID.ENEMIGOVELOZ || tmpObjeto.getID() == ID.ENEMIGORASTREADOR || tmpObjeto.getID() == ID.JEFE) {
				if(getMedidas().intersects(tmpObjeto.getMedidas())) {
					HUD.Salud -= 2;
				}
				if(getMedidas().intersects(tmpObjeto.getMedidas()) && tmpObjeto.getID() == ID.JEFE) {
					HUD.Salud  = 0;
				}
			}
		}
	}
	
	//Método que regresa el margen del jugador para crear colisiones
	public Rectangle getMedidas() {
		return new Rectangle((int)this.x, (int)this.y,32,32);
	}

	//Método donde se renderiza el mapa del bonus
	public void renderizar(Graphics g)  {
		try {
			if(this.llave == 1) {
				BufferedImage fondo = ImageIO.read(new File("FONDO.gif"));
				g.drawImage(fondo,0,0,Juego.ANCHO,Juego.ALTO,null);
			}else if(this.llave == 2) {
				BufferedImage fondo = ImageIO.read(new File("FONDO2.gif"));
				g.drawImage(fondo,0,0,Juego.ANCHO,Juego.ALTO,null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
