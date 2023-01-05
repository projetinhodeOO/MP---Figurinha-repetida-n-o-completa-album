package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaYugioh extends JFrame{
		JPanel ptxt = new JPanel();
		JTextField campnameyu = new JTextField();
		JTextField camprariyu = new JTextField();
		JTextField camptipoyu = new JTextField();
		JTextField campatkyu = new JTextField();
		JTextField campdefyu = new JTextField();
		JTextField camnivelyu = new JTextField();
		JLabel nome = new JLabel("Digite o nome do Monstro:");
		JLabel raridade = new JLabel("Digite a Raridade:");
		JLabel tipo = new JLabel("Digite o Tipo:");
		JLabel atk = new JLabel("Digite o Ataque:");
		JLabel def = new JLabel("Digite a Defesa:");
		JLabel nivel = new JLabel("Digite o Nivel:");
		

		
		JPanel titulo = new JPanel();
		JPanel titulo2 = new JPanel();
		JPanel titulo3 = new JPanel();
		JPanel titulo4 = new JPanel();
		JPanel titulo5 = new JPanel();
		JPanel titulo6 = new JPanel();

public JanelaYugioh () {
	
	//Novo JPanel para adicionar texto
	titulo.setBounds(280, 10, 230, 30);
	add(titulo);
	
	//Novo JPanel para adicionar texto
	titulo2.setBounds(280, 70, 230, 30);
	add(titulo2);
	
	//Novo JPanel para adicionar texto
	titulo3.setBounds(280, 130, 230, 30);
	add(titulo3);
	
	titulo4.setBounds(280, 200, 230, 30);
	add(titulo4);
	
	//Novo JPanel para adicionar texto
	titulo5.setBounds(280, 260, 230, 30);
	add(titulo5);
	
	//Novo JPanel para adicionar texto
	titulo6.setBounds(280, 320, 230, 30);
	add(titulo6);
	
	
	
	//JLabel que sera colocada no Panel acima
	nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo.add(nome);
	
	//Jlabel que sera colocado no Panel acima
	raridade.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo2.add(raridade);
	
	//Jlabel que sera colocado no Panel acima
	tipo.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo3.add(tipo);
	
	//Jlabel que sera colocado no Panel acima
	atk.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo4.add(atk);
	
	//Jlabel que sera colocado no Panel acima
	def.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo5.add(def);
	
	//Jlabel que sera colocado no Panel acima
	nivel.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo6.add(nivel);
	
	

	//JTextField para coletar o nome do pokemon 
	campnameyu.setBounds(280, 40, 230, 30);
	add(campnameyu);

	camprariyu.setBounds(280, 100, 230, 30);
	add(camprariyu);
	
	camptipoyu.setBounds(280, 160, 230, 30);
	add(camptipoyu);
	
	campatkyu.setBounds(280, 230, 230, 30);
	add(campatkyu);

	campdefyu.setBounds(280, 290, 230, 30);
	add(campdefyu);
	
	camnivelyu.setBounds(280, 350, 230, 30);
	add(camnivelyu);
	
	setTitle("Album YU-GI-OH "  );
	setLayout(null);
	setSize(800, 500);
	setLocationRelativeTo(null);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

}

}

