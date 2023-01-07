package view;

import java.awt.*;
import javax.swing.*;

public class ListadeFigurinha extends JFrame{
	JPanel ptxt = new JPanel(); 
	JLabel nome = new JLabel("Suas figurinhas");
	JComboBox<String> lista = new JComboBox<String>();


	JPanel titulo = new JPanel();
	
	
	
	public ListadeFigurinha() {


		//Novo JPanel para adicionar texto
		titulo.setBounds(70, 10, 230, 30);
		add(titulo);
		
		
		//JLabel que sera colocada no Panel acima
		nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo.add(nome);
		
		//Lista dos tipos de album
		lista.setBounds(100, 50, 160, 30);
		lista.addItem("Neymar");
		lista.addItem("Olhos Azuis");
		lista.addItem("Pikachu");
		add(lista);

        
        
		setTitle("Suas figurinhas");
		setLayout(null);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}