/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Teclado.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase que maneja los controles del jugador
* 
*/
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter {

	//Atributos
	private Handler handler;
	private Juego juego;
	private boolean[] teclas = new boolean[4];

	//Constructos donde se incializa el teclado y el handler 
	//Además inicializamos las teclas
	public Teclado(Handler handler, Juego juego) {
		this.handler = handler;
		this.juego = juego;

		for (int i = 0; i < 3; i++) {
			this.teclas[i] = false;
		}
	}

	//Método que maneja el movimiento del jugador
	public void keyPressed(KeyEvent e) {
		int tecla = e.getKeyCode();
		try {
			for (int i = 0; i < this.handler.objeto.size(); i++) {

				Objeto tmpObjeto = this.handler.objeto.get(i);
				if (tmpObjeto == null) {
					this.handler.objeto.remove(i);
				} else {

					if (tmpObjeto.getID() == ID.JUGADOR) {

						if (tecla == KeyEvent.VK_W) {
							tmpObjeto.setVelY(-6);
							this.teclas[0] = true;
						} else if (tecla == KeyEvent.VK_S) {
							tmpObjeto.setVelY(6);
							this.teclas[1] = true;
						} else if (tecla == KeyEvent.VK_D) {
							tmpObjeto.setVelX(6);
							this.teclas[2] = true;
						} else if (tecla == KeyEvent.VK_A) {
							tmpObjeto.setVelX(-6);
							this.teclas[3] = true;
						}
						
						if((this.teclas[0] == true) && (this.teclas[1] == true)) {
							tmpObjeto.setVelX(0);
						}
						if((this.teclas[2] == true) && (this.teclas[3] == true)) {
							tmpObjeto.setVelY(0);
						}
					}

				}
			}
		} catch (NullPointerException ex) {
			
		}

		//Tecla que cambia el estado del juego a pausa
		if (tecla == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		} else if (tecla == KeyEvent.VK_P) {
			if (this.juego.e == Juego.Estado.JUEGO) {
				if (Juego.pause) {
					Juego.pause = false;
				} else {
					Juego.pause = true;
				}
			}
		}
	}

	//Método que al momento de realizar las teclas, el jugador se detiene
	public void keyReleased(KeyEvent e) {
		int tecla = e.getKeyCode();
		try {
			for (int i = 0; i < this.handler.objeto.size(); i++) {
				Objeto tmpObjeto = this.handler.objeto.get(i);
				if (tmpObjeto == null) {
					this.handler.objeto.remove(i);
				} else {

					if (tmpObjeto.getID() == ID.JUGADOR) {
						if (tecla == KeyEvent.VK_W) {
							this.teclas[0] = false;
						} else if (tecla == KeyEvent.VK_S) {
							this.teclas[1] = false;
						} else if (tecla == KeyEvent.VK_D) {
							this.teclas[2] = false;
						} else if (tecla == KeyEvent.VK_A) {
							this.teclas[3] = false;
						} 
						
						if ((this.teclas[0] == false) && (this.teclas[1] == false)) {
							tmpObjeto.setVelY(0);
						}
						if ((this.teclas[2] == false) && (this.teclas[3] == false)) {
							tmpObjeto.setVelX(0);
						}
					}
				}
			}
		} catch (NullPointerException ex) {

		}
	}

}
