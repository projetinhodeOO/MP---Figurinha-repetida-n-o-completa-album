package view;

import java.awt.*;
import javax.swing.*;
public class JaneladePergunta extends JFrame{
		
		JTextField campname = new JTextField();

		JLabel nome = new JLabel("Deseja excluir ?");
		JPanel titulo = new JPanel();


public JaneladePergunta () {
	
	//Novo JPanel para adicionar texto
	titulo.setBounds(25, 20, 230, 30);
	add(titulo);

	//JLabel que sera colocada no Panel acima
	nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo.add(nome);
	
	setTitle("Exclusão de Album"  );
	setLayout(null);
	setSize(300, 200);
	setLocationRelativeTo(null);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

}

}