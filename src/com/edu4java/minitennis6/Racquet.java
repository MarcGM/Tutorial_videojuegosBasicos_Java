package com.edu4java.minitennis6;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	/*
	 * Ponemos en alto la posición Y, el ancho (WITH) y el alto (HEIGHT) de la raqueta en constantes.
	 * Para definir constantes hemos de utilizar las palabras "static final".
	 */
	private static final int Y = 330;
	private static final int WITH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xa = 0;
	private Game game;

	
	public Racquet(Game game) {
		this.game = game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WITH)
			x = x + xa;
	}
	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WITH, HEIGHT);
	}
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 1;
	}
	// Este método, crea un rectángulo en la misma posición que la raqueta (que interceptará las colisiones).
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WITH, HEIGHT);
	}
	/*
	 * Devuelve la constante "Y", que será usada por un método de la clase "Ball".
	 */
	public int getTopY() {
		return Y;
	}
}