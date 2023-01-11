package view;

import java.awt.*;
import javax.swing.*;

public class JanelaCriar extends JFrame {
	JTextField campotxt = new JTextField();
	JTextField campano = new JTextField();
	JTextField campqtd_total = new JTextField();
	JComboBox<String> albuns = new JComboBox<String>();
	JLabel sel = new JLabel("Selecione o tipo de album:");
	JLabel nome = new JLabel("Digite um nome para seu album:");
	JLabel ano = new JLabel("Digite o ano de publicação:");
	JLabel qtd_total = new JLabel("Digite o total de figurinha:");
	
	JPanel ptxt = new JPanel();
	JPanel pnome = new JPanel();
	JPanel pano = new JPanel();
	JPanel pqtd_total = new JPanel();
	public JanelaCriar() {

		//Lista dos tipos de album
		albuns.setBounds(115, 60, 160, 30);
		albuns.addItem("Copa do Mundo Qatar");
		albuns.addItem("Yu-Gi-Oh!");
		albuns.addItem("Pokemon");
		add(albuns);
		
		//JPanel para colocar texto
		ptxt.setBounds(90, 30, 200, 30);
		add(ptxt);

		pnome.setBounds(70, 150, 250, 30);
		add(pnome);

		pano.setBounds(90, 225, 200, 30);
		add(pano);
		
		pqtd_total.setBounds(90, 300, 200, 30);
		add(pqtd_total);
		
		
	
		nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		pnome.add(nome);

		
		ano.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		pano.add(ano);
		
		
		qtd_total.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		pqtd_total.add(qtd_total);
		
		
		sel.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		ptxt.add(sel);

		//JTextField para coletar o nome do album
		campotxt.setBounds(80, 180, 230, 30);
		add(campotxt);

		campano.setBounds(140, 260, 100, 30);
		add(campano);
		
		campqtd_total.setBounds(140, 340, 100, 30);
		add(campqtd_total);
		
		setTitle("Criar album");
		setLayout(null);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
