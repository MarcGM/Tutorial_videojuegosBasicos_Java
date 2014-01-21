package com.edu4java.minitennis5;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Racquet {
	int x = 0;
	int xa = 0;
	private Game game;

	public Racquet(Game game) {
		this.game= game;
	}

	public void move() {
		// Con este "if" controlamos que "racquet" no se salga de la pantalla (del objeto "game" (que es un "JPanel")).
		if (x + xa > 0 && x + xa < game.getWidth()-60)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, 330, 60, 10);
	}
	// Al soltar la tecla apretada, "xa" se iguala a 0. Esto hace que cada vez que pase por el método "move()", "x", no se vaya incrmentando en 1.
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 1;
	}
}