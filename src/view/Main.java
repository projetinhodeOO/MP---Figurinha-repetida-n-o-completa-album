package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
	public static void main (String args[]) {
		//Criando a janela
		JanelaInicial janela1 = new JanelaInicial();
		
		//Botao para criar album novo
		JButton botao1 = new JButton();
		botao1.setBounds(80, 250, 180, 30);
		janela1.add(botao1);
		
		//Texto do botao
		JLabel criar = new JLabel("Criar novo album");
		botao1.add(criar);
		criar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
		
		//Botao para gerenciar album
		JButton botao2 = new JButton();
		
		botao2.setBounds(1020, 250, 180, 30);
		janela1.add(botao2);
		
		//Texto do botao
		JLabel gerenciar = new JLabel("Gerenciar album");
		botao2.add(gerenciar);
		gerenciar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
		
		//Acao tomada quando selecionado a opcao de criar album
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Criando a nova janela para criar albuns
				JanelaCriar janela2 = new JanelaCriar();
				
				//Botao para finalizar a criacao
				JButton btnCriar = new JButton("Criar");
				btnCriar.setBounds(350, 400, 100, 30);
				janela2.add(btnCriar);
				
				btnCriar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if("".equals(janela2.campotxt.getText()) ) {
							JOptionPane.showMessageDialog(null, "Digite um nome para o album");
						} else {
							JOptionPane.showMessageDialog(null, "Album criado com sucesso");
						}
					}
				});
			}
		});
		//Acao tomada quando selecionado a opcao de gerenciar album
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaGerenciar janela3 = new JanelaGerenciar();
			}
		});
				
	}
}
