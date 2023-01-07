package view;

import java.awt.*;
import javax.swing.*;
public class JaneladeExclusão extends JFrame{
		JPanel ptxt = new JPanel();
		JTextField campname = new JTextField();
		JComboBox<String> albuns = new JComboBox<String>();

		JLabel nome = new JLabel("Qual figurinha excluir ?");
		JPanel titulo = new JPanel();


public JaneladeExclusão () {
	
	//Lista dos tipos de album
	albuns.setBounds(65, 50, 160, 30);
	albuns.addItem("Neymar");
	albuns.addItem("Olhos Azuis");
	albuns.addItem("Pikachu");
	add(albuns);
    
	
	//Novo JPanel para adicionar texto
	titulo.setBounds(25, 20, 230, 30);
	add(titulo);

	//JLabel que sera colocada no Panel acima
	nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo.add(nome);
	
	setTitle("Exclusão de Figurinha" );
	setLayout(null);
	setSize(300, 600);
	setLocationRelativeTo(null);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

}

}