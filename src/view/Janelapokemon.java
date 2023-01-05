package view;

import java.awt.*;
import javax.swing.*;
public class Janelapokemon extends JFrame{
		JPanel ptxt = new JPanel();
		JTextField campname = new JTextField();
		JTextField camprari = new JTextField();
		JTextField camptipo = new JTextField();
		JLabel nome = new JLabel("Digite o nome do pokemon:");
		JLabel raridade = new JLabel("Digite a raridade:");
		JLabel tipo = new JLabel("Digite o tipo:");

		
		JPanel titulo = new JPanel();
		JPanel titulo2 = new JPanel();
		JPanel titulo3 = new JPanel();

public Janelapokemon () {
	
	//Novo JPanel para adicionar texto
	titulo.setBounds(280, 70, 230, 30);
	add(titulo);
	
	//Novo JPanel para adicionar texto
	titulo2.setBounds(280, 170, 230, 30);
	add(titulo2);
	
	//Novo JPanel para adicionar texto
	titulo3.setBounds(280, 270, 230, 30);
	add(titulo3);
	
	
	
	//JLabel que sera colocada no Panel acima
	nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo.add(nome);
	
	//Jlabel que sera colocado no Panel acima
	raridade.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo2.add(raridade);
	
	//Jlabel que sera colocado no Panel acima
	tipo.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo3.add(tipo);
	
	
	//JTextField para coletar o nome do pokemon 
	campname.setBounds(280, 100, 230, 30);
	add(campname);

	camprari.setBounds(280, 200, 230, 30);
	add(camprari);
	
	camptipo.setBounds(280, 300, 230, 30);
	add(camptipo);
	
	setTitle("Album do Pokemon "  );
	setLayout(null);
	setSize(800, 500);
	setLocationRelativeTo(null);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

}

}