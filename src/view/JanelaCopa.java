package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCopa extends JFrame{
		JPanel ptxt = new JPanel();
		JTextField campnamefut = new JTextField();
		JTextField camprarifut = new JTextField();
		JTextField campalturafut = new JTextField();
		JTextField campnascfut = new JTextField();
		JTextField campselecaofut = new JTextField();
		JTextField camppesofut = new JTextField();
		JLabel nome = new JLabel("Digite o nome do Jogador:");
		JLabel raridade = new JLabel("Digite a Raridade:");
		JLabel altura = new JLabel("Digite a Altura:");
		JLabel nascimento = new JLabel("Digite a Data de Nascimento:");
		JLabel selecao = new JLabel("Digite a Seleção:");
		JLabel peso = new JLabel("Digite o Peso:");

		
		JPanel titulo = new JPanel();
		JPanel titulo2 = new JPanel();
		JPanel titulo3 = new JPanel();
		JPanel titulo4 = new JPanel();
		JPanel titulo5 = new JPanel();
		JPanel titulo6 = new JPanel();

public JanelaCopa () {


	
	//Novo JPanel para adicionar texto
	titulo.setBounds(70, 10, 230, 30);
	add(titulo);
	
	//Novo JPanel para adicionar texto
	titulo2.setBounds(70, 70, 230, 30);
	add(titulo2);
	
	//Novo JPanel para adicionar texto
	titulo3.setBounds(70, 130, 230, 30);
	add(titulo3);
	
	titulo4.setBounds(70, 200, 230, 30);
	add(titulo4);
	
	//Novo JPanel para adicionar texto
	titulo5.setBounds(70, 260, 230, 30);
	add(titulo5);
	
	//Novo JPanel para adicionar texto
	titulo6.setBounds(70, 320, 230, 30);
	add(titulo6);
	
	
	
	//JLabel que sera colocada no Panel acima
	nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo.add(nome);
	
	//Jlabel que sera colocado no Panel acima
	raridade.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo2.add(raridade);
	
	//Jlabel que sera colocado no Panel acima
	altura.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo3.add(altura);
	
	//Jlabel que sera colocado no Panel acima
	nascimento.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo4.add(nascimento);
	
	//Jlabel que sera colocado no Panel acima
	selecao.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo5.add(selecao);
	
	//Jlabel que sera colocado no Panel acima
	peso.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
	titulo6.add(peso);
	
    


	//JTextField para coletar o nome do pokemon 
	campnamefut.setBounds(70, 40, 230, 30);
	add(campnamefut);

	camprarifut.setBounds(70, 100, 230, 30);
	add(camprarifut);
	
	campalturafut.setBounds(70, 160, 230, 30);
	add(campalturafut);
	
	campnascfut.setBounds(70, 230, 230, 30);
	add(campnascfut);

	campselecaofut.setBounds(70, 290, 230, 30);
	add(campselecaofut);
	
	camppesofut.setBounds(70, 350, 230, 30);
	add(camppesofut);
	
	setTitle("Album Da Copa Do Mundo"  );
	setLayout(null);
	setSize(400, 500);
	setLocationRelativeTo(null);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

}

}
