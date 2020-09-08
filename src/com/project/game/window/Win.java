package com.project.game.window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Win extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Win() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					dispose();
					new Menu();
				}
			}
		});
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You Win.\r\n");
		lblNewLabel.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 30));
		lblNewLabel.setBounds(320, 110, 145, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Press Enter to Continue.");
		lblNewLabel_1.setFont(new Font("Square721 Cn BT", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(300, 190, 186, 44);
		contentPane.add(lblNewLabel_1);
		
		setVisible(true);
	}
}
