package view;

import java.awt.*;
import javax.swing.*;

public class JanelaGerenciar extends JFrame{
	JPanel ptxt = new JPanel();
	JLabel label = new JLabel("Seus albuns:");
	JComboBox<String> albuns = new JComboBox<String>();
	
	public JanelaGerenciar() {
		//JPanel para colocar texto
		add(ptxt);
		ptxt.setBounds(15, 30, 100, 30);

        //JLabel que sera colocada no Panel acima
        ptxt.add(label);
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        
		//Lista dos tipos de album
		albuns.setBounds(20, 60, 160, 30);
		albuns.addItem("Copa do Mundo Qatar");
		albuns.addItem("Yu-Gi-Oh!");
		albuns.addItem("Pokemon");
		add(albuns);
        
    
        
        setTitle("Gerenciar album");
		setLayout(null);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}