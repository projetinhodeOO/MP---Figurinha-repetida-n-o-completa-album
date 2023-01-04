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
		botao1.setBounds(80, 250, 180, 30);
		janela.add(botao1);
		
		//Botao para gerenciar album
		JButton botao2 = new JButton();
		botao2.setBounds(1020, 250, 180, 30);
		janela.add(botao2);
		
		//Texto do botao
		JLabel criar = new JLabel("Criar novo album");
		botao1.add(criar);
		criar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
		
		//Texto do botao
		JLabel gerenciar = new JLabel("Gerenciar album");
		botao2.add(gerenciar);
		gerenciar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
		
		//Espaco para imagem1
		JPanel im1 = new JPanel();
		im1.setBounds(70, 300, 200, 200);
		im1.setBackground(Color.WHITE);
		janela.add(im1);
		
		//Espaco para imagem2
		JPanel im2 = new JPanel();
		im2.setBounds(1010, 300, 200, 200);
		im2.setBackground(Color.WHITE);
		janela.add(im2);
				
		
		//Acao tomada quando selecionado a opcao de gerenciar album
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame janela3 = new JFrame("Gerenciar album");
				janela3.setLayout(null);
				janela3.setSize(800, 500);
				janela3.getContentPane().setBackground(Color.GRAY);
				janela3.setVisible(true);
				janela3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//Novo JPanel para adicionar texto
                JPanel ptxt = new JPanel();
                ptxt.setBounds(15, 30, 100, 30);
                ptxt.setBackground(Color.GRAY);
                janela3.add(ptxt);
				
                JLabel sel = new JLabel("Seus albuns:");
                sel.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
                ptxt.add(sel);
                
        		//Botao para excluir album novo
        		JButton delete= new JButton();
        		delete.setBounds(600, 400, 150, 30);
        		janela3.add(delete);
        		
        		//Texto do botao
        		JLabel text = new JLabel("Excluir album ");
        		delete.add(text);
        		criar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));

        		//Lista de Albund
        		String[] albuns = {"Copa do Mundo Qatar", "Yu-Gi-Oh!", "Pokemon"};
        		JList lista = new JList(albuns);
				lista.setBounds(20, 60, 150, 100);
				janela3.add(lista);
				
				
			
			
			}
		});
		
		
		//Acao tomada quando selecionado a opcao de criar album
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Voce selecionou criar album");
				JFrame janela2 = new JFrame("Criar album");
				janela2.setLayout(null);
				janela2.setSize(800, 500);
				janela2.getContentPane().setBackground(Color.GRAY);
				janela2.setVisible(true);
				janela2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//Novo JPanel para adicionar texto
                JPanel ptxt = new JPanel();
                ptxt.setBounds(15, 30, 200, 30);
                ptxt.setBackground(Color.GRAY);
                janela2.add(ptxt);

                JLabel sel = new JLabel("Selecione o tipo de album:");
                sel.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
                ptxt.add(sel);
                
                //Lista dos tipos de album
                JComboBox<String> albuns = new JComboBox<String>();
                albuns.setBounds(20, 60, 160, 30);
                albuns.addItem("Copa do Mundo Qatar");
                albuns.addItem("Yu-Gi-Oh!");
                albuns.addItem("Pokemon");
                janela2.add(albuns);
          
			}
		});
				
	}
}