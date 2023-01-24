package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import controllers.ControleAlbumFigurinha;

/**
 * A classe ListaFigurinha exibe uma tela contendo uma JComboBox com todas as figurinhas
 * cadastradas no album analizado e quatro botoes para realizarem a funcao de adicionar,
 * editar, excluir e listar os atributos de determinada figurinha.
 * @see JanelaFigurinha
 * @see JanelaPergunta
 * @see DadosFigurinha
 * @author Manoel Felipe Teixeira Neto
 * @since 2023
 */
public class ListaFigurinha extends JFrame {
	JLabel nome = new JLabel("Suas figurinhas");
	JComboBox<String> lista = new JComboBox<String>();
	JPanel titulo = new JPanel();
	JPanel qtdFigs = new JPanel();
	JPanel ano = new JPanel();
	private String texto;
	private String anoTxt;
	
	public ListaFigurinha(Album album) {

		//Novo JPanel para adicionar texto
		titulo.setBounds(70, 10, 230, 30);
		add(titulo);
		
		//JLabel que sera colocada no Panel acima
		nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo.add(nome);
		
		//Lista dos tipos de album
		lista.setBounds(100, 50, 160, 30);
		add(lista);
		
		//Adicionando a lista de figurinhas do album na JComboBox
		int qtd = album.getQtd_figurinha();
		if(qtd > 0) {
			ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
			album.setQtd_figurinha(0);
			for(int i = 0; i < qtd; i++) {
				lista.addItem(controle.listarFigurinhas(album, i));
			}
		} else {
			lista.addItem("Nenhuma figurinha");
		}
		
		reacaoBotoes(album);
		
		//Adicionando a quantidade de figurinhas presentes no album
		texto = qtd+"/"+album.getQtd_figurinha_total()+" figurinhas";
		JLabel qtdFigsTxt = new JLabel(texto);
		qtdFigsTxt.setFont(new Font("Arial", Font.CENTER_BASELINE, 13));
		qtdFigs.setBounds(20, 400, 130, 30);
		qtdFigs.add(qtdFigsTxt);
		add(qtdFigs);
		
		//Adicionando o ano do album
		anoTxt = "Ano de publicacao: "+album.getAno();
		JLabel labelAno = new JLabel(anoTxt);
		labelAno.setFont(new Font("Arial", Font.CENTER_BASELINE, 13));
		ano.setBounds(200, 400, 160, 30);
		ano.add(labelAno);
		add(ano);
		
		setTitle("Suas figurinhas");
		setLayout(null);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Metodo para realiazar a funcao desejada no evento de seus respectivos botoes. 
	 * Quando as opcoes de adicionar ou editar figurinha forem selecionadas uma nova
	 * JanelaFigurinha sera criada e o metodo mais adequando sera chamado. Quando a
	 * opcao de excluir figurinha for selecionada a exclusao sera efetuada e quando a
	 * opcao de listar figurinha for selecionada uma janela da classe DadosFigurinha
	 * sera criada e exibira os atributos da figurinha selecionada.
	 * @param a que eh o album analizado
	 */
	public void reacaoBotoes(Album a) {
		//Adicionando os botoes da tela
		JButton btnAdd = new JButton("Adicionar figurinha");
		btnAdd.setBounds(100, 100, 160, 30);
		add(btnAdd);
		JButton btnAtt = new JButton("Editar figurinha");
		btnAtt.setBounds(100, 160, 160, 30);
		add(btnAtt);
		JButton btnDel = new JButton("Deletar figurinha");
		btnDel.setBounds(100, 220, 160, 30);
		add(btnDel);
		JButton btnList = new JButton("Listar figurinha");
		btnList.setBounds(100, 280, 160, 30);
		add(btnList);
		
		//Acao do botao criar
		ActionListener buttonListener1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a.getTipo().equals("copa")) {
					JanelaFigurinha criar = new JanelaFigurinha();
					criar.addCopa(a);
					dispose();
				} else if(a.getTipo().equals("pokemon")) {
					JanelaFigurinha criar = new JanelaFigurinha();
					criar.addPokemon(a);
					dispose();
				} else if(a.getTipo().equals("yugioh")) {
					JanelaFigurinha criar = new JanelaFigurinha();
					criar.addYugioh(a);
					dispose();
				}
			}
		};
		//Acao do botao atualizar
		ActionListener buttonListener2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = (String)lista.getSelectedItem();
				if(a.getTipo().equals("copa")) {
					JanelaFigurinha att = new JanelaFigurinha();
					att.attCopa(a, nome);
					dispose();
				} else if(a.getTipo().equals("pokemon")) {
					JanelaFigurinha att = new JanelaFigurinha();
					att.attPokemon(a, nome);
					dispose();
				} else if(a.getTipo().equals("yugioh")) {
					JanelaFigurinha att = new JanelaFigurinha();
					att.attYugioh(a, nome);
					dispose();
				}
			}
			
		};
		//Acao do botao deletar
		ActionListener buttonListener3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = (String)lista.getSelectedItem();
				JanelaPergunta del = new JanelaPergunta();
				del.deletarFigurinhaBotao(a, nome);
				dispose();
			}
		};
		//Botao para listar os dados da figurinha
		ActionListener buttonListener4 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = (String)lista.getSelectedItem();
				DadosFigurinha dados = new DadosFigurinha(a, nome);
			}
		};
		btnAdd.addActionListener(buttonListener1);
		btnAtt.addActionListener(buttonListener2);
		btnDel.addActionListener(buttonListener3);
		btnList.addActionListener(buttonListener4);
	}
}
