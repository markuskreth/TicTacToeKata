package de.kreth.kata.tictactoe.ui.swing;

import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import de.kreth.kata.tictactoe.GameState.Player;

public class TicTacToeComponent {

	private static final URL xImage = TicTacToeComponent.class.getResource("../x.png");
	private static final URL oImage = TicTacToeComponent.class.getResource("../o.png");

	private TicTacToeComponent() {}
	
	public static JComponent createClickComponent(Player p) {

		ImageIcon image;
		if(p == null) {
			image = new ImageIcon();
		} else {
			if(p==Player.PLAYER1) {
				image = new ImageIcon(xImage);
			} else {
				image = new ImageIcon(oImage);
			}
		}

		JLabel btn = new JLabel(image);
		btn.setSize(25, 25);
		btn.setPreferredSize(new Dimension(25, 25));
		
		return btn;
	}
}
