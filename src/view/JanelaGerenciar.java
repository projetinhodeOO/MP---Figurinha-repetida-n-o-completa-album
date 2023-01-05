package view;

import java.awt.*;
import javax.swing.*;

public class JanelaGerenciar extends JFrame{
	JPanel ptxt = new JPanel();
	JLabel label = new JLabel("Seus albuns:");
	
	String[] albuns = {"Copa do Mundo Qatar", "Yu-Gi-Oh!", "Pokemon"};
	
	public JanelaGerenciar() {
		//JPanel para colocar texto
		add(ptxt);
		ptxt.setBounds(15, 30, 100, 30);

        //JLabel que sera colocada no Panel acima
        ptxt.add(label);
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        
        //Lista de albuns para gerenciar
        JList lista = new JList(albuns);
        add(lista);
        lista.setBounds(20, 60, 150, 100);
        
        setTitle("Gerenciar album");
		setLayout(null);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
