package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controllers.ControleAlbumFigurinha;
import model.Album;

/**
 * A classe JanelaGerenciar exibe uma janela que contem uma JComboBox para exibir todos os albuns cadastrados
 * e dois botoes que levarao a outras janelas, sendo elas para alterar as informacoes do album e para acessar 
 * o menu de figurinhas do album, alem de um terceiro botao para deletar o album.
 * @see JanelaEditar
 * @see ListaFigurinha
 * @author Manoel Felipe Teixeira Neto
 * @since 2023
 */
public class JanelaGerenciar extends JFrame {
	JPanel ptxt = new JPanel();
	JLabel label = new JLabel("Seus albuns:");
	JComboBox<String> albuns = new JComboBox<String>();
	
	public JanelaGerenciar() {
		ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
		//JPanel para colocar texto
		add(ptxt);
		ptxt.setBounds(15, 30, 100, 30);

        //JLabel que sera colocada no Panel acima
        ptxt.add(label);
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        
        //Lista de albuns para gerenciar
        albuns.setBounds(20, 60, 160, 30);
        int qtd = controle.getQtd_albuns();
        for(int i = 0; i < qtd; i++) {
        	albuns.addItem(controle.getAlbum(i));
        }
        add(albuns);
        
        //Botao para excluir album novo
        JButton delete= new JButton("Excluir album");
        add(delete);
        delete.setBounds(220, 400, 130, 30);
        
        //Botao para edicao de album
      	JButton btnEdit = new JButton("Editar");
      	add(btnEdit);
      	btnEdit.setBounds(60, 400, 100, 30);
      	
      	//Botao para menu de figurinhas
      	JButton btnFig = new JButton("Figurinhas");
      	btnFig.setBounds(220, 60, 100, 30);
      	add(btnFig);
        
        if(qtd > 0) {
			//Evento do botao de deletar album
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Carregando o album selecionado
			        Album album = new Album();
					album.setNome((String)albuns.getSelectedItem());
					album.setTipo(controle.resgataAlbum((String)albuns.getSelectedItem()).getTipo());
					album.setAno(controle.resgataAlbum((String)albuns.getSelectedItem()).getAno());
					album.setQtd_figurinha(controle.resgataAlbum((String)albuns.getSelectedItem()).getQtd_figurinha());
					album.setQtd_figurinha_total(controle.resgataAlbum((String)albuns.getSelectedItem()).getQtd_figurinha_total());
					
					//janela de pergunta para confirmar a exclusao do album
					JanelaPergunta pergunta = new JanelaPergunta();
					pergunta.respostasBotoes(album);
					dispose();
				}
				
			});		
			//Evento do botao de editar album	
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Carregando o album selecionado
			        Album album = new Album();
					album.setNome((String)albuns.getSelectedItem());
					album.setTipo(controle.resgataAlbum((String)albuns.getSelectedItem()).getTipo());
					album.setAno(controle.resgataAlbum((String)albuns.getSelectedItem()).getAno());
					album.setQtd_figurinha(controle.resgataAlbum((String)albuns.getSelectedItem()).getQtd_figurinha());
					album.setQtd_figurinha_total(controle.resgataAlbum((String)albuns.getSelectedItem()).getQtd_figurinha_total());
					JanelaEditar editar = new JanelaEditar(album.getNome());
					dispose();
				}
			});
			//Evento do botao de figurinhas
			btnFig.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Carregando o album selecionado
			        Album album = new Album();
					album.setNome((String)albuns.getSelectedItem());
					album.setTipo(controle.resgataAlbum((String)albuns.getSelectedItem()).getTipo());
					album.setAno(controle.resgataAlbum((String)albuns.getSelectedItem()).getAno());
					album.setQtd_figurinha(controle.resgataAlbum((String)albuns.getSelectedItem()).getQtd_figurinha());
					album.setQtd_figurinha_total(controle.resgataAlbum((String)albuns.getSelectedItem()).getQtd_figurinha_total());
					ListaFigurinha figs = new ListaFigurinha(album);
					dispose();
				}
			});
        } else {
        	albuns.addItem("Nao ha albuns cadastrados");
        }
        
        setTitle("Gerenciar album");
		setLayout(null);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
