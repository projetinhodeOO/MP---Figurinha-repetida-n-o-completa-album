package view;

import java.awt.*;
import javax.swing.*;

public class JanelaInicial extends JFrame{
	//Criando o JPanel para o titulo
	JPanel topo = new JPanel();		
	JLabel label = new JLabel("Controle de Album de Figurinhas");
	JPanel im1 = new JPanel();
	JPanel im2 = new JPanel();

	public JanelaInicial() {
		//Adicionando o JPanel do topo
		add(topo);
		topo.setBounds(0, 0, 1280, 70);
		topo.setBackground(Color.BLACK);
		//Adicionando o texto que vai no JPanel
		topo.add(label);
		label.setFont(new Font("Comfortaa", Font.CENTER_BASELINE, 40));
		label.setForeground(Color.WHITE);
		
		//Espaco para imagem1
		im1.setBounds(70, 300, 200, 200);
		im1.setBackground(Color.WHITE);
		add(im1);
				
		//Espaco para imagem2
		im2.setBounds(1010, 300, 200, 200);
		im2.setBackground(Color.WHITE);
		add(im2);
		
		setTitle("Controle de Album de Figurinhas");	
		setLayout(null);
		setSize(1280, 720);
		getContentPane().setBackground(Color.GRAY);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
