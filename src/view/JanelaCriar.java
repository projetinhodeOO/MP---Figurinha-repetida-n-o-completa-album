package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import controllers.ControleAlbumFigurinha;
import model.Album;

/**
 * A classe JanelaCriar exibe uma janela, a qual sera responsavel por exibir as informacoes
 * que irao auxiliar o usuario a adicionar um novo album para a aplicacao.
 * @author Manoel Felipe Teixeira Neto
 * @since 2023
 */
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
		albuns.addItem("copa");
		albuns.addItem("yugioh");
		albuns.addItem("pokemon");
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

		//JTextField para coletar os do do album
		campotxt.setBounds(80, 180, 230, 30);
		add(campotxt);

		campano.setBounds(140, 260, 100, 30);
		add(campano);
		
		campqtd_total.setBounds(140, 340, 100, 30);
		add(campqtd_total);
		
		//Botao para finalizar a criacao
		JButton btnCriar = new JButton("Criar");
		add(btnCriar);
		btnCriar.setBounds(140, 400, 100, 30);
		
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Caso algum campo tenha ficado sem ser preenchido aparecerra uma mensagem lembrando o usuario
				if("".equals(campotxt.getText()) || "".equals(campano.getText()) || "".equals(campqtd_total.getText())) {
					JOptionPane.showMessageDialog(null, "Preencha todos os dados");
				} else {
					if(Integer.parseInt(campqtd_total.getText()) > 1000) {
						JOptionPane.showMessageDialog(null, "Limite maximo de figurinhas: 1000");
					} else {
						//Caso ele tenha preechido tudo, os dados serao coletados e armazenados em um novo abjeto a ser adicionado
						String name, tipo, ano, qtd_total ;
						name = campotxt.getText();
						tipo = (String) albuns.getSelectedItem();
						ano = campano.getText();
						qtd_total = campqtd_total.getText();
						int anoConvertido = Integer.parseInt(ano);
						int qtdConvertido = Integer.parseInt(qtd_total);
						
						Album alb = new Album();
						alb.setNome(name);
						alb.setTipo(tipo);
						alb.setAno(anoConvertido);
						alb.setQtd_figurinha_total(qtdConvertido);	
						
						ControleAlbumFigurinha objalbum = new ControleAlbumFigurinha();
						if(objalbum.addAlbum(alb) == true) {
							JOptionPane.showMessageDialog(null, "Album criado com sucesso");
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao criar album. Verifique se o limite de 10 albuns foi excedido ou se ja nao existe um album com esse nome");
						}
					}
				}	
			}
		
		});
		
		setTitle("Criar album");
		setLayout(null);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}