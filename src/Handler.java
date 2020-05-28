/*
* Autor: A01114523 Reynaldo
* Nombre de la clase: Handler.java
* Fecha: 4/05/2019
* Comentarios u observaciones: clase que maneja los enemigos
* 
*/
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	//Atributos
	public LinkedList<Objeto> objeto = new LinkedList<Objeto>();

	//Método para actualizar los objetos
	public void aps() {
		try {
			for (int i = 0; i < this.objeto.size(); i++) {
				if (this.objeto.get(i) != null) {
					Objeto tmpObjeto = this.objeto.get(i);

					tmpObjeto.aps();
				} else {
					this.objeto.remove(i);
				}
			}
		} catch (NullPointerException ex) {

		} catch (IndexOutOfBoundsException ex) {

		}
	}

	//Método para renderizar los objetos
	public void renderizar(Graphics g) {
		try {
			for (int i = 0; i < this.objeto.size(); i++) {
				if (this.objeto != null) {
					Objeto tmpObjeto = this.objeto.get(i);

					tmpObjeto.renderizar(g);
				} else {
					this.objeto.remove(i);
				}
			}
		} catch (NullPointerException e) {

		} catch (IndexOutOfBoundsException e) {

		}
	}


	//Método para remover enemigos del juego
	public void limpiarEnemigo() {
		try {
			for (int i = 0; i < this.objeto.size(); i++) {
				Objeto tmpObjeto = this.objeto.get(i);
				if (tmpObjeto.getID() != ID.JUGADOR) {
					this.removerObjeto(tmpObjeto);
					i--;
				}
			}
		} catch (NullPointerException ex) {

		}
	}

	//Método para remover enemigos del juego y al jugador
	public void limpiarEnemigoYJugador() {
		try {
			for (int i = 0; i < this.objeto.size(); i++) {
				Objeto tmpObjeto = this.objeto.get(i);
				this.removerObjeto(tmpObjeto);
				i--;
			}
		} catch (NullPointerException ex) {	

		}
	}
	
	//Método para agregar objetos a la LinkedList
	public void agregarObjeto(Objeto objeto) {
		this.objeto.add(objeto);
	}
	
	//Método para remover objetos a la LinkedList		
	public void removerObjeto(Objeto objeto) {
			this.objeto.remove(objeto);
	}
}
