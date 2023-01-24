package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.ControleAlbumFigurinha;
import model.Album;
import model.CopaDoMundoQatar;
import model.Pokemon;
import model.Yugioh;

/**
 * A classe JanelaFigurinha eh uma janela responsavel por exibir as informacoes que
 * irao auxiliar o usuario a adicionar e editar os dados de uma figurinha, porem os 
 * mesmos so serao possiveis usando o metodo certo.
 * @author Manoel Felipe Teixeira Neto, Vinicius Eduardo Muniz da Silva
 * @since 2023
 */
public class JanelaFigurinha extends JFrame{
	//Campos de testo onde serao coletados os atributos das figurinhas	
	JTextField campName = new JTextField();
	JTextField campRari = new JTextField();
	JTextField campTipo = new JTextField();
	JTextField campAltura = new JTextField();
	JTextField campNasc = new JTextField();
	JTextField campSelecao = new JTextField();
	JTextField campPeso = new JTextField();
	JTextField campAtk = new JTextField();
	JTextField campDef = new JTextField();
	JTextField campNivel = new JTextField();
		
	//Labels indicando o atributo a ser escrito nos JTextFields
	JLabel nome = new JLabel();
	JLabel raridade = new JLabel("Digite a raridade:");
	JLabel tipo = new JLabel("Digite o tipo:");
	JLabel altura = new JLabel("Digite a Altura:");
	JLabel nascimento = new JLabel("Digite a Data de Nascimento:");
	JLabel selecao = new JLabel("Digite a Seleção:");
	JLabel peso = new JLabel("Digite o Peso:");
	JLabel atk = new JLabel("Digite o Ataque:");
	JLabel def = new JLabel("Digite a Defesa:");
	JLabel nivel = new JLabel("Digite o Nivel:");
		
	//JPanels para conter as JLabels
	JPanel titulo = new JPanel();
	JPanel titulo2 = new JPanel();
	JPanel titulo3 = new JPanel();
	JPanel titulo4 = new JPanel();
	JPanel titulo5 = new JPanel();
	JPanel titulo6 = new JPanel();

	public JanelaFigurinha() {	
		
		setTitle("Atualizar figurinha");
		setLayout(null);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * O metodo attPokemon tem a funcao de configurar a janela para exibir as informacoes que irao
	 * ajudar o usuario a atualizar os dados de uma figurinha em um album do tipo "pokemon".
	 * @param album que se encontra a figurinha
	 * @param n que eh o nome da figurinha
	 */
	public void attPokemon (Album album, String n) {
		//Novo JPanel para adicionar texto
		titulo.setBounds(85, 50, 230, 30);
		add(titulo);
		titulo2.setBounds(85, 150, 230, 30);
		add(titulo2);
		titulo3.setBounds(85, 250, 230, 30);
		add(titulo3);
		
		//JLabel que sera colocada no Panel acima
		nome.setText("Digite o nome do pokemon:");
		nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo.add(nome);
		raridade.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo2.add(raridade);
		tipo.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo3.add(tipo);
	
		//JTextField para coletar os dados do pokemon 
		campName.setBounds(85, 80, 230, 30);
		add(campName);
		campRari.setBounds(85, 180, 230, 30);
		add(campRari);
		campTipo.setBounds(85, 280, 230, 30);
		add(campTipo);
		
		//Botao de criar a figurinha
		JButton btnAtt = new JButton("Salvar");
		btnAtt.setBounds(100, 350, 200, 30);
		add(btnAtt);
		
		btnAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
				if(campName.getText().equals("") || campRari.getText().equals("") || campTipo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os dados");
				} else {
					//Estanciando uma nova figurinha para ser atualizada
					Pokemon fig = new Pokemon();
					fig.setNome(campName.getText());
					fig.setRaridade(campRari.getText());
					fig.setTipo(campTipo.getText());
					
					//Atualizando a figurinha
					if(controle.attFigurinha(album, fig, n) == true) {
						JOptionPane.showMessageDialog(null, "Figurinha atualizada com sucesso");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar a figurinha");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					}
				}
			}
		});
	}
	
	/**
	 * O metodo attCopa tem a funcao de configurar a janela para exibir as informacoes que irao
	 * ajudar o usuario a atualizar os dados de uma figurinha em um album do tipo "copa".
	 * @param album que se encontra a figurinha
	 * @param n que eh o nome da figurinha
	 */
	public void attCopa(Album album, String n) {
		//Novo JPanels para adicionar texto
		titulo.setBounds(85, 10, 230, 30);
		add(titulo);
		titulo2.setBounds(85, 70, 230, 30);
		add(titulo2);
		titulo3.setBounds(85, 130, 230, 30);
		add(titulo3);
		titulo4.setBounds(85, 200, 230, 30);
		add(titulo4);
		titulo5.setBounds(85, 260, 230, 30);
		add(titulo5);
		titulo6.setBounds(85, 320, 230, 30);
		add(titulo6);
				
		//JLabels que serao colocadas nos Paneis acima
		nome.setText("Digite o nome do jogador:");
		nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo.add(nome);
		raridade.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo2.add(raridade);
		altura.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo3.add(altura);
		nascimento.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo4.add(nascimento);
		selecao.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo5.add(selecao);
		peso.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo6.add(peso);
			
		//JTextField para coletar o nome do jogador 
		campName.setBounds(85, 40, 230, 30);
		add(campName);
		campRari.setBounds(85, 100, 230, 30);
		add(campRari);
		campAltura.setBounds(85, 160, 230, 30);
		add(campAltura);
		campNasc.setBounds(85, 230, 230, 30);
		add(campNasc);
		campSelecao.setBounds(85, 290, 230, 30);
		add(campSelecao);
		campPeso.setBounds(85, 350, 230, 30);
		add(campPeso);
				
		//Botao de criar a figurinha
		JButton btnAtt = new JButton("Salvar");
		btnAtt.setBounds(100, 400, 200, 30);
		add(btnAtt);
						
		btnAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
				if(campName.getText().equals("") || campRari.getText().equals("") || campAltura.getText().equals("") ||
				campNasc.getText().equals("") || campSelecao.getText().equals("") || campPeso.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os dados");
				} else {
					//Estanciando uma nova figurinha para ser adicionada
					CopaDoMundoQatar fig = new CopaDoMundoQatar();
					fig.setNome(campName.getText());
					fig.setRaridade(campRari.getText());
					fig.setAltura(Double.parseDouble(campAltura.getText()));
					fig.setNascimento(campNasc.getText());
					fig.setSelecao(campSelecao.getText());
					fig.setPeso(Double.parseDouble(campPeso.getText()));
									
					//Atualizando os dados da figurinha
					if(controle.attFigurinha(album, fig, n) == true) {
						JOptionPane.showMessageDialog(null, "Figurinha atualizada com sucesso");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar a figurinha");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					}
				}
			}
		});
	}
	
	/**
	 * O metodo attYugioh tem a funcao de configurar a janela para exibir as informacoes que irao
	 * ajudar o usuario a atualizar os dados de uma figurinha em um album do tipo "yugioh".
	 * @param album que se encontra a figurinha
	 * @param n que eh o nome da figurinha
	 */
	public void attYugioh(Album album, String n) {
		//Novo JPanel para adicionar texto
		titulo.setBounds(85, 10, 230, 30);
		add(titulo);
		titulo2.setBounds(85, 70, 230, 30);
		add(titulo2);
		titulo3.setBounds(85, 130, 230, 30);
		add(titulo3);
		titulo4.setBounds(85, 200, 230, 30);
		add(titulo4);
		titulo5.setBounds(85, 260, 230, 30);
		add(titulo5);
		titulo6.setBounds(85, 320, 230, 30);
		add(titulo6);
				
		//JLabel que sera colocada no Panel acima
		nome.setText("Digite o nome do monstro:");
		nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo.add(nome);
		raridade.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo2.add(raridade);
		tipo.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo3.add(tipo);
		atk.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo4.add(atk);
		def.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo5.add(def);
		nivel.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo6.add(nivel);
			
		//JTextField para coletar o nome do pokemon 
		campName.setBounds(85, 40, 230, 30);
		add(campName);
		campRari.setBounds(85, 100, 230, 30);
		add(campRari);
		campTipo.setBounds(85, 160, 230, 30);
		add(campTipo);
		campAtk.setBounds(85, 230, 230, 30);
		add(campAtk);
		campDef.setBounds(85, 290, 230, 30);
		add(campDef);
		campNivel.setBounds(85, 350, 230, 30);
		add(campNivel);
				
		//Botao de criar a figurinha
		JButton btnAtt = new JButton("Salvar");
		btnAtt.setBounds(100, 400, 200, 30);
		add(btnAtt);
								
		btnAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
				if(campName.getText().equals("") || campRari.getText().equals("") || campTipo.getText().equals("") ||
				campAtk.getText().equals("") || campDef.getText().equals("") || campNivel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os dados");
				} else {
					//Estanciando uma nova figurinha para ser atualizada
					Yugioh fig = new Yugioh();
					fig.setNome(campName.getText());
					fig.setRaridade(campRari.getText());
					fig.setTipo(campTipo.getText());
					fig.setAtk(Integer.parseInt(campAtk.getText()));
					fig.setDef(Integer.parseInt(campDef.getText()));
					fig.setNivel(Integer.parseInt(campNivel.getText()));
											
					//Atualizando a figurinha no album desejado
					if(controle.attFigurinha(album, fig, n) == true) {
						JOptionPane.showMessageDialog(null, "Figurinha atualizada com sucesso");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar a figurinha");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					}
				}
			}
		});
	}
	
	/**
	 * O metodo addPokemon tem a funcao de configurar a janela para exibir as informacoes que irao
	 * ajudar o usuario a adicionar uma nova figurinha no album do tipo "pokemon" desejado.
	 * @param album que deseja adicionar a figurinha
	 */
	public void addPokemon (Album album) {
		//Novo JPanel para adicionar texto
		titulo.setBounds(85, 50, 230, 30);
		add(titulo);
		titulo2.setBounds(85, 150, 230, 30);
		add(titulo2);
		titulo3.setBounds(85, 250, 230, 30);
		add(titulo3);
		
		//JLabel que sera colocada no Panel acima
		nome.setText("Digite o nome do pokemon:");
		nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo.add(nome);
		raridade.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo2.add(raridade);
		tipo.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo3.add(tipo);
	
		//JTextField para coletar os dados do pokemon 
		campName.setBounds(85, 80, 230, 30);
		add(campName);
		campRari.setBounds(85, 180, 230, 30);
		add(campRari);
		campTipo.setBounds(85, 280, 230, 30);
		add(campTipo);
		
		//Botao de criar a figurinha
		JButton btnCriar = new JButton("Salvar");
		btnCriar.setBounds(100, 350, 200, 30);
		add(btnCriar);
		
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
				if(campName.getText().equals("") || campRari.getText().equals("") || campTipo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os dados");
				} else {
					//Estanciando uma nova figurinha para ser adicionada
					Pokemon fig = new Pokemon();
					fig.setNome(campName.getText());
					fig.setRaridade(campRari.getText());
					fig.setTipo(campTipo.getText());
					
					//Adicionando a figurinha no album desejado
					if(controle.addFigurinha(album, fig) == true) {
						JOptionPane.showMessageDialog(null, "Figurinha adicionada com sucesso");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nao foi possivel adicionar a figurinha");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					}
				}
			}
		});
	
		setTitle("Figurinha Pokemon");
	}
	
	/**
	 * O metodo addPokemon tem a funcao de configurar a janela para exibir as informacoes que irao
	 * ajudar o usuario a adicionar uma nova figurinha no album do tipo "copa" desejado.
	 * @param album que deseja adicionar a figurinha
	 */
	public void addCopa(Album album) {	
		//Novo JPanels para adicionar texto
		titulo.setBounds(85, 10, 230, 30);
		add(titulo);
		titulo2.setBounds(85, 70, 230, 30);
		add(titulo2);
		titulo3.setBounds(85, 130, 230, 30);
		add(titulo3);
		titulo4.setBounds(85, 200, 230, 30);
		add(titulo4);
		titulo5.setBounds(85, 260, 230, 30);
		add(titulo5);
		titulo6.setBounds(85, 320, 230, 30);
		add(titulo6);
		
		//JLabels que serao colocadas nos Paneis acima
		nome.setText("Digite o nome do jogador:");
		nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo.add(nome);
		raridade.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo2.add(raridade);
		altura.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo3.add(altura);
		nascimento.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo4.add(nascimento);
		selecao.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo5.add(selecao);
		peso.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo6.add(peso);
	
		//JTextField para coletar o nome do jogador 
		campName.setBounds(85, 40, 230, 30);
		add(campName);
		campRari.setBounds(85, 100, 230, 30);
		add(campRari);
		campAltura.setBounds(85, 160, 230, 30);
		add(campAltura);
		campNasc.setBounds(85, 230, 230, 30);
		add(campNasc);
		campSelecao.setBounds(85, 290, 230, 30);
		add(campSelecao);
		campPeso.setBounds(85, 350, 230, 30);
		add(campPeso);
		
		//Botao de criar a figurinha
		JButton btnCriar = new JButton("Salvar");
		btnCriar.setBounds(100, 400, 200, 30);
		add(btnCriar);
				
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
				if(campName.getText().equals("") || campRari.getText().equals("") || campAltura.getText().equals("") ||
				campNasc.getText().equals("") || campSelecao.getText().equals("") || campPeso.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os dados");
				} else {
					//Estanciando uma nova figurinha para ser adicionada
					CopaDoMundoQatar fig = new CopaDoMundoQatar();
					fig.setNome(campName.getText());
					fig.setRaridade(campRari.getText());
					fig.setAltura(Double.parseDouble(campAltura.getText()));
					fig.setNascimento(campNasc.getText());
					fig.setSelecao(campSelecao.getText());
					fig.setPeso(Double.parseDouble(campPeso.getText()));
							
					//Adicionando a figurinha no album desejado
					if(controle.addFigurinha(album, fig) == true) {
						JOptionPane.showMessageDialog(null, "Figurinha adicionada com sucesso");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nao foi possivel adicionar a figurinha");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					}
				}
			}
		});
		
		setTitle("Figurinha Copa Do Mundo");
	}
	
	/**
	 * O metodo addPokemon tem a funcao de configurar a janela para exibir as informacoes que irao
	 * ajudar o usuario a adicionar uma nova figurinha no album do tipo "yugioh" desejado.
	 * @param album que deseja adicionar a figurinha
	 */
	public void addYugioh(Album album) {
		//Novo JPanel para adicionar texto
		titulo.setBounds(85, 10, 230, 30);
		add(titulo);
		titulo2.setBounds(85, 70, 230, 30);
		add(titulo2);
		titulo3.setBounds(85, 130, 230, 30);
		add(titulo3);
		titulo4.setBounds(85, 200, 230, 30);
		add(titulo4);
		titulo5.setBounds(85, 260, 230, 30);
		add(titulo5);
		titulo6.setBounds(85, 320, 230, 30);
		add(titulo6);
		
		//JLabel que sera colocada no Panel acima
		nome.setText("Digite o nome do monstro");
		nome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo.add(nome);
		raridade.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo2.add(raridade);
		tipo.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo3.add(tipo);
		atk.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo4.add(atk);
		def.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo5.add(def);
		nivel.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		titulo6.add(nivel);
	
		//JTextField para coletar o nome do pokemon 
		campName.setBounds(85, 40, 230, 30);
		add(campName);
		campRari.setBounds(85, 100, 230, 30);
		add(campRari);
		campTipo.setBounds(85, 160, 230, 30);
		add(campTipo);
		campAtk.setBounds(85, 230, 230, 30);
		add(campAtk);
		campDef.setBounds(85, 290, 230, 30);
		add(campDef);
		campNivel.setBounds(85, 350, 230, 30);
		add(campNivel);
		
		//Botao de criar a figurinha
		JButton btnCriar = new JButton("Salvar");
		btnCriar.setBounds(100, 400, 200, 30);
		add(btnCriar);
						
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
				if(campName.getText().equals("") || campRari.getText().equals("") || campTipo.getText().equals("") ||
				campAtk.getText().equals("") || campDef.getText().equals("") || campNivel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os dados");
				} else {
					//Estanciando uma nova figurinha para ser adicionada
					Yugioh fig = new Yugioh();
					fig.setNome(campName.getText());
					fig.setRaridade(campRari.getText());
					fig.setTipo(campTipo.getText());
					fig.setAtk(Integer.parseInt(campAtk.getText()));
					fig.setDef(Integer.parseInt(campDef.getText()));
					fig.setNivel(Integer.parseInt(campNivel.getText()));
									
					//Adicionando a figurinha no album desejado
					if(controle.addFigurinha(album, fig) == true) {
						JOptionPane.showMessageDialog(null, "Figurinha adicionada com sucesso");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nao foi possivel adicionar a figurinha");
						ListaFigurinha menuFig = new ListaFigurinha(album);
						dispose();
					}
				}
			}
		});
		
		setTitle("Figurinha Yu-Gi-Oh!");
	}
}