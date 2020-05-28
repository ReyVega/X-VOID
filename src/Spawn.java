/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Spawn.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase que maneja el spawn de los enemigos
* 
*/
import java.util.Random;

public class Spawn {
	
	//Atributos
	private Handler handler;
	private HUD hud;
	private Juego juego;
	
	private Random r = new Random();
	
	public static int seleccion = 0;
	
	private int scoreKeep = 0;
	
	//Constructor encargado de generar o spawnear los enemigos
	public Spawn (Handler handler, HUD hud, Juego juego) {
		this.handler = handler;
		this.hud = hud;
		this.juego = juego;
	}
	
	//Método para los niveles
	public void aps() {
		if(this.seleccion == 1) {
			this.scoreKeep++;
			
			if(this.scoreKeep >= 300) {
				this.scoreKeep = 0;
				this.hud.setNivel(this.hud.getNivel() + 1);
				
				if(this.hud.getNivel() == 2) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 3) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 4) {
					this.handler.agregarObjeto(new EnemigoVeloz(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOVELOZ, this.handler));
					
				} else if(this.hud.getNivel() == 5) {
					this.handler.agregarObjeto(new EnemigoRastreador(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGORASTREADOR, this.handler));
					
				} else if(this.hud.getNivel() == 6) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 7) {
					this.handler.agregarObjeto(new EnemigoVeloz(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOVELOZ, this.handler));
					
				} else if(this.hud.getNivel() == 8) {
					this.handler.agregarObjeto(new EnemigoRastreador(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGORASTREADOR, this.handler));
					
				} else if(this.hud.getNivel() == 9) {
					this.handler.agregarObjeto(new EnemigoVeloz(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOVELOZ, this.handler));
					
				} else if(this.hud.getNivel() == 10) {
					this.handler.limpiarEnemigo();
					this.handler.agregarObjeto(new Jefe( (Juego.WIDTH / 2) + 280, -80,
							ID.JEFE, this.handler));
				} else if(this.hud.getNivel() == 13) {
					this.handler.limpiarEnemigoYJugador();
					this.juego.e = Juego.Estado.GANADOR;
				}
			}
		} else if(this.seleccion == 2) {
			this.scoreKeep++;
			
			if(this.scoreKeep >= 300) {
				this.scoreKeep = 0;
				this.hud.setNivel(this.hud.getNivel() + 1);
				
				if(this.hud.getNivel() == 2) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 3) {
					this.handler.agregarObjeto(new EnemigoVeloz(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOVELOZ, this.handler));
					this.handler.agregarObjeto(new EnemigoVeloz(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOVELOZ, this.handler));
					
				} else if(this.hud.getNivel() == 4) {
					this.handler.agregarObjeto(new EnemigoVeloz(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOVELOZ, this.handler));
					
				} else if(this.hud.getNivel() == 5) {
					this.handler.agregarObjeto(new EnemigoRastreador(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGORASTREADOR, this.handler));
					
				} else if(this.hud.getNivel() == 6) {
					this.handler.agregarObjeto(new EnemigoVeloz(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOVELOZ, this.handler));
					
				} else if(this.hud.getNivel() == 7) {
					this.handler.agregarObjeto(new EnemigoRastreador(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGORASTREADOR, this.handler));
					
				} else if(this.hud.getNivel() == 8) {
					this.handler.agregarObjeto(new EnemigoRastreador(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGORASTREADOR, this.handler));
					
				} else if(this.hud.getNivel() == 9) {
					this.handler.agregarObjeto(new EnemigoVeloz(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOVELOZ, this.handler));
					
				} else if(this.hud.getNivel() == 10) {
					this.handler.limpiarEnemigo();
					this.handler.agregarObjeto(new Jefe( (Juego.WIDTH / 2) + 280, -80,
							ID.JEFE, this.handler));
				}else if(this.hud.getNivel() == 13) {
					this.handler.limpiarEnemigoYJugador();
					this.juego.e = Juego.Estado.GANADOR;
				}
			}
		} else if(this.seleccion == 3) {
			this.scoreKeep++;
			
			if(this.scoreKeep >= 300) {
				this.scoreKeep = 0;
				this.hud.setNivel(this.hud.getNivel() + 1);
				
				if(this.hud.getNivel() == 2) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 3) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 4) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 5) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 6) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 7) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 8) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 9) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
					
				} else if(this.hud.getNivel() == 10) {
					this.handler.agregarObjeto(new EnemigoBasico(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
							ID.ENEMIGOBASICO, this.handler));
				}
			}
		}
	}
	
	//Setters
	public void setScoreKeep(int scoreKeep) {
		this.scoreKeep = 0;
	}
}
