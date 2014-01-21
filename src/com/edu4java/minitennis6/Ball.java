package com.edu4java.minitennis6;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	// Ponemos el diametro de la pelota (que es lo mismo que el alto y el ancho), en una constante.
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game= game;
	}

	void move() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		/*
		 * Llamamos el método "gameOver()" del objeto "game" si la pelota toca el lado inferior del JPanel.
		 * (Hemos substituido la instrucción anterior que hacia que la pelota rebote en el lado inferior del JPanel por la instrucción
		 * 		"gameOver".)
		 */
		if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		/*
		 * Si el retorno del método "collision()" retorna "true", "ya" lo ponemos a -1, por lo tanto cambiamos de dirección, la pelota.
		 * Este método, desplaza la pelota hacia la parte superior de la raqueta, si la pelota toca la raqueta por los laterales.
		 * (No es necesario, y podria funcionar sin él. Pero queda mejor).
		 */
		if (collision()){
			ya = -1;
			y = game.racquet.getTopY() - DIAMETER;
		}
		x = x + xa;
		y = y + ya;
	}
	// Este método detecta si hay una colisión entre la raqueta y la pelota y devuelve "true" o "False".
	private boolean collision() {
		/*
		 * Retorna "true", si el rectángulo creado por el método "getBounds" del objeto "raquet" referenciado en el objeto "game",
		 * 		colisiona(intersects), con el rectángulo creado por el método "getBounds" de este objeto (del objeto actual de la clase "Ball").
		 */
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	/*
	 * Crea un rectángulo en la misma posición del objeto actual de la clase "Ball", que será usado para las colisiones.
	 * (Rectangle es una clase Java de las librerias. Esta importada en este documento con "import java.awt.Rectangle;".
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}