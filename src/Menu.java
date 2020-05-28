/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Menu.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase donde se establecen los estados del menú y esta misma
* 
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class Menu extends MouseAdapter{

	//Atributos
	private Juego juego;
	private Handler handler;
	private Spawn spawn;
	private HUD hud;
	private boolean llaveFondo = false, 
			        llaveFondo2 = false, 
			        llaveSkin = false, 
			        llaveSkin2 = false;
	private Random r = new Random();
	
	//Constructor para el menú
	public Menu(Juego juego, Handler handler, HUD hud, Spawn spawn) {
		this.juego = juego;
		this.handler = handler; 
		this.hud = hud;
		this.spawn = spawn;
	}
	
	//Eventos al momento de hacer click en cualquiera de los botones del menú
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//Menú
		if(this.juego.e == Juego.Estado.MENU) {
			if(this.rango(mx, my, 220, 100, 200, 64)) {
				this.juego.e = Juego.Estado.SELECCION;
				return;
				
			} else if(this.rango(mx, my, 220, 200, 200, 64)) {
				this.handler.limpiarEnemigo();
				this.juego.e = Juego.Estado.BONUS;

			} else if(this.rango(mx, my, 220, 300, 200, 64)) {
				this.handler.limpiarEnemigo();
				this.juego.e = Juego.Estado.AYUDA;
			}else if(this.rango(mx, my, 220, 400, 200, 64)) {
				System.exit(1);
			}
		}
		
		//Volver a intentar y atrás desde juego
		if(this.juego.e == Juego.Estado.FIN) {
			if(this.rango(mx, my,135, 400, 190, 50)) {
				this.hud.setNivel(1);
				this.hud.setScore(0);
				this.spawn.setScoreKeep(0);
				this.juego.e = Juego.Estado.JUEGO;
				this.handler.agregarObjeto(new Jugador(Juego.ANCHO / 2 - 12, Juego.ALTO / 2 - 32,ID.JUGADOR, this.handler));

				this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
						ID.ENEMIGOBASICO, this.handler));
			}else if(this.rango(mx, my,340, 400, 150, 50)) {
				this.hud.setNivel(1);
				this.hud.setScore(0);
				this.spawn.setScoreKeep(0);
				this.juego.e = Juego.Estado.MENU;
				this.juego.mostrarParticulas();
			}
		} 
		
		
		//Botón atrás desde ayuda
		if(this.juego.e == Juego.Estado.AYUDA) {
			if(this.rango(mx, my, 220, 400, 200, 64)) {
				this.juego.e = Juego.Estado.MENU;
				this.juego.mostrarParticulas();
			}
		}
		
		//Botón atrás desde Bonus y otros botones
		if(this.juego.e == Juego.Estado.BONUS) {
			if(this.rango(mx, my, 220, 400, 200, 64)) {
				this.juego.e = Juego.Estado.MENU;
				this.juego.mostrarParticulas();
			}else if(this.rango(mx, my, 275, 142, 100, 50)) {
				if(this.llaveFondo == true) {
					this.llaveFondo = false;
					Jugador.llave = 0;
				}else {
					this.llaveFondo = true;
					this.llaveFondo2 = false;
					Jugador.llave = 1;
				}
			}else if(this.rango(mx, my, 495, 142, 100, 50)) {
				if(this.llaveFondo2 == true) {
					this.llaveFondo2 = false;
					Jugador.llave = 0;
				}else {
					this.llaveFondo2 = true;
					this.llaveFondo = false;
					Jugador.llave = 2;
				}
			}else if(this.rango(mx, my, 275, 300, 100, 50)) {
				if(this.llaveSkin == true) {
					this.llaveSkin = false;
					RecorridoJugador.llave = 0;
				}else {
					this.llaveSkin = true;
					this.llaveSkin2 = false;
					RecorridoJugador.llave = 1;
				}
			}else if(this.rango(mx, my, 495, 300, 100, 50)) {
				if(this.llaveSkin2 == true) {
					this.llaveSkin2 = false;
					RecorridoJugador.llave = 0;
				}else {
					this.llaveSkin2 = true;
					this.llaveSkin = false;
					RecorridoJugador.llave = 2;
				}
			}
		}
		
		//Botones de menu de selección
		if(this.juego.e == Juego.Estado.SELECCION) {
			if(this.rango(mx, my, 220, 100, 200, 64)) {
				Spawn.seleccion = 1;
				this.handler.limpiarEnemigo();
				this.hud.setNivel(1);
				this.hud.setScore(0);
				this.spawn.setScoreKeep(0);
				this.juego.e = Juego.Estado.JUEGO;
				this.handler.agregarObjeto(new Jugador(Juego.ANCHO / 2 - 12, Juego.ALTO / 2 - 32,ID.JUGADOR, this.handler));
				
				this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
						ID.ENEMIGOBASICO, this.handler));
				
			} else if(this.rango(mx, my,220, 200, 200, 64)) {
				Spawn.seleccion = 2;
				this.handler.limpiarEnemigo();
				this.hud.setNivel(1);
				this.hud.setScore(0);
				this.spawn.setScoreKeep(0);
				this.juego.e = Juego.Estado.JUEGO;
				this.handler.agregarObjeto(new Jugador(Juego.ANCHO / 2 - 12, Juego.ALTO / 2 - 32,ID.JUGADOR, this.handler));
				
				this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
						ID.ENEMIGOBASICO, this.handler));
			} else if(this.rango(mx, my, 220, 300, 200, 64)) {
				Spawn.seleccion = 3;
				this.hud.setNivel(1);
				this.hud.setScore(0);
				this.spawn.setScoreKeep(0);
				this.juego.e = Juego.Estado.JUEGO;
				this.handler.limpiarEnemigo();
				this.handler.agregarObjeto(new Jugador(Juego.ANCHO / 2 - 12, Juego.ALTO / 2 - 32,ID.JUGADOR, this.handler));
				
				this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
						ID.ENEMIGOBASICO, this.handler));
			} else if(this.rango(mx, my, 220, 400, 200, 64)){
				this.juego.e = Juego.Estado.MENU;
			}
		}
		
		//Ganador
		if(this.juego.e == Juego.Estado.GANADOR) {
			this.hud.setNivel(1);
			this.hud.setScore(0);
			this.hud.Salud = 100;
			this.spawn.setScoreKeep(0);
			
			if(this.rango(mx, my, 220, 400, 180, 50)) {
				this.juego.e = Juego.Estado.MENU;
				this.juego.mostrarParticulas();
			}
		}
		
	}

	public void aps() {
		
	}
	public void renderizar(Graphics g) {
		//Menú
		if(this.juego.e == Juego.Estado.MENU){
			g.setColor(Color.WHITE);
			g.setFont(new Font("Bauhaus 93", 1, 60));
			g.drawString("X - V O I D", 180, 73);
			g.setFont(new Font("Bauhaus 93", 1, 35));
			g.drawString("JUGAR", 268, 145);
			g.drawRect(220, 100, 200, 64);
			g.drawString("BONUS", 265, 244);
			g.drawRect(220, 200, 200, 64);
			g.drawString("AYUDA", 262, 344);
			g.drawRect(220, 300, 200, 64);
			g.drawString("SALIR", 275, 444);
			g.drawRect(220, 400, 200, 64);
		//Ayuda
		} else if(this.juego.e == Juego.Estado.AYUDA) {
			g.setColor(Color.WHITE);
			g.fillRect(100, 100, 50, 50);
			g.fillRect(100, 160, 50, 50);
			g.fillRect(160, 160, 50, 50);
			g.fillRect(40, 160, 50, 50);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Bauhaus 93", 1, 45));
			g.drawString("W", 105, 141);
			g.drawString("S", 113, 201);
			g.drawString("A", 51, 201);
			g.drawString("D", 168, 201);

			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Bauhaus 93", 1, 25));
			g.drawString("W - ARRIBA",250,130);
			g.drawString("S - ABAJO",250,200);
			g.drawString("A - DERECHA",425,200);
			g.drawString("D - IZQUIERDA",425,130);
			g.drawString("Después de una catástrofe eres el único",80 ,290);
			g.drawString("sobreviviente, esquiva a esos monstruos",80 ,320);
			g.drawString("y sobrevive al caos del alrededor.",80 ,350);

			
			g.setFont(new Font("Bauhaus 93", 1, 60));
			g.drawString("AYUDA", 226, 73);
			g.setFont(new Font("Bauhaus 93", 1, 45));
			g.drawString("Atrás", 268, 446);
			g.drawRect(220, 400, 200, 64);
			
		//Game Over
		} else if(this.juego.e == Juego.Estado.FIN){
			g.setColor(Color.WHITE);
			g.setFont(new Font("Bauhaus 93", 1, 60));
			g.drawString("GAME OVER", 155, 100);
			g.drawRect(135, 400, 190, 50);
			g.drawRect(340, 400, 150, 50);
			g.setFont(new Font("Bauhaus 93", 1, 30));
			g.drawString("¿OTRA VEZ?", 140, 435);
			g.drawString("SALIR", 375, 435);
			g.drawString("Tu puntaje fue: " + this.hud.getScore(), 165, 200);
			g.drawString("Perdiste en el nivel: " + this.hud.getNivel(), 150, 300);
			
		//Menú de selección
		} else if(this.juego.e == Juego.Estado.SELECCION) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Bauhaus 93", 1, 60));
			g.drawString("MODO DE JUEGO", 80, 80);
			g.setFont(new Font("Bauhaus 93", 1, 35));
			g.drawString("Normal", 264, 145);
			g.drawRect(220, 100, 200, 64);
			g.drawString("Díficil", 265, 244);
			g.drawRect(220, 200, 200, 64);
			g.drawString("Survival", 260, 344);
			g.drawRect(220, 300, 200, 64);
			g.drawString("Atrás", 278, 444);
			g.drawRect(220, 400, 200, 64);
		//Ganador
		} else if(this.juego.e == Juego.Estado.GANADOR) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Bauhaus 93", 1, 60));
			g.drawString("WINNER!", 185, 100);
			g.drawRect(220, 400, 180, 50);
			g.setFont(new Font("Bauhaus 93", 1, 30));
			g.drawString("¡FELICIDADES!, HAS SOBREVIVIDO", 70, 375);
			g.drawString("ACEPTAR", 240, 435);
			try {
				BufferedImage ganador = ImageIO.read(new File("GANADOR.jpg"));
				g.drawImage(ganador, 200, 130, 220,200,null);
			} catch(Exception e) {
				System.out.println(e);
			}
		//Bonus
		} else if(this.juego.e == Juego.Estado.BONUS) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Bauhaus 93", 1, 60));
			g.drawString("BONUS", 225, 90);
			g.setFont(new Font("Bauhaus 93", 1, 45));
			g.drawString("Atrás", 268, 446);
			g.drawRect(220, 400, 200, 64);
			g.setFont(new Font("Bauhaus 93", 1, 30));
			g.drawString("FONDO:", 25, 180);
			g.drawString("SKINS:", 25, 330);
			
			g.fillRect(177, 127, 81, 80);
			g.fillRect(397, 127, 81, 80);
			g.fillRect(177, 282, 81, 80);
			g.fillRect(397, 282, 81, 80);
			
			//FONDO1
			g.drawRect(275, 142, 100, 50);
			//FONDO2
			g.drawRect(495, 142, 100, 50);
			//SKIN1
			g.drawRect(275, 300, 100, 50);
			//SKIN2
			g.drawRect(495, 300, 100, 50);
			
			
			//Checks
			if(this.llaveFondo) {
				g.setColor(Color.GREEN);
				g.setFont(new Font("Bauhaus 93",1,22));
				g.drawString("Selected",280,175);
				g.drawRect(275, 142, 100, 50);
				g.fillRect(177, 127, 81, 80);
			} 
			
			if(this.llaveFondo2) {
				g.setColor(Color.GREEN);
				g.setFont(new Font("Bauhaus 93",1,22));
				g.drawString("Selected",500,175);
				g.drawRect(495, 142, 100, 50);
				g.fillRect(397, 127, 81, 80);
			}
			
			if(this.llaveSkin) {
				g.setColor(Color.GREEN);
				g.setFont(new Font("Bauhaus 93",1,22));
				g.drawString("Selected",280,333);
				g.drawRect(275, 300, 100, 50);
				g.fillRect(177, 282, 81, 80);
			}
			
			if(this.llaveSkin2) {
				g.setColor(Color.GREEN);
				g.setFont(new Font("Bauhaus 93",1,22));
				g.drawString("Selected",500,333);
				g.drawRect(495, 300, 100, 50);
				g.fillRect(397, 282, 81, 80);
			}
			
			try {
				BufferedImage fondo1 = ImageIO.read(new File("FONDO.gif"));
				BufferedImage fondo2 = ImageIO.read(new File("FONDO2.gif"));
				BufferedImage skin1 = ImageIO.read(new File("AZUL2.gif"));
				BufferedImage skin2 = ImageIO.read(new File("AZUL.gif"));
				
				g.drawImage(fondo1, 180,130,75,75,null);
				g.drawImage(fondo2, 400,130,75,75,null);
				g.drawImage(skin1, 180,285,75,75,null);
				g.drawImage(skin2, 400,285,75,75,null);
				
			} catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	//Método para obtener click dentro de botones(Rectángulos)
	private boolean rango(int mx, int my, int x, int y, int ancho, int alto) {
		if((mx > x && mx < x + ancho) && (my > y && my < y + alto)) {
			return true;
		} else {
			return false;
		}
	}
}
