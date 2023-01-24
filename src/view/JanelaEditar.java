package view;

import javax.swing.*;

import controllers.ControleAlbumFigurinha;
import model.Album;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A classe JanelaEditar exibe as informacoes necessarias para o usuario poder mudar os dados
 * de um album ja adicionado anteriormente.
 * @author Manoel Felipe Teixeira Neto
 * @since 2023
 */
public class JanelaEditar extends JFrame {
	//JTextFields
	JTextField nome = new JTextField();
	JTextField ano = new JTextField();
	JTextField qtdFig = new JTextField();
	//JLabels
	JLabel LNome = new JLabel("Mudar nome:");
	JLabel LAno = new JLabel("Mudar ano de publicação:");
	JLabel LQtdFig = new JLabel("Mudar o limite de figurinhas:");
	//JPanels
	//JPanel ptxt = new JPanel();
	JPanel PNome = new JPanel();
	JPanel PAno = new JPanel();
	JPanel PQtdFig = new JPanel();
	
	public JanelaEditar(String n) {
		//Adicionando os JPanels
		PNome.setBounds(65, 30, 250, 30);
		add(PNome);
		PAno.setBounds(90, 105, 200, 30);
		add(PAno);
		PQtdFig.setBounds(90, 175, 200, 30);
		add(PQtdFig);
		
		//Adicionando as JLabels
		LNome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		PNome.add(LNome);
		LAno.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		PAno.add(LAno);
		LQtdFig.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		PQtdFig.add(LQtdFig);
		
		//Adicionando as JTextFields
		nome.setBounds(140, 60, 100, 30);
		add(nome);
		ano.setBounds(140, 135, 100, 30);
		add(ano);
		qtdFig.setBounds(140, 205, 100, 30);
		add(qtdFig);
		
		//botao para salvar as alterações
		JButton btnSave = new JButton("Salvar");
		add(btnSave);
		btnSave.setBounds(140, 400, 100, 30);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Caso algum campo tenha ficado sem ser preenchido aparecerra uma mensagem lembrando o usuario
				if("".equals(nome.getText()) || "".equals(ano.getText()) || "".equals(qtdFig.getText())) {
					JOptionPane.showMessageDialog(null, "Preencha todos os dados");
				} else {
					//Caso ele tenha preechido tudo, os dados serao coletados e armazenados em um novo abjeto a ser adicionado
					String name, year, figs;
					name = nome.getText();
					year = ano.getText();
					figs = qtdFig.getText();
					int anoConvertido = Integer.parseInt(year);
					int qtdConvertido = Integer.parseInt(figs);
					
					ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
					Album alb = new Album();
					String tipo = controle.resgataAlbum(n).getTipo();
					int qtdFigurinha = controle.resgataAlbum(n).getQtd_figurinha();
					alb.setNome(name);
					alb.setTipo(tipo);
					alb.setAno(anoConvertido);
					alb.setQtd_figurinha_total(qtdConvertido);
					alb.setQtd_figurinha(qtdFigurinha);
					
					if(controle.attAlbum(alb, n) == true) {
						JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso");
						dispose();
					}
				}
			}
		});
		
		setTitle("Editar Album");
		setLayout(null);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}
