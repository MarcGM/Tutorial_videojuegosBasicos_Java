package com.edu4java.minitennis5;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

	//Creamos un objeto de la classe "Ball" y otro de la classe "Racquet"y le pasamos como parámetro una referencia a la instancia actual de la clase "Ball" y "Racquet". 
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);

	public Game() {
		/*
		 * Agrega una "listener" al objeto "Game" creado.
		 * 
		 * Este "listener" se ejecuta en concurrencia ("en paral·lelo", "a la misma vez") (por otro thread), que los otros métodos de "Game".
		 * Gracias a eso, al pulsar una tecla, la detecta automáticamente.
		 */
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	private void move() {
		ball.move();
		racquet.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}