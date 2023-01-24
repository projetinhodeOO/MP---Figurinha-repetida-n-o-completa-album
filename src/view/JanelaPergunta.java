package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controllers.ControleAlbumFigurinha;
import model.Album;
import model.CopaDoMundoQatar;
import model.Pokemon;
import model.Yugioh;

/**
 * A classe JanelaPergunta exibe uma janela de pergunta para confirmar se o
 * usuario deseja prosseguir com uma exclusao e, caso deseje, efetuala.
 * @author Manoel Felipe Teixeira Neto
 * @since 2023
 */
public class JanelaPergunta extends JFrame {
	JLabel qst = new JLabel("Deseja prosseguir com a exclusao?");
	JPanel pQst = new JPanel();

	public JanelaPergunta () {
	
		//Novo JPanel para adicionar texto
		pQst.setBounds(25, 20, 230, 30);
		add(pQst);

		//JLabel que sera colocada no Panel acima
		qst.setFont(new Font("Arial", Font.CENTER_BASELINE, 13));
		pQst.add(qst);
		
		setTitle("Exclusão");
		setLayout(null);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Metodo para identificar os eventos de "sim" e "nao" de seus respectivos 
	 * botoes. Deve ser usado para excluir um Album.
	 * @param album que deseja excluir
	 */
	public void respostasBotoes(Album album) {
		// Botao do sim
		JButton sim = new JButton("Sim");
		sim.setBounds(25, 70, 90, 30);
		add(sim);
			
		//Botao do não
		JButton nao = new JButton("Não");
		nao.setBounds(170, 70, 90, 30);
		add(nao);
				
		ActionListener buttonListener1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
				if(controle.apagarAlbum(album) == true) {
					JOptionPane.showMessageDialog(null, "Album excluido com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Album nao encontrado");
				}
				JanelaGerenciar gerenciar = new JanelaGerenciar();
				dispose();
			}
		};
		ActionListener buttonListener2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Exclusao cancelada");
				JanelaGerenciar gerenciar = new JanelaGerenciar();
				dispose();
			}
		};
		sim.addActionListener(buttonListener1);
		nao.addActionListener(buttonListener2);
	}
	
	/**
	 * Metodo para identificar os eventos de "sim" e "nao" de seus respectivos 
	 * botoes. Deve ser usado para excluir uma figurinha de determinado album.
	 * @param album que se encontra a figurinha
	 * @param nome da figurinha que deseja excluir
	 */
	public void deletarFigurinhaBotao(Album album, String nome) {
		// Botao do sim
		JButton sim = new JButton("Sim");
		sim.setBounds(25, 70, 90, 30);
		add(sim);
					
		//Botao do não
		JButton nao = new JButton("Não");
		nao.setBounds(170, 70, 90, 30);
		add(nao);
		ActionListener buttonListener1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
				if(album.getTipo().equals("copa")) {
					CopaDoMundoQatar fig = new CopaDoMundoQatar();
					fig.setNome(nome);
					if(controle.deletarFigurinha(album, fig) == true) {
						JOptionPane.showMessageDialog(null, "Figurinha deletada com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Falha em deletar figurinha");
					}
					dispose();
				} else if(album.getTipo().equals("pokemon")) {
					Pokemon fig = new Pokemon();
					fig.setNome(nome);
					if(controle.deletarFigurinha(album, fig) == true) {
						JOptionPane.showMessageDialog(null, "Figurinha deletada com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Falha em deletar figurinha");
					}
					dispose();
				} else if(album.getTipo().equals("yugioh")) {
					Yugioh fig = new Yugioh();
					fig.setNome(nome);
					if(controle.deletarFigurinha(album, fig) == true) {
						JOptionPane.showMessageDialog(null, "Figurinha deletada com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Falha em deletar figurinha");
					}
					ListaFigurinha menuFig = new ListaFigurinha(album);
					dispose();
				}
			}
		};
		ActionListener buttonListener2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Exclusao cancelada");
				ListaFigurinha menuFig = new ListaFigurinha(album);
				dispose();
			}
		};
		sim.addActionListener(buttonListener1);
		nao.addActionListener(buttonListener2);
	}
}