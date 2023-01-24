package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import controllers.ControleAlbumFigurinha;
import model.Album;

/**
 * A classe DadosFigurinha exibe uma janela contendo uma JTextArea que armazena a String 
 * retornada pelo metodo toString da classe ControleAlbumFigurinha do pacote controllers.
 * @see controllers.ControleAlbumFigurinha.toString
 * @author Vinicius Eduardo Muniz da Silva
 * @since 2023
 */
public class DadosFigurinha extends JFrame {
	private String texto;
	public DadosFigurinha(Album album, String nome) {
		ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
		
		texto = controle.toString(album, nome);
		
		JTextArea dados = new JTextArea(texto);
		dados.setFont(new Font("Comfortaa", Font.CENTER_BASELINE, 20));
		add(dados);
		dados.setBounds(0, 0, 400, 500);
		dados.setEditable(false);
		
		setTitle("Dados figurinha");
		setLayout(null);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
