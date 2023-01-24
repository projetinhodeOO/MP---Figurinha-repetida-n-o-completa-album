package view;

import java.awt.*;
import javax.swing.*;

/**
 * A classe JanelaInicial exibe uma janela de inicio da aplicacao, contendo duas imagens.
 * @author Manoel Felipe Teixeira Neto
 * @since 2023
 */
public class JanelaInicial extends JFrame{
	//Criando o JPanel para o titulo
	JPanel topo = new JPanel();		
	JLabel label = new JLabel("Controle de Album de Figurinhas");
	JPanel im1 = new JPanel();
	JPanel im2 = new JPanel();
	ImageIcon imagem = new ImageIcon(getClass().getResource("Criar.png"));
	ImageIcon imagem2 = new ImageIcon(getClass().getResource("Editar.png"));
	JLabel criar = new JLabel(imagem);
	JLabel editar = new JLabel(imagem2);

	public JanelaInicial() {
		//Adicionando o JPanel do topo
		add(topo);
		topo.setBounds(0, 0, 1000, 70);
		topo.setBackground(Color.BLACK);
		//Adicionando o texto que vai no JPanel
		topo.add(label);
		label.setFont(new Font("Comfortaa", Font.CENTER_BASELINE, 40));
		label.setForeground(Color.WHITE);
		
		//Espaco para imagem1
		criar.setBounds(70, 300, 200, 200);
		add(criar);

		//Espaco para imagem2
		editar.setBounds(700, 300, 200, 200);
		add(editar);
		
		setTitle("Controle de Album de Figurinhas");	
		setLayout(null);
		setSize(1000, 720);
		getContentPane().setBackground(Color.GRAY);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
