package view;

import java.awt.*;
import javax.swing.*;

public class JanelaCriar extends JFrame {
	JPanel ptxt = new JPanel();
	JLabel sel = new JLabel("Selecione o tipo de album:");
	JComboBox<String> albuns = new JComboBox<String>();
	JPanel pnome = new JPanel();
	JLabel nome = new JLabel("Digite um nome para seu album:");
	JTextField campotxt = new JTextField();
	
	public JanelaCriar() {
		//JPanel para colocar texto
		ptxt.setBounds(15, 30, 200, 30);
		add(ptxt);
		
		//JLabel que sera colocada no Panel acima
		sel.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		ptxt.add(sel);
		
		//Lista dos tipos de album
		albuns.setBounds(20, 60, 160, 30);
		albuns.addItem("Copa do Mundo Qatar");
		albuns.addItem("Yu-Gi-Oh!");
		albuns.addItem("Pokemon");
		add(albuns);
		
		//Novo JPanel para adicionar texto
		pnome.setBounds(420, 30, 250, 30);
		add(pnome);
		
		//JLabel que sera adicinada no Panel acima
		nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		pnome.add(nome);
		
		//JTextField para coletar o nome do album
		campotxt.setBounds(430, 60, 230, 30);
		add(campotxt);
		
		setTitle("Criar album");
		setLayout(null);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
