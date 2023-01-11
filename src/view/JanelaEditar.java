package view;

import java.awt.*;
import javax.swing.*;
public class JanelaEditar extends JFrame{
		JPanel titulo = new JPanel();
		JLabel nome = new JLabel("Mudar o nome do album:");
		JTextField newname = new JTextField();

public JanelaEditar () {
	
	//Novo JPanel para adicionar texto
	titulo.setBounds(80, 20, 230, 30);
	add(titulo);
	
	//JLabel que sera colocada no Panel acima
	nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo.add(nome);
	
	//JTextField para coletar o nome do pokemon 
	newname.setBounds(75, 50, 230, 30);
	add(newname);
	
	
	setTitle("Ediar Album");
	setLayout(null);
	setSize(400, 500);
	setLocationRelativeTo(null);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

}

}