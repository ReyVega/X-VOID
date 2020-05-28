/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Juego.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase donde se incializa el juego, además en esta clase está el motor gráfico
* 
*/
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferStrategy;

import java.util.Random;
import java.awt.Graphics;

public class Juego extends Canvas implements Runnable {
	
	//Atributos
	private static final long serialVersionUID = 2873200361662945344L;

	public static final int ANCHO = 640,
	                        ALTO = ANCHO / 12 * 11;
	
	private Random r;
	private Handler handler;
	private Spawn spawn;
	private Menu menu;
	private HUD hud;
	
	private Thread hilo;
	private boolean enFuncionamiento = false;
	
	public static boolean pause = false;
	
	
	//Estados de Juego
	public enum Estado{
		MENU,
		JUEGO,
		SELECCION,
		BONUS,
		AYUDA,
		FIN,
		GANADOR
	};
	
	public static  Estado e = Estado.MENU;
	
	//Constructor
	public Juego() {
		this.handler = new Handler();
		this.hud = new HUD();
		this.spawn = new Spawn(this.handler, this.hud, this);

		this.hud.setNivel(1);
		this.hud.setScore(0);
		this.spawn.setScoreKeep(0);

		this.menu = new Menu(this, this.handler, this.hud, this.spawn);

		this.addMouseListener(this.menu);
		this.addKeyListener(new Teclado(this.handler, this));
			
		new Ventana(ANCHO, ALTO, "X-VOID", this);
		
		this.r = new Random();
		
		this.mostrarParticulas();

		this.requestFocusInWindow();
	}
	
	//Iniciar motor gráfico
	public synchronized void iniciar() {
		this.hilo = new Thread(this);
		this.hilo.start();
		this.enFuncionamiento = true;
	}
	
	//Detener motor gráfico
	public synchronized void detener() {
		try {
			this.hilo.join();
			this.enFuncionamiento = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Método run para echar a andar el motor gráfico
	public void run() {
		long ultimoTiempo = System.nanoTime(),
			 contador = System.currentTimeMillis();
		double aps = 70.0,
			   ns = 1000000000 / aps,
			   delta = 0.0;
		int fps = 0;
		
		while(this.enFuncionamiento) {
			long tiempoActual = System.nanoTime();
			delta += (tiempoActual - ultimoTiempo) / ns;
			ultimoTiempo = tiempoActual;
			while(delta >= 1) {
				this.aps();
				delta--;
			}
			if(this.enFuncionamiento) {
				this.renderizar();
				fps++;
			}
			
			if(System.currentTimeMillis() - contador > 1000) {
				contador += 1000;
				fps = 0;
			}
		}
		this.detener();      
	}
	
	//Actualizaciones del juego
	private void aps() {
	
		if(this.e == Estado.JUEGO) {
			if(!this.pause) {
				this.hud.aps();
				this.spawn.aps();
				this.handler.aps();

				if(HUD.Salud <= 0) {
					HUD.Salud = 100;
					this.e = Estado.FIN;
					this.handler.limpiarEnemigoYJugador();
				}
			}
		} else if(this.e == Estado.MENU || this.e == Estado.AYUDA  || this.e == Estado.FIN || this.e == Estado.SELECCION || this.e == Estado.GANADOR || this.e == Estado.BONUS){
			this.handler.aps();
			this.menu.aps();
		}
	}
	
	//Mostrar gráficos de todo
	private void renderizar() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ANCHO, ALTO);
				
		this.handler.renderizar(g);
		
		if(this.pause) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Bauhaus 93", 1, 60));
			g.drawString("PAUSED",210,200);
		}
		
		if(this.e == Estado.JUEGO) {
			this.hud.renderizar(g);
		} else if(this.e == Estado.MENU || this.e == Estado.AYUDA  || this.e == Estado.FIN || this.e == Estado.SELECCION || this.e == Estado.GANADOR || this.e == Estado.BONUS){
			this.menu.renderizar(g);
		}
		
		
		g.dispose();
		bs.show();
	}
	
	
	//Diseño para la página principal(Solo los enemigos)
	public void mostrarParticulas() {
		int separacion = 0;
		for(int i = 0; i < 13; i++) {
			this.handler.agregarObjeto(new Particulas(15 + separacion,10,
					ID.ENEMIGOBASICO, this.handler));
			separacion += 50;
			this.handler.agregarObjeto(new Particulas2(15 + separacion,5,
					ID.ENEMIGOBASICO, this.handler));
			separacion += 50;
			this.handler.agregarObjeto(new Particulas2(15 + separacion,85,
					ID.ENEMIGOBASICO, this.handler));
			separacion += 50;
		}
		for(int i = 0; i < 5; i++) {
			this.handler.agregarObjeto(new EnemigoVeloz(this.r.nextInt(Juego.ANCHO - 100), this.r.nextInt(Juego.ALTO - 100),
					ID.ENEMIGOVELOZ, this.handler));
		}
	}
	
	//Método para detectar colisiones en la pantalla y en la barra de vida
	public static float limite(float variable, float min, float max) {
		if(variable >= max) {
			return variable = max;
		} else if(variable <= min) {
			return variable = min;
		} else {
			return variable;
		}
	}
	
	//Método main
	public static void main(String[] args) {
		new Juego();
	}
}
