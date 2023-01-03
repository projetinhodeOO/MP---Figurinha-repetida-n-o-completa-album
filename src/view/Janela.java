package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Janela {
	public static void main (String args[]) {
		//Criando a janela
		JFrame janela = new JFrame("Controle Album de Figurinhas");
		janela.setLayout(null);
		janela.setSize(1280, 720);
		janela.getContentPane().setBackground(Color.GRAY);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Titulo
		JPanel topo = new JPanel();
		topo.setBounds(0, 0, 1280, 70);
		topo.setBackground(Color.BLACK);
		janela.add(topo);
		
		JLabel label = new JLabel("Controle de Album de Figurinhas");
		topo.add(label);
		label.setFont(new Font("Comfortaa", Font.CENTER_BASELINE, 40));
		label.setForeground(Color.WHITE);
		
		//Botao para criar album novo
		JButton botao1 = new JButton();
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Voce selecionou criar album");
			}
		});
		botao1.setBounds(80, 250, 180, 30);
		janela.add(botao1);
		//Texto do botao
		JLabel criar = new JLabel("Criar novo album");
		botao1.add(criar);
		criar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
		
		//Botao para gerenciar album
		JButton botao2 = new JButton();
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Voce selecionou alterar album");
			}
		});
		botao2.setBounds(1020, 250, 180, 30);
		janela.add(botao2);
		//Texto do botao
		JLabel gerenciar = new JLabel("Gerenciar album");
		botao2.add(gerenciar);
		gerenciar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
		
		//Espaco para imagem1
		JPanel im1= new JPanel();
		im1.setBounds(70, 300, 200, 200);
		im1.setBackground(Color.WHITE);
		janela.add(im1);
		
		//Espaco para imagem2
		JPanel im2 = new JPanel();
		im2.setBounds(1010, 300, 200, 200);
		im2.setBackground(Color.WHITE);
		janela.add(im2);
				
	}
}
